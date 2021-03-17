package com.zhiyou100.video.controller;

import com.zhiyou100.video.model.Admin;
import com.zhiyou100.video.model.Course;
import com.zhiyou100.video.service.AdminService;
import com.zhiyou100.video.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @RequestMapping("/toLogin.action")
    public String toAdminLogin(HttpServletRequest req){
        Object admin = req.getSession().getAttribute("session_admin");
        System.out.println(admin+"==========================");
        if(admin != null){
            return "forward:/admin/speaker/index.action";
        }else {
            return "/admin/login";
        }
    }
    @RequestMapping( value = "/login.action", method = RequestMethod.POST)
    public String adminLogin(HttpServletRequest req, String loginName, String loginPwd){
        HttpSession session = req.getSession();
        Admin admin = adminService.getAdminByNameAndPwd(loginName, loginPwd);
        if(admin !=null){
            session.setAttribute("session_admin",admin);
            System.out.println(admin);
            return  "forward:/admin/speaker/index.action";
        }else {
            req.setAttribute("message","你的用户名或密码错误！");
            return  "/admin/login";
        }
    }

    @RequestMapping("/logout.action")
    public String logout(HttpServletRequest req){
        HttpSession session = req.getSession();
        session.removeAttribute("session_admin");
        return "/front/index";
    }
}
