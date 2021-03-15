package com.zhiyou100.video.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/ContextFilter")
public class ContextFilter implements Filter {
    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;
        /*
            拼接BaseContext

        */
        String http = req.getScheme();
        String localhost = req.getServerName();
        int port = req.getServerPort();
        //获取虚拟目录
        String contextPath = req.getContextPath();
        String basePath = http + " ://" + localhost + ":" + port + "/" + contextPath + "/";
        req.setAttribute("BaseContext",basePath);
        //资源放行
        chain.doFilter(req, resp);
    }

    @Override
    public void init(FilterConfig config) throws ServletException {

    }

}
