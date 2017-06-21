package com.tuyet.javawebdemo.model;
import java.util.Date;
public class Page implements java.io.Serializable {
    private Integer pageId;
    private String pageName;
    private String pageContent;
    private String pageSlug;
    private User user;
    private Date publishDate;
    private Date lastEdit;
    private int satus;
    public Page() {
    }
    public Integer getPageId() {
        return pageId;
    }
    public void setPageId(Integer pageId) {
        this.pageId = pageId;
    }
    public String getPageName() {
        return pageName;
    }
    public void setPageName(String pageName) {
        this.pageName = pageName;
    }
    public String getPageContent() {
        return pageContent;
    }
    public void setPageContent(String pageContent) {
        this.pageContent = pageContent;
    }
    public String getPageSlug() {
        return pageSlug;
    }
    public void setPageSlug(String pageSlug) {
        this.pageSlug = pageSlug;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public Date getPublishDate() {
        return publishDate;
    }
    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }
    public Date getLastEdit() {
        return lastEdit;
    }
    public void setLastEdit(Date lastEdit) {
        this.lastEdit = lastEdit;
    }
    public int getSatus() {
        return satus;
    }
    public void setSatus(int satus) {
        this.satus = satus;
    }
}