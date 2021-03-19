package com.zhiyou100.video.service;

import com.zhiyou100.video.model.Course;

import java.util.List;

public interface CourseService {
    List<Course> getAllCourse();
    Course getCourse(Integer id);
    void deleteCourse(Integer id);
    void updateCourse(Course course);
    void addCourse(Course course);
    List<Course> getCourses(Integer subjectId);
}
