package com.carent.entity;

public class WebUser {
    private int id;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public WebUser()
    {

    }

    public WebUser(int id, String userName, String password, int rentedCarNum) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.rentedCarNum = rentedCarNum;
    }
}
