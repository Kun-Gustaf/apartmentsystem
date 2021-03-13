package com.zhiyou100.video.mapper;

import com.zhiyou100.video.model.Speaker;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpeakerMapper {
    List<Speaker> queryAllSpeakers();
    List<Speaker> querySpeakers(@Param("speakerName") String speakerName,@Param("speakerJob") String speakerJob);
    Speaker querySpeakerById(Integer id);
    void deleteSpeakerById(Integer id);
    void updateSpeaker(Speaker speaker);
    void addSpeaker(Speaker speaker);
}
