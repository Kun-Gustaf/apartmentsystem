package com.zhiyou100.video.service;

import com.zhiyou100.video.model.PageModel;
import com.zhiyou100.video.model.Speaker;
import com.zhiyou100.video.model.Video;

import java.util.HashMap;
import java.util.List;

public interface VideoService {
    List<Video> getAllVideos();
    List<Video>  queryVideo(String videoTitle,Integer speakerId,Integer courseId);
    Video queryVideoById(Integer id);
    void deleteVideo(Integer id);
    void updateVideo(Video video);
    void addVideo(Video video);
    PageModel<Video> queryVideoList(HashMap<Object, Object> map);
    List<Video>  getVideosByCourseId(Integer courseId);
    Video queryVideoByVideoId(Integer videoId);
    Integer queryCourseByVideoId(Integer videoId);
}
