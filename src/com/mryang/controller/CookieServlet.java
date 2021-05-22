package com.mryang.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Genius
 * @version 1.0.0
 * @ClassName ${NAME}.java
 * @Description TODO
 * @createTime 2021年05月21日 12:09:00
 */

public class CookieServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        for(Cookie  cookie:cookies){
            System.out.println(cookie.getName()+"--"+cookie.getValue());
        }
    }
}
