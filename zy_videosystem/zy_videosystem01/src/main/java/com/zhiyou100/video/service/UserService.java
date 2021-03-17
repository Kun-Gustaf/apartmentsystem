package com.zhiyou100.video.service;

import com.zhiyou100.video.model.ResultObject;
import com.zhiyou100.video.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    User getUserById(Integer id);
    ResultObject getUserByEmailAndPwd(String email, String password);

    void updateUser(User user);

    void resetPwd(User user);

    void updateAvatar(User user);

    ResultObject regitserUser(User user);
}
