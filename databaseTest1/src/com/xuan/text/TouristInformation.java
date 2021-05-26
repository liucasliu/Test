package com.xuan.text;

public class TouristInformation {
    private String touristName;
    private String guideName;
    private String route;

    public TouristInformation() {
    }

    public TouristInformation(String touristName, String guideName, String route) {
        this.touristName = touristName;
        this.guideName = guideName;
        this.route = route;
    }

    public String getTouristName() {
        return touristName;
    }

    public void setTouristName(String touristName) {
        this.touristName = touristName;
    }

    public String getGuideName() {
        return guideName;
    }

    public void setGuideName(String guideName) {
        this.guideName = guideName;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }
}
