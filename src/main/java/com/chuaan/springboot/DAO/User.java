package com.chuaan.springboot.DAO;

/**
 * author:chuaan
 * created:2018-12-29
 */

public class User {
    private long uid;
    private String hashPW;
    private String username;
    private int admin;
    private String nickname;
    private String telephone;

    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public String getHashPW() {
        return hashPW;
    }

    public void setHashPW(String hashPW) {
        this.hashPW = hashPW;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
