package com.zhiyou100.video.controller;

import com.zhiyou100.video.model.Speaker;
import com.zhiyou100.video.service.SpeakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.List;
@Controller
@RequestMapping("/admin/speaker")
public class SpeakerController {

    @Autowired
    private SpeakerService speakerService;

    @RequestMapping("/index.action")
    public String toIndex(HttpServletRequest req){
        List<Speaker> speakers = speakerService.getAllSpeaker();
        req.setAttribute("results",speakers);
        return "/admin/speaker/index";
    }

    @RequestMapping("fuzzyQuery.action")
    public String fuzzyQuery(HttpServletRequest req,String speakerName,String speakerJob){
        List<Speaker> speakers = speakerService.querySpeakers(speakerName, speakerJob);
        req.setAttribute("results",speakers);
        return "/admin/speaker/index";
    }
    @RequestMapping("/toSaveOrUpdate.action")
    public String toSaveOrUpdate(HttpServletRequest req,Integer id){
        if(id !=null){
            Speaker speaker = speakerService.querySpeakerById(id);
            req.setAttribute("speaker",speaker);
        }
        return "/admin/speaker/saveOrUpdate";
    }

    @RequestMapping("/saveOrUpdate.action")
    public String saveOrUpdate(Speaker speaker){
        if(speaker.getId() !=null){
            speaker.setUpdateTime(new Timestamp(System.currentTimeMillis()));
            speakerService.updateSpeaker(speaker);
        }else {
            speaker.setInsertTime(new Timestamp(System.currentTimeMillis()));
            speakerService.addSpeaker(speaker);
        }
        return "forward:/admin/speaker/index.action";
    }
    @RequestMapping("/delete.action")
    public String deleteSpeaker(Integer id){
        speakerService.deleteSpeakerById(id);
        return "forward:/admin/speaker/index.action";
    }

}
