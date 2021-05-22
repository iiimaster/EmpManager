package com.mryang.dao.impl;

import com.mryang.model.User;
import com.mryang.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Genius
 * @version 1.0.0
 * @ClassName UserDaoImpl.java
 * @Description TODO
 * @createTime 2021年05月19日 22:32:00
 */
public class UserDaoImpl {
    //登录
    public User login(String username,String password){
        String sql="select * from user where username=? and password=?";

        Connection connection =null;
        PreparedStatement preparedStatement =null;
        ResultSet resultSet =null;
        try {
            connection = JdbcUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setObject(1,username);
            preparedStatement.setObject(2,password);
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                return new User(resultSet.getInt("id"),resultSet.getString("username"),
                        resultSet.getString("password"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.free(resultSet,preparedStatement,connection);
        }
        return  null;
    }
}
