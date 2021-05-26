package com.xuan.text;

public class User {
    private String UserName;
    private String PassWord;
    private String jurisdiction;

    public User() {
    }

    public User(String userName, String passWord, String jurisdiction) {
        UserName = userName;
        PassWord = passWord;
        this.jurisdiction = jurisdiction;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getPassWord() {
        return PassWord;
    }

    public void setPassWord(String passWord) {
        PassWord = passWord;
    }

    public String getJurisdiction() {
        return jurisdiction;
    }

    public void setJurisdiction(String jurisdiction) {
        this.jurisdiction = jurisdiction;
    }
}
