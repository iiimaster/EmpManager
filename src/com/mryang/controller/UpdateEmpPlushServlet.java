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
 * @createTime 2021年05月22日 19:11:00
 */
public class UpdateEmpPlushServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        // 获取前端数据
        String id = request.getParameter("id");
        // 处理数据
        EmpDao empDao = new EmpDaoImpl();

        Emp emp = empDao.selectByID(Integer.parseInt(id));

        // 字符串拼接
        String str = emp.toString();
        // 传递数据到后端
        response.getWriter().write(str);

//=================普通字符串拼接传递数据==============
//        String str = "id-" + emp.getId() + ",name-" + emp.getName() + ",age-" + emp.getAge() + ",sex-" + emp.getSex() + ",salary-" + emp.getSalary();
//        // 传递数据到后端
//        response.getWriter().write(str);
//=================普通字符串拼接传递数据==============

    }
}
