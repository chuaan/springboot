package com.chuaan.springboot.account;


/**
 * 用户类
 * 用户功能的实现和信息保存
 * author:chuaan
 * created:2018.12.28
 */


public class User {
    private long uid = 59442197;

    private String username = "test";


    private int admin = 99;
    private String nickname;
    private String telephone;

    public User(){
        uid=-1;
        username="";
    }



    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUserName(String name) {
        this.username = name;
    }


    public int getAdmin() {
        return admin;
    }

    public void setAdmin(int admin) {
        this.admin = admin;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

}
