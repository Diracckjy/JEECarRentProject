package com.carent.entity;

import java.math.BigDecimal;

public class Car {
    //编号
    private int id;
    //品牌
    private String brand;
    //名称
    private String carName;
    //车牌
    private String carNo;
    //类型
    private String type;
    //租金
    private BigDecimal price;

    // 租借用户编号
    private int rentedBy;

    public int getRentedBy() {
        return rentedBy;
    }

    public void setRentedBy(int rentedBy) {
        this.rentedBy = rentedBy;
    }

    public Car(int id, String brand, String carName, String carNo, String type, BigDecimal price, int rentedBy) {
        this.id = id;
        this.brand = brand;
        this.carName = carName;
        this.carNo = carNo;
        this.type = type;
        this.price = price;

        this.rentedBy = rentedBy;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }



    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCarNo() {
        return carNo;
    }

    public void setCarNo(String carNo) {
        this.carNo = carNo;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
