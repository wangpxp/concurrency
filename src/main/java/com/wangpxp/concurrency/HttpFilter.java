package com.wangpxp.concurrency;

import com.wangpxp.concurrency.threadLocal.RequestHolder;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Slf4j
public class HttpFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //先转换
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        log.info("do Filter {} {}", Thread.currentThread().getId(), request.getServletPath());
        //request.getSession().getAttribute("user");
        RequestHolder.add(Thread.currentThread().getId());
        //不拦截这个请求，只是做处理
        filterChain.doFilter(servletRequest, servletResponse);

    }

    @Override
    public void destroy() {

    }
}
