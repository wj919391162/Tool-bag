package com.ppx.mhl.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 *jdbc德鲁伊工具
 * * @version 1.8
 **/


public class JdbcUtilsByDruid {

    private static DataSource ds;

    static {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("src\\druid.properties"));
            ds = DruidDataSourceFactory.createDataSource(properties);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

    //关闭连接在德鲁伊种不是断掉连接，而是把connection放回连接池
    public static void close(ResultSet set, Statement statement, Connection connection){

        try {
            if (set != null) {
                set.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }catch (SQLException e) {
            throw new RuntimeException();
        }
    }
}
