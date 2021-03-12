package com.zhiyou100.video.mapper;

import com.zhiyou100.video.model.Admin;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * @author Kun
 */
@Repository
public interface AdminMapper {

    List<Admin> queryAllAdmins();

    Admin queryAdminByNameAndPwd(@Param("loginName") String loginName,@Param("loginPwd") String loginPwd);
}
