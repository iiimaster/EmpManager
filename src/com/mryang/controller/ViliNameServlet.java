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
import java.util.EmptyStackException;

/**
 * @author Genius
 * @version 1.0.0
 * @ClassName ${NAME}.java
 * @Description TODO 验证员工姓名是否存在
 * @createTime 2021年05月22日 17:23:00
 */

public class ViliNameServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    // 验证员工姓名是否存在
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8"); // 防止乱码
        // 1、从前端获取员工姓名
        String name = request.getParameter("name");
//        System.out.println("name ==" + name);
        // 2、根据员工姓名，从数据库查找数据
        // 找到对应员工：员工已经录入
        // 未找到对应员工：可以录入员工
        EmpDao empDao = new EmpDaoImpl();

        Emp emp = empDao.selectByName(name);

        if (emp != null) {
            response.getWriter().write("员工已经存在");
        }
    }
}
