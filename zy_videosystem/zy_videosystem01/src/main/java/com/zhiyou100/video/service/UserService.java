package com.zhiyou100.video.service;

import com.zhiyou100.video.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    User getUserById(Integer id);
    User getUserByEmailAndPwd(String email,String password);
}
