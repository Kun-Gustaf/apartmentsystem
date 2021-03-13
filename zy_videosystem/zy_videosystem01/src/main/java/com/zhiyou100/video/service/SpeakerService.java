package com.zhiyou100.video.service;

import com.zhiyou100.video.model.Speaker;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SpeakerService {

    List<Speaker> getAllSpeaker();
    List<Speaker> querySpeakers(@Param("speakerName") String speakerName, @Param("speakerJob") String speakerJob);
    Speaker querySpeakerById(Integer id);
    void deleteSpeakerById(Integer id);
    void updateSpeaker(Speaker speaker);
    void addSpeaker(Speaker speaker);
}
