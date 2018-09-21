package com.ceh.mybatis.generator.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by enHui.Chen on 2018/9/20.
 */
public class DbUtil {
    private static DbUtil dbUtil;

    private static Connection connection = null;

    private static PreparedStatement pstmt = null;

    private static ResultSet resultSet = null;

}
