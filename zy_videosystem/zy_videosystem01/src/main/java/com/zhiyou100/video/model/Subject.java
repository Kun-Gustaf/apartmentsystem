package com.zhiyou100.video.model;

import org.springframework.stereotype.Component;

@Component("subject")
public class Subject {

    private Integer id;
    private String subjectName;

    public Subject() {
    }

    public Subject(Integer id, String subjectName) {
        this.id = id;
        this.subjectName = subjectName;
    }

    public Integer getSubjectId() {
        return id;
    }

    public void setSubjectId(Integer subjectId) {
        this.id = subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "subjectId=" + id +
                ", subjectName='" + subjectName + '\'' +
                '}';
    }
}
