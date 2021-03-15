package com.zhiyou100.video.service;

import com.zhiyou100.video.model.PageModel;
import com.zhiyou100.video.model.Speaker;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;
//主讲人业务接口
public interface SpeakerService {

    List<Speaker> getAllSpeaker();
    List<Speaker> querySpeakers(@Param("speakerName") String speakerName, @Param("speakerJob") String speakerJob);
    Speaker querySpeakerById(Integer id);
    void deleteSpeakerById(Integer id);
    void updateSpeaker(Speaker speaker);
    void addSpeaker(Speaker speaker);
    //分页+模糊查询
    PageModel<Speaker> querySpeakerList(HashMap<Object, Object> map);
}
