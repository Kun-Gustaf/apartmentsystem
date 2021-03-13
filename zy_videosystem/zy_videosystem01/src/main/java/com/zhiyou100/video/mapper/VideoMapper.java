package com.zhiyou100.video.mapper;

import com.zhiyou100.video.model.Video;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VideoMapper {
    List<Video> queryAllVideo();
    List<Video> queryVideo(@Param("videoTitle") String videoTitle,@Param("speakerId") Integer speakerId,@Param("courseId") Integer courseId);
    Video queryVideoById(Integer id);
    void deleteVideo(Integer id);
    void updateVideo(Video video);
    void addVideo(Video video);
}
