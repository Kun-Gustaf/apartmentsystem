package com.zhiyou100.video.model;

import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

@Component
public class Course implements Serializable {

    private Integer id;
    private String courseName;
    private String courseDesc;
    private Timestamp insertTime;
    private Timestamp updateTime;
    private Integer subjectId;
    private Subject subject;
    private List<Video> videoList;
    public Course() {
    }

    public Course(Integer id, String courseName, String courseDesc, Timestamp insertTime, Timestamp updateTime, Integer subjectId, Subject subject) {
        this.id = id;
        this.courseName = courseName;
        this.courseDesc = courseDesc;
        this.insertTime = insertTime;
        this.updateTime = updateTime;
        this.subjectId = subjectId;
        this.subject = subject;
    }

    public Course(Integer id, String courseName, String courseDesc, Timestamp insertTime, Timestamp updateTime, Integer subjectId, Subject subject, List<Video> videoList) {
        this.id = id;
        this.courseName = courseName;
        this.courseDesc = courseDesc;
        this.insertTime = insertTime;
        this.updateTime = updateTime;
        this.subjectId = subjectId;
        this.subject = subject;
        this.videoList = videoList;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseDesc() {
        return courseDesc;
    }

    public void setCourseDesc(String courseDesc) {
        this.courseDesc = courseDesc;
    }

    public Timestamp getInsertTime() {
        return insertTime;
    }

    public void setInsertTime(Timestamp insertTime) {
        this.insertTime = insertTime;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    public List<Video> getVideoList() {
        return videoList;
    }

    public void setVideoList(List<Video> videoList) {
        this.videoList = videoList;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", courseName='" + courseName + '\'' +
                ", courseDesc='" + courseDesc + '\'' +
                ", insertTime=" + insertTime +
                ", updateTime=" + updateTime +
                ", subjectId=" + subjectId +
                ", subject=" + subject +
                ", videoList=" + videoList +
                '}';
    }
}
