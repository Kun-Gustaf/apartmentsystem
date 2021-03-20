package com.zhiyou100.video.model;


import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;
import java.sql.Timestamp;

@Component
public class User implements Serializable {
    private Integer id;
    private String nickName;
    private Integer sex;
    private Date birthday;
    private String email;
    private String province;
    private String city;
    private String headUrl;
    private String password;
    private Timestamp insertTime;
    private Timestamp updateTime;
    private String captcha;
    private Long active;

    public User() {
    }

    public User(Integer id, String nickName, Integer sex, Date birthday, String email, String province, String city, String headUrl, String password, Timestamp insertTime, Timestamp updateTime, String captcha) {
        this.id = id;
        this.nickName = nickName;
        this.sex = sex;
        this.birthday = birthday;
        this.email = email;
        this.province = province;
        this.city = city;
        this.headUrl = headUrl;
        this.password = password;
        this.insertTime = insertTime;
        this.updateTime = updateTime;
        this.captcha = captcha;
    }

    public User(Integer id, String nickName, Integer sex, Date birthday, String email, String province, String city, String headUrl, String password, Timestamp insertTime, Timestamp updateTime, String captcha, Long active) {
        this.id = id;
        this.nickName = nickName;
        this.sex = sex;
        this.birthday = birthday;
        this.email = email;
        this.province = province;
        this.city = city;
        this.headUrl = headUrl;
        this.password = password;
        this.insertTime = insertTime;
        this.updateTime = updateTime;
        this.captcha = captcha;
        this.active = active;
    }

    public Long getActive() {
        return active;
    }

    public void setActive(Long active) {
        this.active = active;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getHeadUrl() {
        return headUrl;
    }

    public void setHeadUrl(String headUrl) {
        this.headUrl = headUrl;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Timestamp getInsertTime() {
        return insertTime;
    }

    public void setInsertTime(Timestamp insertTime) {
        this.insertTime = insertTime;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    public String getCaptcha() {
        return captcha;
    }

    public void setCaptcha(String captcha) {
        this.captcha = captcha;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", nickName='" + nickName + '\'' +
                ", sex=" + sex +
                ", birthday=" + birthday +
                ", email='" + email + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", headUrl='" + headUrl + '\'' +
                ", password='" + password + '\'' +
                ", insertTime=" + insertTime +
                ", updateTime=" + updateTime +
                ", captcha='" + captcha + '\'' +
                ", active=" + active +
                '}';
    }
}
