package com.zhiyou100.video.service.impl;

import com.zhiyou100.video.mapper.VideoMapper;
import com.zhiyou100.video.model.PageModel;
import com.zhiyou100.video.model.Speaker;
import com.zhiyou100.video.model.Video;
import com.zhiyou100.video.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
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

    @Override
    public PageModel<Video> queryVideoList(HashMap<Object, Object> map) {
        //查询总数量
        int allNum = videoMapper.queryVideoTotal(map);
        System.out.println(allNum);
        //每页显示的条数
        int pageSize = (int) map.get("pageSize");
        int pageNum = (int) map.get("pageNum");
        //结果集合 从数据库查询出来
        int startIndex = (pageNum - 1) * pageSize;
        map.put("startIndex",startIndex);
        List<Video> results = videoMapper.queryAllVideos(map);
        //results 总计录值
        //总页码数
        int pageNums = allNum / pageSize == 0  ? allNum / pageSize : allNum / pageSize + 1;
        PageModel<Video> pageModel = new PageModel<>();
        pageModel.setAllNum(allNum);
        pageModel.setPageNum(pageNum);
        pageModel.setPageNums(pageNums);
        pageModel.setResults(results);
        pageModel.setPageSize(pageSize);
        return pageModel;
    }

    @Override
    public List<Video> getVideosByCourseId(Integer courseId) {
        return videoMapper.queryVideosByCourseId(courseId);
    }

    @Override
    public Video queryVideoByVideoId(Integer videoId) {
        return videoMapper.queryVideoByVideoId(videoId);
    }

    @Override
    public Integer queryCourseByVideoId(Integer videoId) {
        return videoMapper.queryCourseByVideoId(videoId);
    }
}
