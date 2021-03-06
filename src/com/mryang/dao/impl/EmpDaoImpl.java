package com.mryang.dao.impl;

import com.mryang.dao.EmpDao;
import com.mryang.model.Emp;
import com.mryang.utils.JdbcUtils;
import com.mryang.utils.PageModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author Genius
 * @version 1.0.0
 * @ClassName EmpDaoImpl.java
 * @Description TODO
 * @createTime 2021年05月17日 22:18:00
 */
public class EmpDaoImpl implements EmpDao {

    private ResultSet resultSet = null;
    private PreparedStatement preparedStatement = null;
    private Connection connection = null;

    @Override
    public int insert(Emp emp) {
        String sql = "insert into `emp` values(null,?,?,?,?)";
        try {
            connection = JdbcUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, emp.getName());
            preparedStatement.setInt(2, emp.getAge());
            preparedStatement.setInt(3, emp.getSex());
            preparedStatement.setDouble(4, emp.getSalary());

            return preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JdbcUtils.free(resultSet, preparedStatement, connection);
        }
        return 0;
    }

    @Override
    public ArrayList<Emp> selectAll() {
        ArrayList<Emp> emps = new ArrayList<>();
        String sql = "select `id`,`name`,`age`,`sex`,`salary` from `emp`";
        try {
            connection = JdbcUtils.getConnection();

            preparedStatement = connection.prepareStatement(sql);

            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                emps.add(new Emp(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getInt("age"),
                        resultSet.getInt("sex"),
                        resultSet.getDouble("salary")
                ));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JdbcUtils.free(resultSet, preparedStatement, connection);
        }
        return emps;
    }

    @Override
    public Integer selectTotalCount() {
        String sql = "select count(*) cou from emp";
        try {
            connection = JdbcUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                return resultSet.getInt("cou");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public ArrayList<Emp> selectAll(PageModel pageModel) {
        ArrayList<Emp> emps = new ArrayList<>();
        String sql = "select `id`,`name`,`age`,`sex`,`salary` from `emp` limit ?,?";
        try {
            connection = JdbcUtils.getConnection();

            preparedStatement = connection.prepareStatement(sql);
            // 从哪个记录数开始
            preparedStatement.setInt(1, (pageModel.getCurPage() - 1) * pageModel.getPageCount());
            // 每页显示多少条
            preparedStatement.setInt(2,pageModel.getPageCount());

            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                emps.add(new Emp(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getInt("age"),
                        resultSet.getInt("sex"),
                        resultSet.getDouble("salary")
                ));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JdbcUtils.free(resultSet, preparedStatement, connection);
        }
        return emps;
    }

    @Override
    public Emp selectByID(Integer id) {
        String sql = "select `id`,`name`,`age`,`sex`,`salary` from `emp` where id =?";
        try {
            connection = JdbcUtils.getConnection();

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);

            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                return (new Emp(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getInt("age"),
                        resultSet.getInt("sex"),
                        resultSet.getDouble("salary")
                ));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JdbcUtils.free(resultSet, preparedStatement, connection);
        }
        return null;
    }

    @Override
    public Emp selectByName(String name) {

        String sql = "select `id`,`name`,`age`,`sex`,`salary` from `emp` where name =?";
        try {
            connection = JdbcUtils.getConnection();

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,name);

            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                return (new Emp(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getInt("age"),
                        resultSet.getInt("sex"),
                        resultSet.getDouble("salary")
                ));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JdbcUtils.free(resultSet, preparedStatement, connection);
        }
        return null;
    }

    @Override
    public void delete(Integer id) {
        String sql = "delete from `emp` where id = ?";
        try {
            connection = JdbcUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JdbcUtils.free(resultSet,preparedStatement,connection);
        }
    }

    @Override
    public int update(Emp emp) throws Exception {
        String sql = "update `emp` set `name`=?,`age`=?,`sex`=?,`salary`=? where id =?";

            connection = JdbcUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, emp.getName());
            preparedStatement.setInt(2, emp.getAge());
            preparedStatement.setInt(3, emp.getSex());
            preparedStatement.setDouble(4, emp.getSalary());
            preparedStatement.setInt(5,emp.getId());
            int i = preparedStatement.executeUpdate();
            JdbcUtils.free(resultSet, preparedStatement, connection);
            return i;
//            return selectByID(emp.getId());
    }
}
