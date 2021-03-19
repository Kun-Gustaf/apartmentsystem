package com.zhiyou100.video.util;

import org.springframework.util.DigestUtils;

public class MD5Utils {
    public static final String SALT = "zhiyou100";

    // 定义一个方法
    public static String getMD5String(String password) {
        return DigestUtils.md5DigestAsHex(password.getBytes());
    }
}
