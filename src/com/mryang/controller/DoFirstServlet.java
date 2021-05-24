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
 * @Description TODO 分页：首页
 * @createTime 2021年05月24日 16:04:00
 */
public class DoFirstServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 从session中获得分页信息
        PageModel pageModel = (PageModel) request.getSession().getAttribute("pageModel");

        if (pageModel == null) {
            pageModel = new PageModel(2); // 通过构造函数设置pageCount的值
            request.getSession().setAttribute("pageModel", pageModel);
        }

        pageModel.setCurPage(pageModel.getFirstPage()); // 设置当前页

        // 处理数据
        EmpDao empDao = new EmpDaoImpl();
        try {
            // 查询所有员工数据
            ArrayList<Emp> emps = empDao.selectAll(pageModel);
            // 设置session范围
            request.getSession().setAttribute("emps", emps);
            // 跳转list.jsp页面
//            find(request,response);
            response.sendRedirect("/EmpManager/TotalPageServlet");
//            request.getRequestDispatcher("list.jsp").forward(request,response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void find(HttpServletRequest request, HttpServletResponse response){
        //request.getParameter("");
        // 处理数据
        EmpDao empDao = new EmpDaoImpl();
        PageModel pageModel = new PageModel(2);
//        Integer totalCount = empDao.selectTotalCount(); // 总记录数
        System.out.println(empDao.selectTotalCount());
        // 得到总页数
        pageModel.setTotalCount(empDao.selectTotalCount());
        Integer pageNum = pageModel.getLastPage();
        System.out.println(pageNum);

        request.setAttribute("pageNum",pageNum);
    }
}
