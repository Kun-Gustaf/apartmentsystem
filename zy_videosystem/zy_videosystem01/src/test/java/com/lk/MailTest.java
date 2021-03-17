package com.lk;

import com.zhiyou100.video.util.MailUtil;
import org.junit.Test;

public class MailTest {
    @Test
    public void testSend() throws Exception{
        String str = "http://9uepfs.natappfree.cc";
        MailUtil.send("2458336722@qq.com","阿豪收手吧", "那就好");
    }

    @Test
    public void testStringCode(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            sb.append(Math.round(Math.random() * 9));
        }
        System.out.println(sb);
    }
}
