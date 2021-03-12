package com.zhiyou100.video.service;

import com.zhiyou100.video.model.Admin;

import java.util.List;

public interface AdminService {

    List<Admin> getAllAdmins();
    Admin getAdminByNameAndPwd(String loginName,String loginPwd);
}
