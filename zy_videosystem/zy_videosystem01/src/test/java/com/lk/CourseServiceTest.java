package com.lk;

import com.zhiyou100.video.mapper.AdminMapper;
import com.zhiyou100.video.mapper.CourseMapper;
import com.zhiyou100.video.model.Admin;
import com.zhiyou100.video.model.Course;
import com.zhiyou100.video.service.AdminService;
import com.zhiyou100.video.service.CourseService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

public class CourseServiceTest {

    @Autowired
    private CourseMapper courseMapper;

    @Autowired
    private CourseService courseService;

    @Autowired
    private AdminMapper adminMapper;

    @Autowired
    private AdminService adminService;



    @Test
    public void testGetAllCourses(){
        System.out.println(courseMapper);
        System.out.println(courseService);

        List<Course> courses = courseService.getAllCourse();
        courses.forEach(System.out::println);

    }
    @Test
    public void testAdmin(){
        System.out.println(adminMapper);
        System.out.println(adminService);
        if(adminService!=null){
            List<Admin> admins = adminService.getAllAdmins();
            admins.forEach((System.out::println));
        }


    }

    @Test
    public void testTime(){
        Date date = new Date();
        System.out.println(date.getTime());
    }



}
