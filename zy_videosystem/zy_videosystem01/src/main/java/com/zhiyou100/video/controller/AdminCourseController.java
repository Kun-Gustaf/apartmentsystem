package com.zhiyou100.video.controller;

import com.zhiyou100.video.model.Course;
import com.zhiyou100.video.service.CourseService;
import com.zhiyou100.video.service.SubjectService;
import com.zhiyou100.video.util.InjectData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/admin/course")
public class AdminCourseController {

    @Autowired
    private CourseService courseService;
    @Autowired
    private SubjectService subjectService;


    @RequestMapping("/add.action")
    public ModelAndView addCourse(){
        ModelAndView mav = new ModelAndView();
        List<Subject> subjects = subjectService.getAllSubjects();
        System.out.println(subjects);
        subjects.forEach(System.out::println);
        mav.addObject("subjects",subjects);
        mav.setViewName("/admin/course/saveOrUpdate");
        return mav;
    }

    @RequestMapping("/saveOrUpdate.action")
    public String saveOrUpdateCourse(HttpServletRequest req){
        Course course = InjectData.injectCourse(req);
        if(course.getId()!=null){
            courseService.updateCourse(course);
        }else {
            courseService.addCourse(course);
        }
        return "";
    }

    @RequestMapping("/index.action")
    public ModelAndView getAllCourses(HttpServletRequest req){
        List<Course> courses = courseService.getAllCourse();
        ModelAndView mav = new ModelAndView();
        req.setAttribute("results",courses);
        courses.forEach(System.out::println);
        mav.setViewName("/admin/course/index");
        return mav;
    }

}
