package com.zhiyou100.video.mapper;

import com.zhiyou100.video.model.Course;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseMapper {
    /*@Results(
            id = "userMap",
            value = {
                    @Result(id = true,property = "id",column = "id"),
                    @Result(property="courseName", column="course_name"),
                    @Result(property="courseDesc", column="course_desc"),
                    @Result(property="insertTime", column="insert_time"),
                    @Result(property="updateTime", column="update_time"),
                    @Result(property="subjectId", column="subject_id"),
                    @Result(column ="subject_id",
                            property = "subject",
                            one = @One(select = "com.zhiyou100.video.mapper.SubjectMapper.querySubjectById",fetchType = FetchType.EAGER)
                    )
            }
    )
    @Select("select * from course,subject where course.subject_id = subject.id")*/
    List<Course> queryAllCourses();


}
