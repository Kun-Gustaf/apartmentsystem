package com.zhiyou100.video.model;

import java.io.Serializable;

public class Admin implements Serializable {
    private Integer id;
    private String loginName;
    private String loginPwd;


    public Admin() {
    }

    public Admin(Integer id, String loginName, String loginPwd) {
        this.id = id;
        this.loginName = loginName;
        this.loginPwd = loginPwd;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getLoginPwd() {
        return loginPwd;
    }

    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", loginName='" + loginName + '\'' +
                ", loginPwd='" + loginPwd + '\'' +
                '}';
    }
}
