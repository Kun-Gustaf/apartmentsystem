package com.zhiyou100.video.service.impl;

import com.zhiyou100.video.mapper.UserMapper;
import com.zhiyou100.video.model.ResultObject;
import com.zhiyou100.video.model.User;
import com.zhiyou100.video.service.UserService;
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
        User user = userMapper.queryUserByEmailAndPwd(email, password);
        if(user == null){
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
        try{
            user.setInsertTime(new Timestamp(System.currentTimeMillis()));
            userMapper.addUser(user);
            resultObject = new ResultObject(200,"注册成功",user);
        }catch(Exception e){
            e.printStackTrace();
            resultObject = new ResultObject(201,"注册失败",null);
        }
        System.out.println(resultObject+"=============================");
        return resultObject;
    }
}
