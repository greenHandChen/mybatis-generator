package com.ceh.mybatis.generator.po;

import lombok.Data;

import java.util.List;

/**
 * Created by enHui.Chen on 2018/9/17.
 */
@Data
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
