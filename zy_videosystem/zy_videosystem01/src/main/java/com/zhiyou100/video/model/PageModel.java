package com.zhiyou100.video.model;

import java.io.Serializable;
import java.util.List;

public class PageModel<T> implements Serializable {

    //pageNum 当前页
    private int pageNum;
    //总页码数
    private int pageNums;
    //allNum总数量
    private  int allNum;
    //每页显示的条数
    private int pageSize;
    //总计录值 集合
    private List<T> results;

    public PageModel(int pageNum, int pageNums, int allNum, int pageSize, List<T> results) {
        this.pageNum = pageNum;
        this.pageNums = pageNums;
        this.allNum = allNum;
        this.pageSize = pageSize;
        this.results = results;
    }

    public PageModel() {
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageNums() {
        return pageNums;
    }

    public void setPageNums(int pageNums) {
        this.pageNums = pageNums;
    }

    public int getAllNum() {
        return allNum;
    }

    public void setAllNum(int allNum) {
        this.allNum = allNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public List<T> getResults() {
        return results;
    }

    public void setResults(List<T> results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return "PageModel{" +
                "pageNum=" + pageNum +
                ", pageNums=" + pageNums +
                ", allNum=" + allNum +
                ", pageSize=" + pageSize +
                ", results=" + results +
                '}';
    }
}
