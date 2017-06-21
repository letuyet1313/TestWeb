package com.tuyet.javawebdemo.model;

import java.util.Date;
public class Image implements java.io.Serializable {
    private Integer imageId;
    private String imageName;
    private String imageGuid;
    private String imageDesc;
    private Date uploadDate;
    public Image() {
    }
    public Integer getImageId() {
        return imageId;
    }
    public void setImageId(Integer imageId) {
        this.imageId = imageId;
    }
    public String getImageName() {
        return imageName;
    }
    public void setImageName(String imageName) {
        this.imageName = imageName;
    }
    public String getImageGuid() {
        return imageGuid;
    }
    public void setImageGuid(String imageGuid) {
        this.imageGuid = imageGuid;
    }
    public String getImageDesc() {
        return imageDesc;
    }
    public void setImageDesc(String imageDesc) {
        this.imageDesc = imageDesc;
    }
    public Date getUploadDate() {
        return uploadDate;
    }
    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }
}