package com.zhiyou100.video.model;

import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.sql.Timestamp;

@Component
public class Speaker implements Serializable {
    private Integer id;
    private String speakerName;
    private String speakerJob;
    private String speakerHeadUrl;
    private String speakerDesc;
    private Timestamp insertTime;
    private Timestamp updateTime;

    public Speaker() {
    }

    public Speaker(Integer id, String speakerName, String speakerJob, String speakerHeadUrl, String speakerDesc, Timestamp insertTime, Timestamp updateTime) {
        this.id = id;
        this.speakerName = speakerName;
        this.speakerJob = speakerJob;
        this.speakerHeadUrl = speakerHeadUrl;
        this.speakerDesc = speakerDesc;
        this.insertTime = insertTime;
        this.updateTime = updateTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSpeakerName() {
        return speakerName;
    }

    public void setSpeakerName(String speakerName) {
        this.speakerName = speakerName;
    }

    public String getSpeakerJob() {
        return speakerJob;
    }

    public void setSpeakerJob(String speakerJob) {
        this.speakerJob = speakerJob;
    }

    public String getSpeakerHeadUrl() {
        return speakerHeadUrl;
    }

    public void setSpeakerHeadUrl(String speakerHeadUrl) {
        this.speakerHeadUrl = speakerHeadUrl;
    }

    public String getSpeakerDesc() {
        return speakerDesc;
    }

    public void setSpeakerDesc(String speakerDesc) {
        this.speakerDesc = speakerDesc;
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

    @Override
    public String toString() {
        return "speaker{" +
                "id=" + id +
                ", speakerName='" + speakerName + '\'' +
                ", speakerJob='" + speakerJob + '\'' +
                ", speakerHeadUrl='" + speakerHeadUrl + '\'' +
                ", speakerDesc='" + speakerDesc + '\'' +
                ", insertTime=" + insertTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
