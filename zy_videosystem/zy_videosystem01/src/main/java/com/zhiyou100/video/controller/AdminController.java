package com.zhiyou100.video.controller;

import com.zhiyou100.video.model.Admin;
import com.zhiyou100.video.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @RequestMapping("/toLogin.action")
    public String toAdminLogin(HttpSession session) {
        Admin admin = (Admin) session.getAttribute("session_admin");
        if (admin != null) {
            return "forward:/admin/speaker/index.action";
        } else {
            return "/admin/login";
        }
    }

    @RequestMapping(value = "/login.action", method = RequestMethod.POST)
    public String adminLogin(Model model, HttpSession session, String loginName, String loginPwd) {
        Admin admin = adminService.getAdminByNameAndPwd(loginName, loginPwd);
        System.out.println(admin);
        if (admin != null) {
            session.setAttribute("session_admin", admin);
            System.out.println(admin);
            return "forward:/admin/speaker/index.action";
        } else {
            model.addAttribute("message", "你的用户名或密码错误！");
            return "/admin/login";
        }
    }

    @RequestMapping("/logout.action")
    public String logout(HttpSession session) {
        session.removeAttribute("session_admin");
        return "/front/index";
    }
}
