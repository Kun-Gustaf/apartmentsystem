package com.zhiyou100.video.model;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Component
public class Subject implements Serializable {
    private Integer id;
    private String subjectName;

    public Subject() {
    }

    public Subject(Integer id, String subjectName) {
        this.id = id;
        this.subjectName = subjectName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
                "id=" + id +
                ", subjectName='" + subjectName + '\'' +
                '}';
    }
}
