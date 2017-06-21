package com.tuyet.javawebdemo.model;

public class AppParam implements java.io.Serializable {
    private Integer parId;
    private String parType;
    private int parCode;
    private String parDesc;
    private int parStatus;
    private int parOrder;
    private String parColor;
    public AppParam() {
    }
    public Integer getParId() {
        return parId;
    }
    public void setParId(Integer parId) {
        this.parId = parId;
    }
    public String getParType() {
        return parType;
    }
    public void setParType(String parType) {
        this.parType = parType;
    }
    public int getParCode() {
        return parCode;
    }
    public void setParCode(int parCode) {
        this.parCode = parCode;
    }
    public String getParDesc() {
        return parDesc;
    }
    public void setParDesc(String parDesc) {
        this.parDesc = parDesc;
    }
    public int getParStatus() {
        return parStatus;
    }
    public void setParStatus(int parStatus) {
        this.parStatus = parStatus;
    }
    public int getParOrder() {
        return parOrder;
    }
    public void setParOrder(int parOrder) {
        this.parOrder = parOrder;
    }
    public String getParColor() {
        return parColor;
    }
    public void setParColor(String parColor) {
        this.parColor = parColor;
    }
}