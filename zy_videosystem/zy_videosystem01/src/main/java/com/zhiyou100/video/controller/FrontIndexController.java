package com.zhiyou100.video.controller;

import com.zhiyou100.video.model.User;
import com.zhiyou100.video.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class FrontIndexController {

    @Autowired
    private UserService userService;
    @RequestMapping("/index.action")
    public ModelAndView getIndex(){
        ModelAndView mav = new ModelAndView();
        System.out.println(mav);
        mav.setViewName("/front/index");
        /*"forward:/WEB-INF/jsp/front/index.jsp"*/
        return mav;
    }

    @RequestMapping("/front/user/login.action")
    public void login(String email, String password, HttpServletRequest req, HttpServletResponse resp) throws IOException {
        User user = userService.getUserByEmailAndPwd(email, password);
        System.out.println(user);
       /* mav.addObject("front_user",user);
        mav.setViewName("/front/index");*/
        if(user != null){
            req.setAttribute("front_user",user);
            resp.getWriter().write("success");
        }else {
            resp.getWriter().write("fail");
        }

    }
}
