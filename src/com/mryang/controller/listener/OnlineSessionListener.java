package com.mryang.controller.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * @ClassName ${NAME}.java
 * @author Genius
 * @version 1.0.0
 * @Description TODO 在线人数（有多少人访问服务器）监听器
 * @createTime 2021年05月20日 19:08:00
 */
public class OnlineSessionListener implements
        HttpSessionListener{

    // Public constructor is required by servlet spec
    public OnlineSessionListener() {

    }

    // 统计在线人数
    public void sessionCreated(HttpSessionEvent se) {
        // 拿到初始在线人数
        Long online = (Long) se.getSession().getServletContext().getAttribute("online");
        // 判断是否有用户在线
        if (online == null) {
            online = 10000L;
        }
        // 不为空，自增
        online++;
        // 将数据存入session
        se.getSession().getServletContext().setAttribute("online", online);
    }

    public void sessionDestroyed(HttpSessionEvent se) {
        /* Session is destroyed. */
    }

}
