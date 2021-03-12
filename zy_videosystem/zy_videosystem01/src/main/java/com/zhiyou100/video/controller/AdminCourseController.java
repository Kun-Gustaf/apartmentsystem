package com.zhiyou100.video.controller;

import com.zhiyou100.video.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class AdminCourseController {

    @Autowired
    private CourseService courseService;


}
