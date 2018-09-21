package com.ceh.mybatis.generator.dao;

import com.ceh.mybatis.generator.po.TableInfo;

import java.util.List;

/**
 * Created by enHui.Chen on 2018/9/17.
 */
public interface GenerateDao {
    List<TableInfo> getAllTables();
}
