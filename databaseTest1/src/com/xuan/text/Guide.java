package com.xuan.text;
/*
    导游类,导游编号,名字,性别,语言,线路
 */
public class Guide {
    private Integer guideId;
    private String  guideName;
    private String  sex;
    private String  language;
    private Integer  routeId;

    public Guide() {
    }

    public Guide(Integer guideId, String guideName, String sex, String language, Integer routeId) {
        this.guideId = guideId;
        this.guideName = guideName;
        this.sex = sex;
        this.language = language;
        this.routeId = routeId;
    }

    public Integer getGuideId() {
        return guideId;
    }

    public void setGuideId(Integer guideId) {
        this.guideId = guideId;
    }

    public String getGuideName() {
        return guideName;
    }

    public void setGuideName(String guideName) {
        this.guideName = guideName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Integer getRouteId() {
        return routeId;
    }

    public void setRouteId(Integer routeId) {
        this.routeId = routeId;
    }
}
