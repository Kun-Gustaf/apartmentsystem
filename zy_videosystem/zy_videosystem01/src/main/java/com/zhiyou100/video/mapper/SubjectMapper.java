package com.zhiyou100.video.mapper;

import com.zhiyou100.video.model.Subject;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubjectMapper {

    Subject querySubjectById(Integer id);

    List<Subject> queryAllSubjects();
}
