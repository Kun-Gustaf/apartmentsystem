package com.zhiyou100.video.service.impl;

import com.zhiyou100.video.mapper.CourseMapper;
import com.zhiyou100.video.model.Course;
import com.zhiyou100.video.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseMapper courseMapper;

    @Override
    public List<Course> getAllCourse() {
        System.out.println(courseMapper);
        return courseMapper.queryAllCourses();
    }

    @Override
    public Course getCourse(Integer id) {
        return courseMapper.queryCourseById(id);
    }

    @Override
    public void deleteCourse(Integer id) {
        courseMapper.deleteCourseById(id);
    }

    @Override
    public void updateCourse(Course course) {
        courseMapper.updateCourse(course);
    }

    @Override
    public void addCourse(Course course) {
        courseMapper.addCourse(course);
    }

    @Override
    public List<Course> getCourses(Integer subjectId) {
        return courseMapper.queryCoursesBySubjectId(subjectId);
    }
}
