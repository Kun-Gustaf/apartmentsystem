package com.lk;

import com.zhiyou100.video.util.MailUtil;
import org.junit.Test;

public class MailTest {
    @Test
    public void testSend() throws Exception{
        String str = "http://gfpeud.natappfree.cc";
//        MailUtil.send("2458336722@qq.com","阿豪收手吧", "能收到不?");String email = "likun4016@163.com";
        String email = "2458336722@qq.com";
        MailUtil.send( email,"激活邮件","<a href='http://akwvpd.natappfree.cc/front/user/activeAccount.action?email="+email +"'>点一点</a>");
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
