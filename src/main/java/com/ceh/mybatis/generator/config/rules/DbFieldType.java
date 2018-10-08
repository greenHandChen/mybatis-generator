package com.ceh.mybatis.generator.config.rules;

/**
 * Created by enHui.Chen on 2018/9/29.
 */
public enum DbFieldType {
    // 基本类型
    BASE_BYTE("byte", ""),
    BASE_SHORT("short", ""),
    BASE_INT("int", ""),
    BASE_LONG("long", ""),
    BASE_CHAR("char", ""),
    BASE_BOOLEAN("boolean", ""),
    BASE_FLOAT("float", ""),
    BASE_DOUBLE("double", ""),

    // 包装类型
    BYTE("Byte", "java.lang.Byte"),
    SHORT("Short", "java.lang.Short"),
    INTEGER("Integer", "java.lang.Integer"),
    LONG("Long", "java.lang.Integer"),
    CHAR("Char", "java.lang.Char"),
    BOOLEAN("Boolean", "java.lang.Boolean"),
    FLOAT("Float", "java.lang.Float"),
    DOUBLE("Double", "java.lang.Double"),

    // String
    STRING("String", "java.lang.String"),

    // 日期类型
    DATE("Date", "java.util.Date"),

    // 其他
    BIGDECIMAL("BigDecimal", "java.math.BigDecimal");

    private String type;
    private String pkg;

    DbFieldType(String type, String pkg) {
        this.type = type;
        this.pkg = pkg;
    }

    public String getType() {
        return type;
    }

    public String getPkg() {
        return pkg;
    }

}

