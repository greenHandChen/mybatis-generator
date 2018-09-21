package com.ceh.mybatis.generator.annotation;

/**
 * Created by enHui.Chen on 2018/9/17.
 */
public enum DataSourceType {

    MYSQL("mysql"),

    ORACLE("oracle");

    private final String dataSourceType;

    DataSourceType(String dataSourceType) {
        this.dataSourceType = dataSourceType;
    }

    public static DataSourceType parse(String dataSourceType) {
        for (DataSourceType dataSourceType1 : DataSourceType.values()) {
            if (dataSourceType1.getDataSourceType().equals(dataSourceType)) {
                return dataSourceType1;
            }
        }
        return null;
    }

    public String getDataSourceType() {
        return dataSourceType;
    }
}
