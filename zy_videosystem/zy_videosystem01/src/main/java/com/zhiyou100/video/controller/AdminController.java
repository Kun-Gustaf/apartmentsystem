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
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private CourseService courseService;

    @RequestMapping("/admin/toLogin.action")
    public ModelAndView toAdminLogin(HttpServletRequest req){
        req.getSession().setAttribute("BaseContext", req.getContextPath()+"/");
        ModelAndView mav = new ModelAndView();
        mav.setViewName("/admin/login");
        return mav;
    }
    @RequestMapping("/admin/login.action")
    public ModelAndView adminLogin(HttpServletRequest req, String loginName, String loginPwd){
        Admin admin = adminService.getAdminByNameAndPwd(loginName, loginPwd);
        ModelAndView mav = new ModelAndView();
        HttpSession session = req.getSession();
        if(admin !=null){
            List<Course> courses = courseService.getAllCourse();
            session.setAttribute("session_admin",admin);
            req.setAttribute("results",courses);
            courses.forEach(System.out::println);
            System.out.println(admin);
            mav.setViewName("/admin/course/index");
            return mav;
        }else {
            req.setAttribute("message","你的用户名或密码错误！");
            mav.setViewName("/admin/login");
            return mav;
        }
        //return mav;
    }
}
