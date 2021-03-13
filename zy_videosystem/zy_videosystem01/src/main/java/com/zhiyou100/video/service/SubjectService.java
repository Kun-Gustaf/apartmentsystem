package com.zhiyou100.video.service;

import com.zhiyou100.video.model.Subject;

import java.util.List;

public interface SubjectService {
    List<Subject> getAllSubjects();
    Subject getSubjectById(Integer id);
}
