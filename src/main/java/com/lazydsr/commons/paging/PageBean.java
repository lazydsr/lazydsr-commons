package com.lazydsr.commons.paging;

import com.lazydsr.commons.base.BaseBean;

/**
 * Coding......
 * Created by D.SR on 2017/3/7.
 * version: 1.0
 */
public class PageBean extends BaseBean<PageBean> {
    private long totalPage; // 总页数
    private long totalCount; // 总记录数
    private long currentPage; // 当前页
    private long pageSize; // 每页的数量
    private long currentPageSize; // 每页的数量
    private boolean isFirstPage; // 是否首页
    private boolean isLastPage; // 是否是最后一页
    private boolean havePrePage; // 是否有上一页
    private boolean haveNextPage; // 是否有下一页
    private long startSize;// 本页从记录的那一条开始
    private long endSize;// 本页从记录的那一条结束
    private Object pageData;


    public PageBean() {
    }

    public PageBean(Long totalCount, Long currentPage, Long pageSize) {

        this.totalCount = totalCount == null || totalCount < 0 ? 0 : totalCount;
        this.currentPage = currentPage == null || currentPage < 1 ? 1 : currentPage;
        this.pageSize = pageSize == null || pageSize < 1 ? 10 : pageSize;



        this.totalPage = this.totalCount % this.pageSize == 0 ? this.totalCount / this.pageSize : this.totalCount / this.pageSize + 1;
        //第二版修复了当前页大于总页数的bug
        this.currentPage = this.currentPage > this.totalPage ? this.totalPage : this.currentPage;
        this.isFirstPage = this.currentPage == 1 ? true : false;
        this.isLastPage = this.currentPage == totalPage ? true : false;
        this.havePrePage = isFirstPage ? false : true;
        this.haveNextPage = isLastPage ? false : true;
        this.startSize = (this.currentPage - 1) * this.pageSize + 1;
        this.endSize = isLastPage ? this.totalCount : this.startSize + this.pageSize - 1;
        this.currentPageSize = this.endSize - this.startSize + 1;
    }

    @Override
    public String toString() {
        return "PageBeanImpl{" +
                "totalPage=" + totalPage +
                ", totalCount=" + totalCount +
                ", currentPage=" + currentPage +
                ", pageSize=" + pageSize +
                ", currentPageSize=" + currentPageSize +
                ", isFirstPage=" + isFirstPage +
                ", isLastPage=" + isLastPage +
                ", havePrePage=" + havePrePage +
                ", haveNextPage=" + haveNextPage +
                ", startSize=" + startSize +
                ", endSize=" + endSize +
                ", pageData=" + pageData +
                '}';
    }

    public long getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(long totalPage) {
        this.totalPage = totalPage;
    }

    public long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
    }

    public long getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(long currentPage) {
        this.currentPage = currentPage;
    }

    public long getPageSize() {
        return pageSize;
    }

    public void setPageSize(long pageSize) {
        this.pageSize = pageSize;
    }

    public long getCurrentPageSize() {
        return currentPageSize;
    }

    public void setCurrentPageSize(long currentPageSize) {
        this.currentPageSize = currentPageSize;
    }

    public boolean isFirstPage() {
        return isFirstPage;
    }

    public void setFirstPage(boolean firstPage) {
        isFirstPage = firstPage;
    }

    public boolean isLastPage() {
        return isLastPage;
    }

    public void setLastPage(boolean lastPage) {
        isLastPage = lastPage;
    }

    public boolean isHavePrePage() {
        return havePrePage;
    }

    public void setHavePrePage(boolean havePrePage) {
        this.havePrePage = havePrePage;
    }

    public boolean isHaveNextPage() {
        return haveNextPage;
    }

    public void setHaveNextPage(boolean haveNextPage) {
        this.haveNextPage = haveNextPage;
    }

    public long getStartSize() {
        return startSize;
    }

    public void setStartSize(long startSize) {
        this.startSize = startSize;
    }

    public long getEndSize() {
        return endSize;
    }

    public void setEndSize(long endSize) {
        this.endSize = endSize;
    }

    public Object getPageData() {
        return pageData;
    }

    public void setPageData(Object pageData) {
        this.pageData = pageData;
    }
}
