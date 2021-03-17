package com.zhiyou100.video.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
@WebListener
public class HttpSessionListenerUtil implements HttpSessionListener, HttpSessionAttributeListener {
    //监听Session域中何时存值
    @Override
    public void attributeAdded(HttpSessionBindingEvent sbe) {
        System.out.println("session域中添加属性值了");
        System.out.println("key值：" + sbe.getName());
        //获取session域中的value值
        System.out.println("value值："+sbe.getValue());
        System.out.println("=============================");

    }

    //监听 删除从session域中存储的值
    @Override
    public void attributeRemoved(HttpSessionBindingEvent sbe) {
        System.out.println("session域中开始删除值了");
        System.out.println(sbe.getName());
        System.out.println(sbe.getValue());
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent httpSessionBindingEvent) {

    }
    //监听Session何时创建
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("session 创建了。。。。。。");
        System.out.println("------------"+se.getSession().getId());
        System.out.println("-------"+se.getSession().getAttribute("user"));
        System.out.println("============================");
    }
    //监听session的时机
    @Override
    public void sessionDestroyed(HttpSessionEvent se) {

    }
}
