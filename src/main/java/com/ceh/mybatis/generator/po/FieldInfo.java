package com.ceh.mybatis.generator.po;

import com.ceh.mybatis.generator.config.rules.DbFieldType;
import lombok.Data;

/**
 * Created by enHui.Chen on 2018/9/17.
 */
@Data
public class FieldInfo {

    // 字段名
    private String fieldName;

    // 字段数据库类型
    private String fieldDbType;

    // 是否可为空
    private String isNUll;

    // 是否为主键
    private boolean isIdentity;

    // 字段备注信息
    private String comment;

    // 字段类型信息
    private DbFieldType dbFieldType;

    @Override
    public String toString() {
        return "FieldInfo{" +
                "fieldName='" + fieldName + '\'' +
                ", fieldDbType='" + fieldDbType + '\'' +
                ", isNUll='" + isNUll + '\'' +
                ", isIdentity=" + isIdentity +
                ", comment='" + comment + '\'' +
                ", dbFieldType=" + dbFieldType +
                '}';
    }
}
