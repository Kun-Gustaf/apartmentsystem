package com.zhiyou100.video.controller;

import com.zhiyou100.video.model.Admin;
import com.zhiyou100.video.model.Course;
import com.zhiyou100.video.service.AdminService;
import com.zhiyou100.video.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @RequestMapping("/toLogin.action")
    public ModelAndView toAdminLogin(HttpServletRequest req){
//        req.getSession().setAttribute("BaseContext", req.getContextPath()+"/");
        ModelAndView mav = new ModelAndView();
        mav.setViewName("/admin/login");
        return mav;
    }
    @RequestMapping("/login.action")
    public String adminLogin(HttpServletRequest req, String loginName, String loginPwd){
        HttpSession session = req.getSession();

        Object admin1 = session.getAttribute("session_admin");
        System.out.println(admin1);
        if(admin1 != null){
            return "forward:/admin/speaker/index.action";
        }
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
