package com.xuan.text;
//评价类
public class Evaluation {
    private String  guideName;
    private Integer guideId;
    private Integer good;
    private Integer medium;
    private Integer bad;


    public Evaluation() {
    }

    public Evaluation(String guideName, Integer guideId, Integer good, Integer medium, Integer bad) {
        this.guideName = guideName;
        this.guideId = guideId;
        this.good = good;
        this.medium = medium;
        this.bad = bad;
    }

    public String getGuideName() {
        return guideName;
    }

    public void setGuideName(String guideName) {
        this.guideName = guideName;
    }

    public Integer getGuideId() {
        return guideId;
    }

    public void setGuideId(Integer guideId) {
        this.guideId = guideId;
    }

    public Integer getGood() {
        return good;
    }

    public void setGood(Integer good) {
        this.good = good;
    }

    public Integer getMedium() {
        return medium;
    }

    public void setMedium(Integer medium) {
        this.medium = medium;
    }

    public Integer getBad() {
        return bad;
    }

    public void setBad(Integer bad) {
        this.bad = bad;
    }
}
