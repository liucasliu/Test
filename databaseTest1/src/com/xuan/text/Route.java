package com.xuan.text;
/*
    线路类,线路ID,线路内容,日期,花费金额,导游编号,游客编号
 */
public class Route {
    private Integer routeId;
    private String  route;
    private String  data;
    private Integer money;
    private Integer  guideId;

    public Route() {
    }

    public Route(Integer routeId, String route, String data, Integer money, Integer guideId) {
        this.routeId = routeId;
        this.route = route;
        this.data = data;
        this.money = money;
        this.guideId = guideId;
    }

    public Integer getRouteId() {
        return routeId;
    }

    public void setRouteId(Integer routeId) {
        this.routeId = routeId;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
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

    public Integer getGuideId() {
        return guideId;
    }

    public void setGuideId(Integer guideId) {
        this.guideId = guideId;
    }
}
