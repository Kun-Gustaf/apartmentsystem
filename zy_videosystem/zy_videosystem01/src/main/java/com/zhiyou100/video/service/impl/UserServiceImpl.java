package com.zhiyou100.video.service.impl;

import com.zhiyou100.video.mapper.UserMapper;
import com.zhiyou100.video.model.ResultObject;
import com.zhiyou100.video.model.User;
import com.zhiyou100.video.service.UserService;
import com.zhiyou100.video.util.MailUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getAllUsers() {
        return userMapper.queryAllUsers();
    }

    @Override
    public User getUserById(Integer id) {
        return userMapper.queryUserById(id);
    }

    @Override
    public ResultObject getUserByEmailAndPwd(String email, String password) {
        System.out.println("加密后的密码："+password);
        User user = userMapper.queryUserByEmailAndPwd(email, password);
        int state = userMapper.queryStateByEmail(user);
        if(user == null && state != 1){
            return new ResultObject(201,"您的用户名和密码不匹配",null);
        }
        return new ResultObject(200,"helloWorld",user);
    }

    @Override
    public void updateUser(User user) {
        userMapper.updateUser(user);
    }

    @Override
    public void resetPwd(User user) {
        userMapper.resetPwd(user);
    }

    @Override
    public void updateAvatar(User user) {
        userMapper.updateAvatar(user);
    }

    @Override
    public ResultObject regitserUser(User user) {
        ResultObject resultObject = null;
        user.setActive(System.currentTimeMillis());
        try{
            user.setInsertTime(new Timestamp(System.currentTimeMillis()));
            userMapper.addUser(user);
            MailUtil.send(user.getEmail(),"激活邮件","<a href='http://akwvpd.natappfree.cc/front/user/activeAccount.action?email="+user.getEmail() +"'>激活邮件</a>");
            resultObject = new ResultObject(200,"注册成功,我们将会发送给您邮件，请您在5分钟之内及时激活",user);
        }catch(Exception e){
            e.printStackTrace();
            resultObject = new ResultObject(201,"注册失败",null);
        }
        System.out.println(resultObject+"=============================");
        return resultObject;
    }

    @Override
    public ResultObject confirmPwd(User user) {
        User user1 = userMapper.queryUserByIdAndPassword(user);
        System.out.println("查询出来的user："+user1);
        if(user1 == null){
            return new ResultObject(201,"旧密码输入错误",null);
        }else {
            return  new ResultObject(200,"旧密码输入正确",null);
        }
    }

    @Override
    public ResultObject sendEmail(String email) {
        StringBuffer str = new StringBuffer();
        for (int i = 0; i < 6; i++) {
            str.append(Math.round(Math.random()*9));
        }
        System.out.println(str+"*****************");
        try {
            /*MailUtil.send(email,"重置密码",new String(str));*/
            return new ResultObject(200,"验证码已发送到邮箱，请注意查收",str);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResultObject(201,"验证码发送失败",str);
    }

    @Override
    public ResultObject activeAccount(String email) {
        long time1 = userMapper.queryActive(email) + 1000*60;
        long time2 = System.currentTimeMillis();
         long time3 = (time2 - time1) - 60*1000*5;
        System.out.println(time3);
        if(time3 <= 0){
            userMapper.updateUserState(email);
            return new ResultObject(200,"激活成功",null);
        }
        userMapper.deleteUserByEmail(email);
        return new ResultObject(201,"激活失败,请重新注册",null);
    }

    @Override
    public void updateUserByEmail(User user) {
        userMapper.updateUserByEmail(user);
    }

    @Override
    public ResultObject checkMail(String email) {

        User user = userMapper.checkEmail(email);
        if(user == null){
            return new ResultObject(201,"该邮箱未被注册",null);
        }
        return new ResultObject(200,"该邮箱已被注册",user);
    }


}
