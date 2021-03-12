package com.zhiyou100.video.service.impl;

import com.zhiyou100.video.mapper.AdminMapper;
import com.zhiyou100.video.model.Admin;
import com.zhiyou100.video.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;

    @Override
    public List<Admin> getAllAdmins() {
        return adminMapper.queryAllAdmins();
    }

    @Override
    public Admin getAdminByNameAndPwd(String loginName, String loginPwd) {
        return adminMapper.queryAdminByNameAndPwd(loginName, loginPwd);
    }
}
