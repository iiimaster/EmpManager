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

/**
 * @author Genius
 * @version 1.0.0
 * @ClassName ${NAME}.java
 * @Description TODO
 * @createTime 2021年05月18日 20:29:00
 */
public class UpdateSubmitEmpServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8"); //防止乱码
        // 获取数据
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        String sex = request.getParameter("sex");
        String salary = request.getParameter("salary");

        Emp emp = new Emp(Integer.parseInt(id), name, Integer.parseInt(age), Integer.parseInt(sex), Double.parseDouble(salary));
        // 处理数据
        EmpDao empDao = new EmpDaoImpl();
        empDao.update(emp);
        // 响应数据
        response.sendRedirect("/EmpManager/ListEmpServlet");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
