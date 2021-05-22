package com.mryang.controller.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

/**
 * @ClassName ${NAME}.java
 * @author Genius
 * @version 1.0.0
 * @Description TODO 访问量（有多少次点击）监听器
 * @createTime 2021年05月20日 19:25:00
 */
public class TrafficSessionListener implements ServletRequestListener{


    // 统计访问量
    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        Long traffic = (Long) sre.getServletContext().getAttribute("traffic");
        if (traffic == null){
            traffic = 10000L;
        }
        traffic++;
        sre.getServletContext().setAttribute("traffic",traffic);
    }

    @Override
    public void requestDestroyed(ServletRequestEvent servletRequestEvent) {

    }
}
