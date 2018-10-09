package com.ceh.mybatis.generator.config.convert;

import com.ceh.mybatis.generator.config.rules.DbFieldType;

/**
 * Created by enHui.Chen on 2018/9/29.
 */
public class MysqlDbTypeConvert implements DbTypeConvert {
    @Override
    public DbFieldType processDbType2JavaType(String dbType) {
        dbType = dbType.toLowerCase();
        if (dbType.contains("char") || dbType.contains("varchar") || dbType.contains("text")) {
            return DbFieldType.STRING;
        } else if (dbType.contains("int")) {
            return DbFieldType.INTEGER;
        } else if (dbType.contains("bigint")) {
            return DbFieldType.LONG;
        } else if (dbType.contains("float")) {
            return DbFieldType.FLOAT;
        } else if (dbType.contains("double")) {
            return DbFieldType.DOUBLE;
        } else if (dbType.contains("tinyint")) {
            return DbFieldType.BOOLEAN;
        } else if (dbType.contains("decimal")) {
            return DbFieldType.BIGDECIMAL;
        } else if (dbType.contains("datetime")) {
            return DbFieldType.DATE;
        }
        return DbFieldType.STRING;
    }
}
