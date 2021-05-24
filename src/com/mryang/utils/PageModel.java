package com.mryang.utils;

/**
 * @author Genius
 * @version 1.0.0
 * @ClassName PageModel.java
 * @Description TODO 分页模型
 * @createTime 2021年05月24日 15:30:00
 */
public class PageModel {
    private Integer firstPage = 1; // 首页
    private Integer pageCount = 2; // 一页显示多少条记录
    private Integer curPage; // 当前页
    private Integer totalCount; // 总记录数
    private Integer lastPage; // 总页数

    public PageModel() {
    }

    public PageModel(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public PageModel(Integer pageCount, Integer curPage, Integer totalCount, Integer lastPage) {
        this.pageCount = pageCount;
        this.curPage = curPage;
        this.totalCount = totalCount;
        this.lastPage = lastPage;
    }

    public Integer getFirstPage() {
        return firstPage;
    }

    public void setFirstPage(Integer firstPage) {
        this.firstPage = firstPage;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public Integer getCurPage() {
        return curPage;
    }

    public void setCurPage(Integer curPage) {
        this.curPage = curPage;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getLastPage() {
        return lastPage = totalCount%pageCount>0?(totalCount/pageCount)+1:totalCount/pageCount;
    }

    public void setLastPage(Integer lastPage) {
        this.lastPage = lastPage;
    }
}
