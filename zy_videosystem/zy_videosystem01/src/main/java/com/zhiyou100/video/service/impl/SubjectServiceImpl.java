package com.zhiyou100.video.service.impl;

import com.zhiyou100.video.mapper.SubjectMapper;
import com.zhiyou100.video.model.Subject;
import com.zhiyou100.video.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    private SubjectMapper subjectMapper;

    @Override
    public List<Subject> getAllSubjects() {
        return subjectMapper.queryAllSubjects();
    }

    @Override
    public Subject getSubjectById(Integer id) {
        return subjectMapper.querySubjectById(id);
    }
}
