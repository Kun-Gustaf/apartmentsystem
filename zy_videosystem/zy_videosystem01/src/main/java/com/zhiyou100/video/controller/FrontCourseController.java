package com.zhiyou100.video.controller;

import com.zhiyou100.video.model.Course;
import com.zhiyou100.video.model.Subject;
import com.zhiyou100.video.model.Video;
import com.zhiyou100.video.service.CourseService;
import com.zhiyou100.video.service.SubjectService;
import com.zhiyou100.video.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/front/course")
public class FrontCourseController {
    @Autowired
    private VideoService videoService;
    @Autowired
    private CourseService courseService;
    @Autowired
    private SubjectService subjectService;
    @RequestMapping("/index.action")
    public String courseIndex(Model model, Integer subjectId){
        Subject subject = subjectService.getSubjectById(subjectId);
        model.addAttribute("subject",subject);
        List<Course> courses = courseService.getCourses(subjectId);
        model.addAttribute("courses",courses);

        System.out.println("---------------------------");
        for (int i = 0; i < courses.size(); i++) {
            List<Video> videoList = videoService.getVideosByCourseId(courses.get(i).getId());
            videoList.forEach(System.out::println);
            courses.get(i).setVideoList(videoList);
        }
        return "/front/course/index";
    }
}
