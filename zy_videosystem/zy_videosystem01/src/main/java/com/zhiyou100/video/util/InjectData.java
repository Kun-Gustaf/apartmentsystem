package com.zhiyou100.video.util;

import com.zhiyou100.video.model.Course;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.http.HttpServletRequest;

public class InjectData {

    public  static Course injectCourse(HttpServletRequest req){
        Course course = new Course();
        try {
            BeanUtils.populate(course,req.getParameterMap());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return course;
    }
}
