package com.ceh.mybatis.generator.config.builder;

import com.ceh.mybatis.generator.po.FieldInfo;
import com.ceh.mybatis.generator.po.TableInfo;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by enHui.Chen on 2018/9/18.
 */
public class ConfigBuilder {
    private List<TableInfo> tableInfos;

    public void processTableInfo(TableInfo tableInfo, ResultSet resultSet) throws SQLException {
        String tableName = resultSet.getString("Name");
        if (tableName != null && !"".equals(tableName)) {
            String processTableName = this.processTableName(tableName);
            tableInfo.setTableName(tableName);
            tableInfo.setControllerName(String.format("%sContoller", processTableName));
            tableInfo.setServiceName(String.format("%sService", processTableName));
            tableInfo.setMapperName(String.format("%sMapper", processTableName));
            tableInfo.setXmlName(String.format("%sMapper", processTableName));
        }

        if (resultSet.getString("Engine") != null && !"".equals(resultSet.getString("Engine"))) {
            tableInfo.setEngine(resultSet.getString("Engine"));
        }

        if (resultSet.getString("Version") != null && !"".equals(resultSet.getString("Version"))) {
            tableInfo.setVersion(resultSet.getString("Version"));
        }

        if (resultSet.getString("Comment") != null && !"".equals(resultSet.getString("Comment"))) {
            tableInfo.setComment(resultSet.getString("Comment"));
        }

        tableInfo.setRows(resultSet.getLong("Rows"));

        tableInfo.setAutoIncrement(resultSet.getLong("Auto_Increment"));
    }

    public void processFieldInfo(FieldInfo fieldInfo, ResultSet resultSet) throws SQLException {
        if (resultSet.getString("Field") != null && !"".equals(resultSet.getString("Field"))) {
            fieldInfo.setFieldName(resultSet.getString("Field"));
        }

        if (resultSet.getString("Type") != null && !"".equals(resultSet.getString("Type"))) {
            fieldInfo.setFieldDbType(resultSet.getString("Type"));
        }

        if (resultSet.getString("Null") != null && !"".equals(resultSet.getString("Null"))) {
            fieldInfo.setIsNUll(resultSet.getString("Null"));
        }

        if (resultSet.getString("Comment") != null && !"".equals(resultSet.getString("Comment"))) {
            fieldInfo.setComment(resultSet.getString("Comment"));
        }

        String key = resultSet.getString("Key");
        if (key != null && !"".equals(key)) {
            if ("PRI".equals(key)) {
                fieldInfo.setIsIdentity(true);
            } else {
                fieldInfo.setIsIdentity(false);
            }
        }
    }

    public String processTableName(String tableName) {
        return new StringBuilder().append(tableName.substring(0, 1).toUpperCase()).append(tableName.substring(1)).toString();
    }

    public void setTableInfos(List<TableInfo> tableInfos) {
        this.tableInfos = tableInfos;
    }
}
