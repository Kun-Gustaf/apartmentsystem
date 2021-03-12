package com.zhiyou100.video.mapper;

import com.zhiyou100.video.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    List<User> queryAllUsers();
    User queryUserById(Integer id);
    User queryUserByEmailAndPwd(@Param("email") String email,@Param("password") String password);
    void addUser(User user);
    void updateUser(User user);
    void deleteUserById(Integer id);
}
