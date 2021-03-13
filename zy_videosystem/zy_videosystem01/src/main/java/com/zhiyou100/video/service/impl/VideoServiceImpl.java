package com.zhiyou100.video.service.impl;

import com.zhiyou100.video.mapper.VideoMapper;
import com.zhiyou100.video.model.Video;
import com.zhiyou100.video.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoServiceImpl implements VideoService {
    @Autowired
    private VideoMapper videoMapper;

    @Override
    public List<Video> getAllVideos() {
        return videoMapper.queryAllVideo();
    }

    @Override
    public List<Video>  queryVideo(String videoTitle, Integer speakerId, Integer courseId) {
        return  videoMapper.queryVideo(videoTitle, speakerId, courseId);
    }

    @Override
    public Video queryVideoById(Integer id) {
        return videoMapper.queryVideoById(id);
    }

    @Override
    public void deleteVideo(Integer id) {
        videoMapper.deleteVideo(id);
    }

    @Override
    public void updateVideo(Video video) {
        videoMapper.updateVideo(video);
    }

    @Override
    public void addVideo(Video video) {
        videoMapper.addVideo(video);
    }
}
