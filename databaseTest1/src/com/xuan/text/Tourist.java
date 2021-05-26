package com.xuan.text;
/*
    游客类,游客编号,游客名字,性别,联系电话
 */
public class Tourist {
    private Integer touristId;
    private String touristName;
    private String sex;
    private String phoneNumber;
    private Integer routeId;

    public Integer getRouteId() {
        return routeId;
    }

    public void setRouteId(Integer routeId) {
        this.routeId = routeId;
    }

    public Integer getTouristId() {
        return touristId;
    }

    public Tourist() {
    }

    public Tourist(Integer touristId, String touristName, String sex, String phoneNumber, Integer routeId) {
        this.touristId = touristId;
        this.touristName = touristName;
        this.sex = sex;
        this.phoneNumber = phoneNumber;
        this.routeId = routeId;
    }

    public void setTouristId(Integer touristId) {
        this.touristId = touristId;
    }

    public String getTouristName() {
        return touristName;
    }

    public void setTouristName(String touristName) {
        this.touristName = touristName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}