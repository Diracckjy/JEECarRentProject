package com.carent.entity;

public class WebUser {
    private String id;
    private String userName;
    private String password;
    private int rentedCarNum;

    public int getRentedCarNum() {
        return rentedCarNum;
    }

    public void setRentedCarNum(int rentedCarNum) {
        this.rentedCarNum = rentedCarNum;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
