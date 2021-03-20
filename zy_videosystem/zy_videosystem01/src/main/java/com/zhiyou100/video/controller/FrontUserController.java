package com.zhiyou100.video.controller;

import com.zhiyou100.video.model.Admin;
import com.zhiyou100.video.model.ResultObject;
import com.zhiyou100.video.model.User;
import com.zhiyou100.video.service.UserService;
import com.zhiyou100.video.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
    public String profile(HttpSession session, String birthdayStr, User user) throws ParseException {
        System.out.println(birthdayStr);
        try{
            user.setBirthday(new SimpleDateFormat("yyyy-MM-dd").parse(birthdayStr));
        }catch(Exception e){
            e.printStackTrace();
        }
        System.out.println(user.getBirthday());
        user.setUpdateTime(Timestamp.valueOf(LocalDateTime.now()));
        System.out.println(user);
        try {
            userService.updateUser(user);
            session.setAttribute("user", userService.getUserById(user.getId()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "front/user/index";
    }

    @RequestMapping("/password.action")
    public String toResetPassword() {
        return "front/user/password";
    }

    @RequestMapping("/resetPwd.action")
    public String resetPwd(HttpSession session, Integer id, String newPassword) {
            User user = new User();
            user.setId(id);
            user.setPassword(MD5Utils.getMD5String(newPassword + MD5Utils.SALT));
            user.setUpdateTime(new Timestamp(System.currentTimeMillis()));
            System.out.println("加密后的密码："+user.getPassword());
            userService.resetPwd(user);
            session.removeAttribute("user");
            return "/front/index";
    }
    @RequestMapping("/confirmPwd.action")
    @ResponseBody
    public ResultObject confirmPwd(Integer id, String oldPassword) {
        User user =  new User();
        user.setId(id);
        System.out.println("Id:"+id+",旧密码："+oldPassword);
        user.setPassword(MD5Utils.getMD5String(oldPassword+MD5Utils.SALT));
        return userService.confirmPwd(user);
    }

    @RequestMapping("/avatar.action")
    public String toAvatar() {
        return "/front/user/avatar";
    }

    @RequestMapping("/resetAvatar.action")
    public String resetAvatar(MultipartFile headUrl, Integer id, HttpSession session) throws IOException {
        String originalFilename = headUrl.getOriginalFilename();
        String filename = UUID.randomUUID().toString().replaceAll("-", "");
        File file = new File("D:\\space\\code\\zy_videosystem\\zy_videosystem01\\src\\main\\webapp\\static\\img\\"+filename + originalFilename);
        headUrl.transferTo(file);
        User user = new User();
        user.setId(id);
        user.setHeadUrl(file.getName());
        user.setUpdateTime(new Timestamp(System.currentTimeMillis()));
        System.out.println(user);
        userService.updateAvatar(user);
        session.setAttribute("user", userService.getUserById(user.getId()));
        return "front/user/index";
    }

    @RequestMapping("/register.action")
    @ResponseBody
    public ResultObject register(String email, String password) {
        System.out.println(email + "-------------------" + password);
        User user = new User();
        user.setEmail(email);
        user.setPassword(MD5Utils.getMD5String(password + MD5Utils.SALT));
        return userService.regitserUser(user);
    }


    @RequestMapping("/activeAccount.action")
    public String activeAccount(Model model,String email){
        ResultObject resultObject = userService.activeAccount(email);
        model.addAttribute("result",resultObject);
        return "/front/user/activeAccount";
    }

    @RequestMapping("/forgetPwd.action")
    public String forgetPwd() {
        return "/front/user/forget_pwd";
    }

    @RequestMapping("/sendEmail.action")
    @ResponseBody
    public ResultObject sendEmail(String email) throws Exception {
        return userService.sendEmail(email);
    }

    @RequestMapping("/forgetAndResetPwd.action")
    public String forgetAndResetPwd(Model model, String email, String captcha, String captchaCode) {
        if (captcha != null && captcha.equals(captchaCode)) {
            model.addAttribute("email", email);
            model.addAttribute("captcha", captcha);
            return "/front/user/reset_pwd";
        } else {
            return "/front/user/forget_pwd";
        }
    }

    @RequestMapping(value = "/resetPwd2.action", method = RequestMethod.POST)
    public String resetPwd(String email, String captcha, String password) {
        User user = new User();
        user.setEmail(email);
        user.setCaptcha(captcha);
        user.setPassword(password);
        userService.updateUserByEmail(user);
        return "/front/index";
    }

    @RequestMapping("/checkEmail.action")
    @ResponseBody
    public ResultObject checkEmail(@RequestBody String email) {
        return userService.checkMail(email);
    }
}
