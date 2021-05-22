package com.mryang.controller;

import com.mryang.dao.EmpDao;
import com.mryang.dao.impl.EmpDaoImpl;
import com.mryang.model.Emp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author Genius
 * @version 1.0.0
 * @ClassName ${NAME}.java
 * @Description TODO
 * @createTime 2021年05月18日 13:41:00
 */

public class ListEmpServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 判断用户是否登录，只有登录后才能访问
//        Object user = request.getSession().getAttribute("user");
//        if (user == null) { // 未登录
//            response.sendRedirect("/EmpManager/login.jsp");
//            return;
//        }

        EmpDao empDao = new EmpDaoImpl();
        try {
            // 查询所有员工数据
            ArrayList<Emp> emps = empDao.selectAll();
            // 设置session范围
            request.getSession().setAttribute("emps", emps);
            // 跳转list.jsp页面
            response.sendRedirect("/EmpManager/list.jsp");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
