package com.example.administrator.mycontacts;

// 数据类
public class User {
    // 字段名常量
    public final static String NAME = "name";
    public final static String MOBILE = "mobile";
    public final static String DANWEI = "danwei";
    public final static String QQ = "qq";
    public final static String ADDRESS = "address";
    // 类属性
    private String name;
    private String mobile;
    private String danwei;
    private String qq;
    private String address;
    private int id_DB = -1;

    //getter setter 方法
    public String getName() {
        return name;
    }

    public String getMobile() {
        return mobile;
    }

    public String getDanwei() {
        return danwei;
    }

    public String getQq() {
        return qq;
    }

    public String getAddress() {
        return address;
    }

    public int getId_DB() {
        return id_DB;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public void setDanwei(String danwei) {
        this.danwei = danwei;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setId_DB(int id_DB) {
        this.id_DB = id_DB;
    }
}