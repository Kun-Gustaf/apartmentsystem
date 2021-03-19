package com.lk;

import com.zhiyou100.video.util.MD5Utils;
import org.junit.Test;

public class MD5Test {

    @Test
    public void testMD5(){
        String md5String = MD5Utils.getMD5String("123456"+MD5Utils.SALT);
        System.out.println(md5String);
        /*
        e10adc3949ba59abbe56e057f20f883e
        */

    }
}
