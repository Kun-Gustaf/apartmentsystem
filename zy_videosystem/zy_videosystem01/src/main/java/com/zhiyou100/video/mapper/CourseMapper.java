package com.zhiyou100.video.mapper;

import com.zhiyou100.video.model.Course;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseMapper {
    //查找所有的课程信息
   List<Course> queryAllCourses();
    //通过id查找课程信息
   Course queryCourseById(Integer id);
    //添加课程信息
    void addCourse(Course course);
    //修改课程信息
    void updateCourse(Course course);
    //通过id删除课程
    void deleteCourseById(Integer id);

}
