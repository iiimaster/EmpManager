package com.mryang.controller.filter;

import com.mryang.dao.impl.UserDaoImpl;
import com.mryang.model.User;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * @author Genius
 * @version 1.0.0
 * @ClassName ${NAME}.java
 * @Description TODO
 * @createTime 2021年05月20日 00:12:00
 */
public class LoginFilter implements Filter {
    public void destroy() {
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request=(HttpServletRequest)req;
        HttpServletResponse response=(HttpServletResponse)resp;
        //访问路径：如果是login.jsp，释放请求
//        System.out.println(request.getRequestURL());
//        System.out.println(request.getRequestURI());
        String requestURI = request.getRequestURI();
        if(requestURI.indexOf("login.jsp")>0){
            chain.doFilter(req, resp);
            return ;
        }
        if(requestURI.indexOf("LoginEmpServlet")>0){
            chain.doFilter(req, resp);
            return ;
        }

        //判断有没有登录，登陆后才能访问
        Object user = request.getSession().getAttribute("user");
        if(user==null){
            /**
             *  自动登录：获取cookie中用户名和密码，实现登录功能
             *  如果成功登录，访问目标资源
             *  如果没有成功登录看，返回手动登录（登录页面）
             */
            Cookie[] cookies =  request.getCookies();
            if(cookies!=null && cookies.length>0){

                for(Cookie cookie:cookies){
//                    System.out.println(cookie.getName()+"--"+cookie.getValue());
                    if("autoLogin".equals(cookie.getName())){
                        //System.out.println(cookie.getValue());
                        String cookieValue = cookie.getValue();
                        String[] strings = cookieValue.split("-");
                        User autoUser = new UserDaoImpl().login(strings[0], strings[1]);
                        if(autoUser!=null){
                            //释放请求
                            chain.doFilter(req, resp);
                            return ;
                        }else{
                            response.sendRedirect("/EmpManager/login.jsp");
                            return ;
                        }
                    }
                }
            }
            response.sendRedirect("/EmpManager/login.jsp");
            return ;
        }
        //释放请求
        chain.doFilter(req, resp);
    }
}
