package com.zhiyou100.video.controller;

import com.zhiyou100.video.model.Course;
import com.zhiyou100.video.model.PageModel;
import com.zhiyou100.video.model.Speaker;
import com.zhiyou100.video.model.Video;
import com.zhiyou100.video.service.CourseService;
import com.zhiyou100.video.service.SpeakerService;
import com.zhiyou100.video.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/admin/video")
public class AdminVideoController extends  AdminBaseController{

    @Autowired
    private VideoService videoService;
    @Autowired
    private CourseService courseService;
    @Autowired
    private SpeakerService speakerService;

    @RequestMapping("/index.action")
    public String getAllVideos(Model model, String videoTitle, Integer speakerId, Integer courseId, Integer pageNum){
        HashMap<Object, Object> map = new HashMap<>();
        map.put("videoTitle",videoTitle);
        map.put("speakerId",speakerId);
        map.put("courseId",courseId);
        //初始化pageNum
        if(pageNum == null || pageNum < 0){
            pageNum = DEFAULT_PAGE;
        }
        map.put("pageNum",pageNum);
        map.put("pageSize",DEFAULT_VIDEO_PAGE_SIZE);
        PageModel<Video> pageModel = videoService.queryVideoList(map);
        //进行数据的回传
        List<Course> courses = courseService.getAllCourse();
        List<Speaker> speakers = speakerService.getAllSpeakers();
        model.addAttribute("courses",courses);
        model.addAttribute("speakers",speakers);
        model.addAttribute("pageInfo",pageModel);

        model.addAttribute("videoTitle",videoTitle);
        model.addAttribute("speakerId",speakerId);
        model.addAttribute("courseId",courseId);
        return "/admin/video/index";
    }
    @RequestMapping("/fuzzyQuery.action")
    public String fuzzyQuery(HttpServletRequest req,String videoTitle,Integer speakerId,Integer courseId){
        List<Speaker> speakers = speakerService.getAllSpeakers();
        List<Course> courses = courseService.getAllCourse();
        List<Video> results = videoService.queryVideo(videoTitle,speakerId, courseId);
        req.setAttribute("speakers",speakers);
        req.setAttribute("courses",courses);
        req.setAttribute("results",results);
        return "/admin/video/index";
    }

    @RequestMapping("/add.action")
    public String AddVideo(Video video){
        video.setInsertTime(new Timestamp(System.currentTimeMillis()));
        videoService.addVideo(video);
        return "forward:/admin/video/index.action";
    }
    @RequestMapping("/saveOrUpdate.action")
    public String goEditVideo(HttpServletRequest req,Integer id){
        List<Speaker> speakers = speakerService.getAllSpeakers();
        List<Course> courses = courseService.getAllCourse();
        req.setAttribute("speakers",speakers);
        req.setAttribute("courses",courses);
        if(id != null){
            Video video = videoService.queryVideoById(id);
            req.setAttribute("video",video);
        }
        return "/admin/video/saveOrUpdate";
    }

    @RequestMapping("/edit.action")
    public String editVideo(Video video){
        video.setUpdateTime(new Timestamp(System.currentTimeMillis()));
        videoService.updateVideo(video);
        return "forward:/admin/video/index.action";
    }

    @RequestMapping("/delete.action")
    public void deleteVideo(HttpServletResponse resp,Integer id)  {
         try{
             videoService.deleteVideo(id);
             resp.getWriter().write("success");
         }catch(Exception e){
             try {
                 resp.getWriter().write("fail");
             } catch (IOException ioException) {
                 ioException.printStackTrace();
             }
         }
    }

    @RequestMapping("/batchDelete.action")
    public String batchDelete(HttpServletRequest req){
        String[] checkIds = req.getParameterValues("checkId");
        for (String checkId : checkIds) {
            videoService.deleteVideo(Integer.parseInt(checkId));
        }
        return "forward:/admin/video/index.action";
    }

}
