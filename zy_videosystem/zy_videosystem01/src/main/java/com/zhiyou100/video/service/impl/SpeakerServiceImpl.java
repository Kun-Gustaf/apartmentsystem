package com.zhiyou100.video.service.impl;

import com.zhiyou100.video.mapper.SpeakerMapper;
import com.zhiyou100.video.model.Speaker;
import com.zhiyou100.video.service.SpeakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpeakerServiceImpl implements SpeakerService {
    @Autowired
    private SpeakerMapper speakerMapper;

    @Override
    public List<Speaker> getAllSpeaker() {
        return speakerMapper.queryAllSpeakers();
    }

    @Override
    public List<Speaker> querySpeakers(String speakerName, String speakerJob) {
        return speakerMapper.querySpeakers(speakerName, speakerJob);
    }

    @Override
    public Speaker querySpeakerById(Integer id) {
        return speakerMapper.querySpeakerById(id);
    }

    @Override
    public void deleteSpeakerById(Integer id) {
        speakerMapper.deleteSpeakerById(id);
    }

    @Override
    public void updateSpeaker(Speaker speaker) {
        speakerMapper.updateSpeaker(speaker);
    }

    @Override
    public void addSpeaker(Speaker speaker) {
        speakerMapper.addSpeaker(speaker);
    }
}
