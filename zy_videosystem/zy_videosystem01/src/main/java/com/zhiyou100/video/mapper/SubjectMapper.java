package com.zhiyou100.video.mapper;

import com.zhiyou100.video.model.Subject;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectMapper {

    @Select("select * from subject where id = #{id}")
    Subject querySubjectById(Integer id);
}
