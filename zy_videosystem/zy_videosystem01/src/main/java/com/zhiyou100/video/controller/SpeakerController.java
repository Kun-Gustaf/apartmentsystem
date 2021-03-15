package com.zhiyou100.video.controller;

import com.zhiyou100.video.model.PageModel;
import com.zhiyou100.video.model.Speaker;
import com.zhiyou100.video.service.SpeakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
@Controller
@RequestMapping("/admin/speaker")
public class SpeakerController extends AdminBaseController{

    //service层的属性注入
    @Autowired
    private SpeakerService speakerService;
    /*

        模糊查询 + 分页查询 绑定在一起
     */
    @RequestMapping( "/index.action")
    public String queryAllSpeaker(String queryName, String queryJob, Integer pageNum, Model model){
        //分页对象需要的数据
        //queryName
        //queryJob
        //pageNum
        //pageSize
        //组装分页对象需要的数据
        //allNum
        //results 总计录值
        //输入映射 有一种类型 map
        HashMap<Object, Object> map = new HashMap<>();
        map.put("queryName",queryName);
        map.put("queryJob",queryJob);
        //初始化pageNum
        if(pageNum == null || pageNum < 0){
            pageNum = DEFAULT_PAGE;
        }
        map.put("pageNum",pageNum);
        map.put("pageSize",DEFAULT_PAGE_SIZE);
        System.out.println("=========================");
        System.out.println(map);
        PageModel<Speaker> pageModel = speakerService.querySpeakerList(map);
        //进行数据的回传
        model.addAttribute("pageInfo",pageModel);
        model.addAttribute("queryName",queryName);
        model.addAttribute("queryJob",queryJob);
        //index.jsp页面
        return "/admin/speaker/index";
    }

   /* @RequestMapping("/index.action")
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
    }*/
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
