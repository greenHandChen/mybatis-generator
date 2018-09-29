package com.ceh.mybatis.generator.config.convert;

import com.ceh.mybatis.generator.config.rules.DbFieldType;

/**
 * Created by enHui.Chen on 2018/9/29.
 */
public interface DbTypeConvert {
    DbFieldType processDbType2JavaType(String dbType);
}
