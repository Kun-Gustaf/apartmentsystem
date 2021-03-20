package com.zhiyou100.video.controller;

import com.zhiyou100.video.model.Course;
import com.zhiyou100.video.service.CourseService;
import com.zhiyou100.video.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin/state")
public class StateController {

    //属性注入 service层对象
    @Autowired
    private VideoService videoService;

    @RequestMapping("/courseavg.action")
    //需要往前端传输xData=["","","",""]
    public String courseavg(Model model){
        //使用video
        List<HashMap> list =  videoService.queryVideoPlayTime();
        System.out.println("统计结果为："+list);
        //准备xDate和yDate的值
        //准备两个list集合 分别取出对应的x轴需要的数据和y轴需要的数据

        ArrayList<Object> xList = new ArrayList<>();
        ArrayList<Object> yList = new ArrayList<>();
        for (HashMap map : list) {
            xList.add(map.get("course_name").toString());
            yList.add(Integer.parseInt(map.get("avgTimes").toString()));
        }
        StringBuffer xData = new StringBuffer();
        StringBuffer yData = new StringBuffer();
        //拼装xDate数据
        xData.append("[");
        yData.append("[");
        for (int i = 0; i < xList.size(); i++) {
            if(i == 0 ){
                xData.append("'" +xList.get(i) +"'");
                yData.append( yList.get(i));
            }else {
                xData.append(",'" +xList.get(i) +"'");
                yData.append("," +yList.get(i));
            }
        }
        xData.append("]");
        yData.append("]");
        System.out.println(xData);
        System.out.println(yData);
        model.addAttribute("xData",xData);
        model.addAttribute("yData",yData);
        //设定跳转的页面
        return "/admin/analysis/show";
    }
}
