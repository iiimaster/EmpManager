package com.mryang.controller.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author Genius
 * @version 1.0.0
 * @ClassName EncodingFilter.java
 * @Description TODO 编码过滤器
 * @createTime 2021年05月23日 21:29:00
 */
    public class EncodingFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
            servletRequest.setCharacterEncoding("utf-8");
            filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }


}
