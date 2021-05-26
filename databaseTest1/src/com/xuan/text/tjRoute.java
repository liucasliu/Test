package com.xuan.text;
/*
    特价线路类,特价线路id,特价线路内容,花费金额,日期
 */
public class tjRoute {
    private  Integer tjrouteId;
    private  String  tjroute;
    private  String  data;
    private  Integer money;

    public tjRoute() {
    }

    public tjRoute(Integer tjrouteId, String tjroute, String data, Integer money) {
        this.tjrouteId = tjrouteId;
        this.tjroute = tjroute;
        this.data = data;
        this.money = money;
    }

    public Integer getTjrouteId() {
        return tjrouteId;
    }

    public void setTjrouteId(Integer tjrouteId) {
        this.tjrouteId = tjrouteId;
    }

    public String getTjroute() {
        return tjroute;
    }

    public void setTjroute(String tjroute) {
        this.tjroute = tjroute;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }
}
