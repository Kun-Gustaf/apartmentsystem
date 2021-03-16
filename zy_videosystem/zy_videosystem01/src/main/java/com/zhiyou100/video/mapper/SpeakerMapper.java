package com.zhiyou100.video.mapper;

import com.zhiyou100.video.model.Speaker;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public interface SpeakerMapper {
    List<Speaker> queryAllSpeakers();
    Speaker querySpeakerById(Integer id);
    void deleteSpeakerById(Integer id);
    void updateSpeaker(Speaker speaker);
    void addSpeaker(Speaker speaker);

    //总数量
    int querySpeakerTotal(HashMap<Object, Object> map);
    //总计录值
    List<Speaker> queryAllSpeaker(HashMap<Object, Object> map);
}
