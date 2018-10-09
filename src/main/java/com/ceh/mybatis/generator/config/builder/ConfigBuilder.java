package com.ceh.mybatis.generator.config.builder;

import com.ceh.mybatis.generator.config.convert.DbTypeConvert;
import com.ceh.mybatis.generator.config.convert.NamingRuleConverter;
import com.ceh.mybatis.generator.config.rules.DbType;
import com.ceh.mybatis.generator.po.FieldInfo;
import com.ceh.mybatis.generator.po.TableInfo;
import lombok.Data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by enHui.Chen on 2018/9/18.
 */
@Data
public class ConfigBuilder {

    private List<TableInfo> tableInfos;

    private DbType dbType;

    private NamingRuleConverter namingRuleConverter;

    private DbTypeConvert dbTypeConvert;

    public void processTableInfo(TableInfo tableInfo, ResultSet resultSet) throws SQLException {
        String tableName = resultSet.getString("Name");
        String engine = resultSet.getString("Engine");
        String version = resultSet.getString("Version");
        String comment = resultSet.getString("Comment");
        Long rows = resultSet.getLong("Rows");
        Long autoIncrement = resultSet.getLong("Auto_Increment");

        tableInfo.setPkgName("com.ceh.mybatis.test");

        if (tableName != null && !"".equals(tableName)) {
            String processTableName = this.processCapFirst(tableName);
            tableInfo.setTableName(tableName);
            tableInfo.setControllerName(String.format("%sContoller", processTableName));
            tableInfo.setServiceName(String.format("%sService", processTableName));
            tableInfo.setMapperName(String.format("%sMapper", processTableName));
            tableInfo.setXmlName(String.format("%sMapper", processTableName));
        }

        if (engine != null && !"".equals(engine)) {
            tableInfo.setEngine(engine);
        }

        if (version != null && !"".equals(version)) {
            tableInfo.setVersion(version);
        }

        if (comment != null && !"".equals(comment)) {
            tableInfo.setComment(comment);
        }

        tableInfo.setRows(rows);

        tableInfo.setAutoIncrement(autoIncrement);
    }

    public void processFieldInfo(FieldInfo fieldInfo, ResultSet resultSet) throws SQLException {
        String field = resultSet.getString("Field");
        String type = resultSet.getString("Type");
        String dbNull = resultSet.getString("Null");
        String comment = resultSet.getString("Comment");
        String key = resultSet.getString("Key");

        if (field != null && !"".equals(field)) {
            fieldInfo.setFieldName(namingRuleConverter.fieldConvert(field));
        }

        if (type != null && !"".equals(type)) {
            fieldInfo.setFieldDbType(type);
            fieldInfo.setDbFieldType(dbTypeConvert.processDbType2JavaType(type));
            fieldInfo.setViewPkg(fieldInfo.getDbFieldType().getPkg());
        }

        if (dbNull != null && !"".equals(dbNull)) {
            fieldInfo.setIsNUll(dbNull);
        }

        if (comment != null && !"".equals(comment)) {
            fieldInfo.setComment(comment);
        }

        if (key != null && !"".equals(key)) {
            if ("PRI".equals(key)) {
                fieldInfo.setIdentity(true);
            } else {
                fieldInfo.setIdentity(false);
            }
        }
    }

    public String processCapFirst(String tableName) {
        return new StringBuilder().append(tableName.substring(0, 1).toUpperCase()).append(tableName.substring(1)).toString();
    }
}
