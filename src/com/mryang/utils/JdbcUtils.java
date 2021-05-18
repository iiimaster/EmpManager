package com.mryang.utils;

import java.sql.*;

/**
 * @author Genius
 * @version 1.0.0
 * @ClassName JdbcUtils.java
 * @Description TODO Jdbc封装
 * @createTime 2021年05月17日 22:20:00
 */
public class JdbcUtils {

    private static String url = "jdbc:mysql://localhost:3306/empmanager?useUnicode=true&characterEncoding=utf8";
    private static String username = "root";
    private static String password = "toor";

    // 类加载的时候执行一次，且只执行一次
    static{
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // 建立数据库连接
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url,username,password);
    }

    // 释放资源
    public static void free(ResultSet resultSet, PreparedStatement preparedStatement, Connection connection) {
        try {
            if(null != resultSet){
                resultSet.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            try {
                if(null != preparedStatement){
                    preparedStatement.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }finally {
                try {
                    if (null != connection){
                        connection.close();
                    }
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
    }

}
