package com.mryang.controller;

import com.mryang.dao.EmpDao;
import com.mryang.dao.impl.EmpDaoImpl;
import com.mryang.utils.PageModel;

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
 * @createTime 2021年05月24日 20:38:00
 */
public class TotalPageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 处理数据
        EmpDao empDao = new EmpDaoImpl();
        PageModel pageModel = new PageModel(2);
//        Integer totalCount = empDao.selectTotalCount(); // 总记录数

        // 得到总页数
        pageModel.setTotalCount(empDao.selectTotalCount());
        Integer pageNum = pageModel.getLastPage();

        // 获取数据
        request.setAttribute("pageNum",pageNum);

        // 响应页面
        request.getRequestDispatcher("list.jsp").forward(request,response);
    }
}
