package com.ceh.mybatis.generator.po;

import java.util.List;

/**
 * Created by enHui.Chen on 2018/9/17.
 */
public class TableInfo {

    // 表名
    private String tableName;

    // 数据库引擎
    private String engine;

    // 版本
    private String version;

    // 记录数
    private Long rows;

    // 自动增长主键
    private Long autoIncrement;

    // 备注
    private String comment;

    // 字段信息
    private List<FieldInfo> fieldInfos;

    // controllerName
    private String controllerName;

    // serviceName
    private String serviceName;

    // mapperName
    private String mapperName;

    // xmlName
    private String xmlName;

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public List<FieldInfo> getFieldInfos() {
        return fieldInfos;
    }

    public void setFieldInfos(List<FieldInfo> fieldInfos) {
        this.fieldInfos = fieldInfos;
    }

    public String getControllerName() {
        return controllerName;
    }

    public void setControllerName(String controllerName) {
        this.controllerName = controllerName;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getMapperName() {
        return mapperName;
    }

    public void setMapperName(String mapperName) {
        this.mapperName = mapperName;
    }

    public String getXmlName() {
        return xmlName;
    }

    public void setXmlName(String xmlName) {
        this.xmlName = xmlName;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Long getRows() {
        return rows;
    }

    public void setRows(Long rows) {
        this.rows = rows;
    }

    public Long getAutoIncrement() {
        return autoIncrement;
    }

    public void setAutoIncrement(Long autoIncrement) {
        this.autoIncrement = autoIncrement;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "TableInfo{" +
                "tableName='" + tableName + '\'' +
                ", engine='" + engine + '\'' +
                ", version='" + version + '\'' +
                ", rows=" + rows +
                ", autoIncrement=" + autoIncrement +
                ", comment='" + comment + '\'' +
                ", fieldInfos=" + fieldInfos +
                ", controllerName='" + controllerName + '\'' +
                ", serviceName='" + serviceName + '\'' +
                ", mapperName='" + mapperName + '\'' +
                ", xmlName='" + xmlName + '\'' +
                '}';
    }
}
