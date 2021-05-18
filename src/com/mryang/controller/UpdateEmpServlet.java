package com.mryang.controller;

import com.mryang.dao.EmpDao;
import com.mryang.dao.impl.EmpDaoImpl;
import com.mryang.model.Emp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Genius
 * @version 1.0.0
 * @ClassName ${NAME}.java
 * @Description TODO
 * @createTime 2021年05月18日 15:28:00
 */
public class UpdateEmpServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获得前端提交的数据
        String id = request.getParameter("id");

        // 处理数据
        EmpDao empDao = new EmpDaoImpl();
        Emp emp = empDao.selectByID(Integer.parseInt(id));
        request.setAttribute("emp", emp);

        // 响应页面
        request.getRequestDispatcher("/update.jsp").forward(request,response);
    }
}
