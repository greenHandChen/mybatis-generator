package com.ceh.mybatis.generator.service;

import com.ceh.mybatis.generator.config.builder.ConfigBuilder;
import com.ceh.mybatis.generator.po.FieldInfo;
import com.ceh.mybatis.generator.po.TableInfo;
import freemarker.template.Configuration;
import freemarker.template.Template;
import javafx.scene.control.Tab;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.sql.DataSource;
import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by enHui.Chen on 2018/9/17.
 */
@Slf4j
@Service
public class GenerateService {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private ConfigBuilder configBuilder;

    @Autowired
    @Qualifier(value = "cuxfreemakerConfiguration")
    private Configuration configuration;

    public String generateCode(TableInfo tableInfo) {
        String classPath = this.getClass().getResource("/").getPath();
        String[] freeMakerPaths = new File(classPath).list();
        for (String freeMakerPath : freeMakerPaths) {
            if (freeMakerPath.endsWith(".ftl")) {
                BufferedWriter bufferedWriter = null;
                try {
                    Template template = configuration.getTemplate(freeMakerPath);
                    bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(processOutFile(tableInfo, freeMakerPath)))));
                    template.process(tableInfo, bufferedWriter);
                    bufferedWriter.flush();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    try {
                        bufferedWriter.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        return null;
    }

    public List<TableInfo> getAllnInfos() {
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;
        List<TableInfo> tableInfos = new ArrayList<>();
        try {
            connection = DataSourceUtils.getConnection(dataSource);
            getTableInfos(connection, pstmt, resultSet, tableInfos);
            return tableInfos;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (pstmt != null) {
                        pstmt.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                } finally {
                    if (connection != null) {
                        try {
                            connection.close();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        return null;
    }

    public void getTableInfos(Connection connection, PreparedStatement pstmt, ResultSet resultSet, List<TableInfo> tableInfos) throws SQLException {
        String tableSql = configBuilder.getDbType().getTableSql();
        pstmt = connection.prepareStatement(tableSql);
        resultSet = pstmt.executeQuery();
        while (resultSet.next()) {
            TableInfo tableInfo = new TableInfo();
            configBuilder.processTableInfo(tableInfo, resultSet);
            getFiledInfos(connection, pstmt, resultSet, tableInfo);
            tableInfos.add(tableInfo);
        }
        configBuilder.setTableInfos(tableInfos);
    }

    public void getFiledInfos(Connection connection, PreparedStatement pstmt, ResultSet resultSet, TableInfo tableInfo) throws SQLException {
        String fieldsSql = String.format(configBuilder.getDbType().getFieldsSql(), tableInfo.getTableName());
        pstmt = connection.prepareStatement(fieldsSql);
        resultSet = pstmt.executeQuery();
        List<FieldInfo> fieldInfos = new ArrayList<>();
        while (resultSet.next()) {
            FieldInfo fieldInfo = new FieldInfo();
            configBuilder.processFieldInfo(fieldInfo, resultSet);
            fieldInfos.add(fieldInfo);
        }
        tableInfo.setFieldInfos(fieldInfos);
    }

    public String processOutFile(TableInfo tableInfo, String freeMakerPath) {
        String basePath = tableInfo.getBasePath() + "\\";
        if (freeMakerPath.endsWith(".xml.ftl")) {
            basePath = "E:\\workspace\\mybatis-generator\\src\\main\\resources\\mybatis\\mapper\\";
        } else {
            String finalPath = freeMakerPath.replace("${generator}", "").replace(".java.ftl", "").toLowerCase();
            basePath += "mapper".equals(finalPath) ? "dao" : "".equals(finalPath) ? "domain" : finalPath;
        }
        File dir = new File(basePath);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        return basePath + "\\" + freeMakerPath.replace("${generator}", configBuilder.processCapFirst(tableInfo.getTableName())).replace(".ftl", "");
    }

}
