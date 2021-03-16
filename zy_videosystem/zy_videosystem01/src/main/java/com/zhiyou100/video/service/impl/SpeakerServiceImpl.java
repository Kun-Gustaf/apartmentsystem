package com.zhiyou100.video.service.impl;

import com.zhiyou100.video.mapper.SpeakerMapper;
import com.zhiyou100.video.model.PageModel;
import com.zhiyou100.video.model.Speaker;
import com.zhiyou100.video.service.SpeakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
//主讲人业务实现类
@Service
public class SpeakerServiceImpl implements SpeakerService {

    @Autowired
    private SpeakerMapper speakerMapper;

   @Override
    public List<Speaker> getAllSpeakers() {
        return speakerMapper.queryAllSpeakers();
    }

    @Override
    public Speaker querySpeakerById(Integer id) {
        return speakerMapper.querySpeakerById(id);
    }

    @Override
    public void deleteSpeakerById(Integer id) {
        speakerMapper.deleteSpeakerById(id);
    }

    @Override
    public void updateSpeaker(Speaker speaker) {
        speakerMapper.updateSpeaker(speaker);
    }

    @Override
    public void addSpeaker(Speaker speaker) {
        speakerMapper.addSpeaker(speaker);
    }

    @Override
    public PageModel<Speaker> querySpeakerList(HashMap<Object, Object> map) {
        //查询总数量
        int allNum = speakerMapper.querySpeakerTotal(map);
        System.out.println(allNum);
        //每页显示的条数
        int pageSize = (int) map.get("pageSize");
        int pageNum = (int) map.get("pageNum");
        //结果集合 从数据库查询出来
        int startIndex = (pageNum - 1) * pageSize;
        map.put("startIndex",startIndex);
        List<Speaker> results = speakerMapper.queryAllSpeaker(map);
        //results 总计录值
        //总页码数
        int pageNums = allNum / pageSize == 0  ? allNum / pageSize : allNum / pageSize + 1;
        PageModel<Speaker> pageModel = new PageModel<>();
        pageModel.setAllNum(allNum);
        pageModel.setPageNum(pageNum);
        pageModel.setPageNums(pageNums);
        pageModel.setResults(results);
        pageModel.setPageSize(pageSize);
        return pageModel;
    }
}
