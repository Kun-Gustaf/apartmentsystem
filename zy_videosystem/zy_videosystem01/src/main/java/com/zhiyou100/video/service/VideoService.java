package com.zhiyou100.video.service;

import com.zhiyou100.video.model.Video;

import java.util.List;

public interface VideoService {
    List<Video> getAllVideos();
    List<Video>  queryVideo(String videoTitle,Integer speakerId,Integer courseId);
    Video queryVideoById(Integer id);
    void deleteVideo(Integer id);
    void updateVideo(Video video);
    void addVideo(Video video);
}
