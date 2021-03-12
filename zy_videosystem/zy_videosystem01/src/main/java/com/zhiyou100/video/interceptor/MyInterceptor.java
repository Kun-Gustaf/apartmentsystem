package com.zhiyou100.video.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        /*
             Object user = request.getSession().getAttribute("login_user");
            System.out.println(user);
            if (user != null) {
                // 登录过 用户经过校验了
                return true;
            }
            // 跳转到登录页面
            response.sendRedirect(request.getContextPath() + "/index.action");
            return false;
        */
        return  true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        /*
        * 主要就是对 ModelAndView modelAndView 数据和视图做处理
        * */

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
