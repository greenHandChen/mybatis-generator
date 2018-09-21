package com.ceh.mybatis.generator.po;

/**
 * Created by enHui.Chen on 2018/9/17.
 */
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

    // 字段Java数据类型
    private String javaType;

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getFieldDbType() {
        return fieldDbType;
    }

    public void setFieldDbType(String fieldDbType) {
        this.fieldDbType = fieldDbType;
    }

    public String getJavaType() {
        return javaType;
    }

    public void setJavaType(String javaType) {
        this.javaType = javaType;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public boolean getIsIdentity() {
        return isIdentity;
    }

    public void setIsIdentity(boolean identity) {
        isIdentity = identity;
    }

    public String getIsNUll() {
        return isNUll;
    }

    public void setIsNUll(String isNUll) {
        this.isNUll = isNUll;
    }

    @Override
    public String toString() {
        return "FieldInfo{" +
                "fieldName='" + fieldName + '\'' +
                ", fieldDbType='" + fieldDbType + '\'' +
                ", isNUll='" + isNUll + '\'' +
                ", isIdentity=" + isIdentity +
                ", comment='" + comment + '\'' +
                ", javaType='" + javaType + '\'' +
                '}';
    }
}
