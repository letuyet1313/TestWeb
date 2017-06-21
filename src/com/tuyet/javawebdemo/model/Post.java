package com.tuyet.javawebdemo.model;
import java.util.Date;
import java.util.Locale.Category;
public class Post implements java.io.Serializable {
    private Integer postId;
    private String postName;
    private Category category;
    private User user;
    private String postContent;
    private String postSlug;
    private Date publishDate;
    private Date lastEdit;
    private String image;
    private int numViews;
    private int status;
    public Post() {
    }
    public Integer getPostId() {
        return postId;
    }
    public void setPostId(Integer postId) {
        this.postId = postId;
    }
    public String getPostName() {
        return postName;
    }
    public void setPostName(String postName) {
        this.postName = postName;
    }
    public Category getCategory() {
        return category;
    }
    public void setCategory(Category category) {
        this.category = category;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public String getPostContent() {
        return postContent;
    }
    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }
    public String getPostSlug() {
        return postSlug;
    }
    public void setPostSlug(String postSlug) {
        this.postSlug = postSlug;
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
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }
    public int getNumViews() {
        return numViews;
    }
    public void setNumViews(int numViews) {
        this.numViews = numViews;
    }
    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
}