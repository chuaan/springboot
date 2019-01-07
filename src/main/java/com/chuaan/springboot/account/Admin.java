package com.chuaan.springboot.account;


/**
 * 用户的权限和uid
 * author:chuaan
 * created:2018.12.28
 *
 */
public class Admin {
    //超级用户
    public static final int SUPER = 0;
    //一般用户
    public static final int NORMAL = 1;
    //禁止用户
    public static final int REJECT = 99;

    private int admin;

    //uid
    private long uid;
    //name
    private String name = "";

    public Admin(){
        setAdmin(REJECT);
        setName("");
        setUid(-1);
    }

    public Admin(User user){
        setAdminFromUser(user);
    }

    public int getAdmin() {
        return admin;
    }

    public void setAdmin(int admin) {
        this.admin = admin;
    }

    public void setAdminFromUser(User user){
        setAdmin(user.getAdmin());
        setName(user.getUsername());
        setUid(user.getUid());

    }

    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return ""+admin+","+uid+","+name;
    }
}
