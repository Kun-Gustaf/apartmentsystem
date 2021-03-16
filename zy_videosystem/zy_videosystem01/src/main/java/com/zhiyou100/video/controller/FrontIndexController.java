package com.zhiyou100.video.controller;

import com.zhiyou100.video.model.ResultObject;
import com.zhiyou100.video.model.User;
import com.zhiyou100.video.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller

public class FrontIndexController {

    @Autowired
    private UserService userService;

    @RequestMapping("/index.action")
    public ModelAndView getIndex() {
        ModelAndView mav = new ModelAndView();
        System.out.println(mav);
        mav.setViewName("/front/index");
        return mav;
    }

    @RequestMapping(value = "/front/user/login.action",method = RequestMethod.POST)
    @ResponseBody
    public ResultObject login(String email, String password, HttpServletRequest req) throws IOException {
        ResultObject result = userService.getUserByEmailAndPwd(email, password);
        System.out.println(result);
        HttpSession session = req.getSession();
        if(result.getCode() == 200){
            session.setAttribute("user",result.getData());
        }
        return result;
    }

    @RequestMapping("/front/user/logout.action")
    public String logout(HttpServletRequest req) {
        req.removeAttribute("user");
        return "/front/index";
    }

    @RequestMapping("front/user/index.action")
    public String index(HttpServletRequest req) {
        return "front/user/index";
    }
}
