package com.zhiyou100.video.controller;

import com.zhiyou100.video.model.Subject;
import com.zhiyou100.video.model.Video;
import com.zhiyou100.video.service.SubjectService;
import com.zhiyou100.video.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/front/video")
public class FrontVideoController {

    @Autowired
    private SubjectService subjectService;

    @Autowired
    private VideoService videoService;

    @RequestMapping("/index.action")
    public String videoIndex(Model model, Integer videoId, Integer subjectId) {
        Subject subject = subjectService.getSubjectById(subjectId);
        model.addAttribute("subject", subject);
        model.addAttribute("videoId", videoId);
        return "/front/video/index";
    }

    @RequestMapping("/videoData.action")
    public String videoData(Model model, Integer videoId) {
        Video video = videoService.queryVideoByVideoId(videoId);
        System.out.println(video);
        System.out.println(video.getSpeaker());
        model.addAttribute("speaker", video.getSpeaker());
        System.out.println(video.getCourse());
        model.addAttribute("course", video.getCourse());

        model.addAttribute("video", video);
        List<Video> videoList = videoService.getVideosByCourseId(videoService.queryCourseByVideoId(videoId));
        model.addAttribute("videoList", videoList);
        return "/front/video/content";
    }

    @RequestMapping("/state.action")
    public void  addPlayTimes(Integer videoId){
        System.out.println(videoId);
        int i = videoService.getVideoPlayTimes(videoId);
        System.out.println(i);
        videoService.addVideoPlayTimes(i+1,videoId);
    }

}
