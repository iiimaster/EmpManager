package com.mryang.controller;

import com.mryang.dao.EmpDao;
import com.mryang.dao.impl.EmpDaoImpl;
import com.mryang.model.Emp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * @author Genius
 * @version 1.0.0
 * @ClassName ${NAME}.java
 * @Description TODO
 * @createTime 2021年05月23日 14:48:00
 */
public class updateSubmitEmpPlushServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 获取前端的数据
        String uid = request.getParameter("uid");
        String uname = request.getParameter("uname");
        String uage = request.getParameter("uage");
        String usex = request.getParameter("usex");
        String usalary = request.getParameter("usalary");

        Emp emp = new Emp(Integer.parseInt(uid), uname, Integer.parseInt(uage), Integer.parseInt(usex), Double.parseDouble(usalary));

        try {
            // 处理数据
            EmpDao empDao = new EmpDaoImpl();
            empDao.update(emp);
            // 响应修改数据是否成功
            response.getWriter().write("1");
        } catch (Exception e) {
            response.getWriter().write("0");
            e.printStackTrace();
        }


    }
}
