package com.carent.dao;

// JDBC Java Database connectivity

import com.carent.entity.WebUser;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.*;
import java.util.Properties;

public class DBLinker {
    // 在登陆时查找给定用户是否存在

    private Connection getConnection() throws SQLException {
        // 数据库用户名和密码以及url
        String user = "";
        String url = "";
        String psw = "";
        Properties pros = new Properties();
        try {
            pros.load(DBLinker.class.getClassLoader().getResourceAsStream("jdbc.propertoes"));
            url = pros.getProperty("url");
            user = pros.getProperty("user");
            psw = pros.getProperty("psw");

            Class.forName(pros.getProperty("driverClass"));
        } catch (ClassNotFoundException | IOException ex) {
            ex.printStackTrace();
        }

        return DriverManager.getConnection(url, user, psw);
    }

    public WebUser findUserInfo(String userName, String password) {
        //声明对象
        WebUser webUser = null;
        //jdbc
        //声明连接

        try {
            Connection conn = getConnection();

            String sql = "select * from t_WebUser where userName = ? and password = ? ";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, userName);
            ps.setString(2, password);
            //发送sql获取结果集
            ResultSet resultSet = ps.executeQuery();
            //处理结果
            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                String uname = resultSet.getString("userName");
                String upwd = resultSet.getString("password");
                int rentedCarNum = resultSet.getInt("rentedCarNum");

                //创建对象
                webUser = new WebUser(id, uname, upwd, rentedCarNum);

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return webUser;
    }

    // 在注册时存储用户信息
    public void storeUserInfo(String userName, String password) {

        try {
            Connection connection = getConnection();
            String sql = "insert into t_WebUser(userName,password,rentedCarNum) values( ?,?,?) ";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, userName);
            ps.setString(2, password);
            ps.setInt(3, 0);
            ps.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    // 从数据库查询并返回所有可租车辆
    public void getRentableCars() {

    }

    // 根据当前用户信息修改被租车辆信息
    public void changeRentedCarInfo() {

    }

    // 返回当前用户租用的所有车辆
    public void getRentedCar() {

    }

    // 根据当前用户信息修改被还车辆信息
    public void changeReturnedCarInfo() {

    }

    // 返回数据库中所有车辆
    public void getAllCar() {

    }

    // 返回所有用户信息
    public void getAllUser() {

    }

    // 返回管理员所查看用户租用的所有车辆
    public void getUserRentedCar() {

    }

}
