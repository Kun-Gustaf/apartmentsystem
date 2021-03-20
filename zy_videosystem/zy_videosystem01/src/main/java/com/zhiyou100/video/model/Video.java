package com.zhiyou100.video.model;

import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.sql.Timestamp;

@Component
public class Video implements Serializable {
    private Integer id;
    private String videoTitle;
    private Integer speakerId;
    private Integer courseId;
    private Integer videoLength;
    private String videoImageUrl;
    private String videoUrl;
    private String videoDesc;
    private Timestamp insertTime;
    private Timestamp updateTime;
    private Integer videoPlayTimes;
    private Course course;
    private Speaker speaker;
    private String videoLengthStr;
    public Video() {
    }

    public Video(Integer id, String videoTitle, Integer speakerId, Integer courseId, Integer videoLength, String videoImageUrl, String videoUrl, String videoDesc, Timestamp insertTime, Timestamp updateTime, Integer videoPlayTimes, Course course, Speaker speaker) {
        this.id = id;
        this.videoTitle = videoTitle;
        this.speakerId = speakerId;
        this.courseId = courseId;
        this.videoLength = videoLength;
        this.videoImageUrl = videoImageUrl;
        this.videoUrl = videoUrl;
        this.videoDesc = videoDesc;
        this.insertTime = insertTime;
        this.updateTime = updateTime;
        this.videoPlayTimes = videoPlayTimes;
        this.course = course;
        this.speaker = speaker;
    }

    public Video(Integer id, String videoTitle, Integer speakerId, Integer courseId, Integer videoLength, String videoImageUrl, String videoUrl, String videoDesc, Timestamp insertTime, Timestamp updateTime, Integer videoPlayTimes, Course course, Speaker speaker, String videoLengthStr) {
        this.id = id;
        this.videoTitle = videoTitle;
        this.speakerId = speakerId;
        this.courseId = courseId;
        this.videoLength = videoLength;
        this.videoImageUrl = videoImageUrl;
        this.videoUrl = videoUrl;
        this.videoDesc = videoDesc;
        this.insertTime = insertTime;
        this.updateTime = updateTime;
        this.videoPlayTimes = videoPlayTimes;
        this.course = course;
        this.speaker = speaker;
        this.videoLengthStr = videoLengthStr;
    }

    public String getVideoLengthStr() {
        return videoLengthStr;
    }

    public void setVideoLengthStr() {
        int hour = videoLength / 3600;
        int temp = videoLength % 3600;
        int minute = temp / 60;
        int second = temp % 60;
        this.videoLengthStr = hour+":"+minute+":"+second;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Speaker getSpeaker() {
        return speaker;
    }

    public void setSpeaker(Speaker speaker) {
        this.speaker = speaker;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVideoTitle() {
        return videoTitle;
    }

    public void setVideoTitle(String videoTitle) {
        this.videoTitle = videoTitle;
    }

    public Integer getSpeakerId() {
        return speakerId;
    }

    public void setSpeakerId(Integer speakerId) {
        this.speakerId = speakerId;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Integer getVideoLength() {
        return videoLength;
    }

    public void setVideoLength(Integer videoLength) {
        this.videoLength = videoLength;
    }

    public String getVideoImageUrl() {
        return videoImageUrl;
    }

    public void setVideoImageUrl(String videoImageUrl) {
        this.videoImageUrl = videoImageUrl;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getVideoDesc() {
        return videoDesc;
    }

    public void setVideoDesc(String videoDesc) {
        this.videoDesc = videoDesc;
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

    public Integer getVideoPlayTimes() {
        return videoPlayTimes;
    }

    public void setVideoPlayTimes(Integer videoPlayTimes) {
        this.videoPlayTimes = videoPlayTimes;
    }

    @Override
    public String toString() {
        return "Video{" +
                "id=" + id +
                ", videoTitle='" + videoTitle + '\'' +
                ", speakerId=" + speakerId +
                ", courseId=" + courseId +
                ", videoLength=" + videoLength +
                ", videoImageUrl='" + videoImageUrl + '\'' +
                ", videoUrl='" + videoUrl + '\'' +
                ", videoDesc='" + videoDesc + '\'' +
                ", insertTime=" + insertTime +
                ", updateTime=" + updateTime +
                ", videoPlayTimes=" + videoPlayTimes +
                ", course=" + course +
                ", speaker=" + speaker +
                '}';
    }
}
