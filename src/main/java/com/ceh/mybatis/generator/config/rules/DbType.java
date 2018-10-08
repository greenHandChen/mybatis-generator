package com.ceh.mybatis.generator.config.rules;

/**
 * Created by enHui.Chen on 2018/10/8.
 */
public enum DbType {

    MYSQL("mysql", "show table status", "show full fields from %s"),

    ORACLE("oracle", "", "");

    private String dbType;

    private String tableSql;

    private String fieldsSql;

    DbType(String dbType, String tableSql, String fieldsSql) {
        this.dbType = dbType;
        this.tableSql = tableSql;
        this.fieldsSql = fieldsSql;
    }

    public static DbType parseDbType(String dbType) {
        for (DbType parsedDbType : DbType.values()) {
            if (parsedDbType.getDbType().equals(dbType)) {
                return parsedDbType;
            }
        }
        return null;
    }

    public String getDbType() {
        return dbType;
    }

    public String getTableSql() {
        return tableSql;
    }

    public String getFieldsSql() {
        return fieldsSql;
    }
}
