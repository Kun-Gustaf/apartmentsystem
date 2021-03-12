package com.zhiyou100.video.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NotFoundException implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest req, HttpServletResponse resp, Object o, Exception e) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("object",o);
        mav.addObject("exception",e);
        mav.setViewName("/findson");
        return mav;
    }
}
