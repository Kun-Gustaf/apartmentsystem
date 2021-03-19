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
import java.text.SimpleDateFormat;
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
    public String profile(HttpSession session, String nickName, Integer sex, String birthday, String email, String province, String city) {
        User user = (User) session.getAttribute("user");
        user.setNickName(nickName);
        user.setSex(sex);
        user.setEmail(email);
        user.setBirthday(new Timestamp(new Date(birthday).getTime()));
        user.setUpdateTime(new Timestamp(System.currentTimeMillis()));
        user.setProvince(province);
        user.setCity(city);
        user.setBirthday(new Timestamp(System.currentTimeMillis()));
        try{
            userService.updateUser(user);
            session.setAttribute("user", userService.getUserById(user.getId()));
        }catch(Exception e) {
            e.printStackTrace();
        }
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
    public String resetAvatar(String headUrl, Integer id,HttpSession session) throws IOException {
        User user = new User();
        user.setId(id);
        user.setHeadUrl(headUrl);
        user.setUpdateTime(new Timestamp(System.currentTimeMillis()));
        System.out.println(user);
        userService.updateAvatar(user);
        user = userService.getUserById(user.getId());
        session.setAttribute("user",user);
        return "front/user/index";
    }

    @RequestMapping("/register.action")
    @ResponseBody
    public ResultObject register(String email,String password){
        System.out.println(email+"-------------------"+password);
        User user = new User();
        user.setEmail(email);
        user.setPassword(MD5Utils.getMD5String(password+MD5Utils.SALT));
        return userService.regitserUser(user);
    }

    @RequestMapping("/confirmPwd.action")
    @ResponseBody
    public ResultObject confirmPwd(HttpSession session,String oldPassword){
        User user = (User) session.getAttribute("user");
        System.out.println(user+"======================");
        user.setPassword(oldPassword);
        return userService.confirmPwd(user);
    }

    @RequestMapping("/forgetPwd.action")
    public String forgetPwd(){
        return "/front/user/forget_pwd";
    }

    @RequestMapping("/sendEmail.action")
    @ResponseBody
    public ResultObject sendEmail(String email) throws Exception {
        return userService.sendEmail(email);
    }

    @RequestMapping("/forgetAndResetPwd.action")
    public String forgetAndResetPwd(Model model, String email, String captcha, String captchaCode){
        if (captcha != null && captcha.equals(captchaCode)){
            model.addAttribute("email",email);
            model.addAttribute("captcha",captcha);
            return "/front/user/reset_pwd";
        }else {
            return "/front/user/forget_pwd";
        }
    }
    @RequestMapping( value = "/resetPwd2.action",method = RequestMethod.POST)
    public String resetPwd(String email,String captcha,String password){
        User user = new User();
        user.setEmail(email);
        user.setCaptcha(captcha);
        user.setPassword(password);
        userService.updateUserByEmail(user);
        return "/front/index";
    }

    @RequestMapping("/checkEmail.action")
    @ResponseBody
    public ResultObject checkEmail(@RequestBody String email){
        return userService.checkMail(email);
    }
}
