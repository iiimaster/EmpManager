package com.mryang.controller;

import com.mryang.dao.EmpDao;
import com.mryang.dao.impl.EmpDaoImpl;
import com.mryang.model.Emp;
import com.mryang.utils.PageModel;

import javax.servlet.ServletException;
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
 * @createTime 2021年05月24日 18:49:00
 */
public class DoDownServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        EmpDao empDao = new EmpDaoImpl();
        // 从session中获得分页信息
        PageModel pageModel = (PageModel) request.getSession().getAttribute("pageModel");

        if (pageModel == null) {
            pageModel = new PageModel(2); // 通过构造函数设置pageCount的值
            pageModel.setCurPage(pageModel.getFirstPage()); // 设置当前页
            request.getSession().setAttribute("pageModel", pageModel);
        }

        pageModel.setTotalCount(empDao.selectTotalCount()); // 设置总记录数

        if (pageModel.getLastPage() > pageModel.getCurPage()){ //最后一页则无下一页
            pageModel.setCurPage(pageModel.getCurPage() + 1); // 设置当前页
        }

        // 处理数据
        try {
            // 查询所有员工数据
            ArrayList<Emp> emps = empDao.selectAll(pageModel);
            // 设置session范围
            request.getSession().setAttribute("emps", emps);
            // 跳转list.jsp页面
//            response.sendRedirect("/EmpManager/list.jsp");
            response.sendRedirect("/EmpManager/TotalPageServlet");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
