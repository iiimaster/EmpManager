package com.mryang.controller;

import com.mryang.dao.impl.UserDaoImpl;
import com.mryang.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * @author Genius
 * @version 1.0.0
 * @ClassName ${NAME}.java
 * @Description TODO 身份验证过滤器
 * @createTime 2021年05月19日 22:31:00
 */
public class LoginEmpServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        //获得客户端提交的数据
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        //处理数据=>
        /**
         *登录：就是根据用户名和密码查询用户信息:
         *1、如果查询到用户信息，说明登录成功
         * 2、如果没有查询到用户信息，说明登录不成功
         */
        User user = new UserDaoImpl().login(username, password);
        //响应页面
        if(user!=null){
            //把登录身份保留下来，为了后面能够继续判断使用
            request.getSession().setAttribute("user",user);

            //设置自动登录信息：使用Cookie 技术
            String autoLoginNum = request.getParameter("autoLoginNum");
            if(autoLoginNum != null){
                Cookie cookie=new Cookie("autoLogin",user.getUsername()+"-"+user.getPassword());
                cookie.setMaxAge(60*60*24*7*Integer.parseInt(autoLoginNum));
                //设置cookie响应到客户端浏览器
                response.addCookie(cookie);
            }
            response.sendRedirect("/EmpManager/ListEmpServlet");
        }else{
            request.getSession().setAttribute("error","用户名或密码错误");
            response.sendRedirect("/EmpManager/login.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
