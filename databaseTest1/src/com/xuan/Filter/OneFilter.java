package com.xuan.Filter;

import javax.servlet.*;
import java.io.IOException;

public class OneFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding("utf-8");
        //方向
        filterChain.doFilter(servletRequest,servletResponse);
    }
}
