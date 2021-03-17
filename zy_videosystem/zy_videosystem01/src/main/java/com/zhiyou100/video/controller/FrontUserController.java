package com.zhiyou100.video.controller;

import com.zhiyou100.video.model.Admin;
import com.zhiyou100.video.model.ResultObject;
import com.zhiyou100.video.model.User;
import com.zhiyou100.video.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.sql.Timestamp;
import java.util.UUID;

@Controller
@RequestMapping("/front/user")
public class FrontUserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/index.action")
    public String index() {
        return "front/user/index";
    }

    @RequestMapping("/profile.action")
    public String toProfile() {
        return "front/user/profile";
    }

    @RequestMapping("/toProfile.action")
    public String profile(HttpServletRequest req, String nickName, Integer sex, String birthday, String email, String province, String city) {
        User user = new User();
        user.setNickName(nickName);
        user.setSex(sex);
        user.setEmail(email);
        user.setUpdateTime(new Timestamp(System.currentTimeMillis()));
        user.setProvince(province);
        user.setCity(city);
        user.setBirthday(new Timestamp(System.currentTimeMillis()));
        userService.updateUser(user);
        HttpSession session = req.getSession();
        session.setAttribute("user", user);
        return "front/user/index";
    }

    @RequestMapping("/password.action")
    public String toResetPassword() {
        return "front/user/password";
    }

    @RequestMapping("/resetPwd.action")
    public String resetPwd(HttpServletRequest req, Integer id, String oldPassword, String newPassword, String newPasswordAgain) {
        User user1 = userService.getUserById(id);
        if (!user1.getPassword().equals(oldPassword)) {
            req.setAttribute("message", "输入的原密码不正确");
            return "front/user/password";
        }
        if (newPassword == null && !newPassword.equals(newPasswordAgain)) {
            req.setAttribute("message", "两次输入的密码不一致");
        } else {
            User user = new User();
            user.setId(id);
            user.setPassword(newPassword);
            user.setUpdateTime(new Timestamp(System.currentTimeMillis()));
            userService.resetPwd(user);
            return "front/user/index";
        }
        return "front/user/password";
    }

    @RequestMapping("/avatar.action")
    public String toAvatar() {
        return "/front/user/avatar";
    }

    @RequestMapping("/resetAvatar.action")
    public String resetAvatar(MultipartFile headUrl, Integer id) throws IOException {
        String originalFilename = headUrl.getOriginalFilename();
        String filename = UUID.randomUUID().toString().replaceAll("-", "");
        File file = new File("D:\\space\\code\\zy_videosystem\\zy_videosystem01\\src\\main\\webapp\\static\\img\\"+filename + originalFilename);
        headUrl.transferTo(file);
        User user = new User();
        user.setId(id);
        user.setHeadUrl(file.getAbsolutePath());
        user.setUpdateTime(new Timestamp(System.currentTimeMillis()));
        userService.updateAvatar(user);
        return "front/user/index";
    }

    @RequestMapping("/register.action")
    @ResponseBody
    public ResultObject register(String email,String password){
        System.out.println(email+"-------------------"+password);
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        return userService.regitserUser(user);
    }
}
