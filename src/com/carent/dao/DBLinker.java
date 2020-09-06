package com.carent.dao;

// JDBC Java Database connectivity

import com.carent.entity.Car;
import com.carent.entity.WebUser;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;
import com.carent.entity.WebUser;

public class DBLinker {
    // 在登陆时查找给定用户是否存在

    private Connection getConnection() throws SQLException {
        // 数据库用户名和密码以及url
        String user = "";
        String url = "";
        String psw = "";
        Properties pros = new Properties();
        try {
            pros.load(DBLinker.class.getClassLoader().getResourceAsStream("jdbc.properties"));
            url = pros.getProperty("url");
            user = pros.getProperty("user");
            psw = pros.getProperty("password");

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
    public Car[] getRentableCars() {

        //声明对象
        //jdbc
        //声明连接
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        ArrayList<Car>  cars= new ArrayList<>();
        try {
            //创建连接
            conn = getConnection();

            String sql = "select * from t_car   ";
            ps = conn.prepareStatement(sql);

            //发送sql获取结果集
            resultSet = ps.executeQuery();
            //处理结果

            while(resultSet.next()&&!resultSet.getString("rentedBy").equals("0")){
                int id = resultSet.getInt("id");
                String brand = resultSet.getString("brand");

                String carName = resultSet.getString("carName");

                String carNo1 = resultSet.getString("carNo");
                String type1 = resultSet.getString("type");
                BigDecimal price = resultSet.getBigDecimal("price");

                String rentedBy = resultSet.getString("rentedBy");
                //创建对象
                Car c=new Car(id,brand,carName,carNo1,type1,price,rentedBy);
                cars.add(c);
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return (Car[])cars.toArray(new Car[cars.size()]);

    }

    // 根据当前用户信息修改被租车辆信息
    public void changeRentedCarInfo(int userId, int carId) {

    }

    // 返回当前用户租用的所有车辆
    public Car[] getRentedCar(int userId) {

        //声明对象

        //jdbc
        //声明连接
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        ArrayList<Car>  cars= new ArrayList<>();
        try {
            //创建连接
             conn = getConnection();

            String sql = "select * from t_car where rentedBy = ? ";
           ps = conn.prepareStatement(sql);
            ps.setString(1, Integer.toString(userId));

            //发送sql获取结果集
            resultSet = ps.executeQuery();
            //处理结果

            while(resultSet.next()){
               int id = resultSet.getInt("id");
                String brand = resultSet.getString("brand");

                String carName = resultSet.getString("carName");

                String carNo1 = resultSet.getString("carNo");
                String type1 = resultSet.getString("type");
                BigDecimal price = resultSet.getBigDecimal("price");
                String rentedBy = resultSet.getString("rentedBy");
                //创建对象
                Car c=new Car(id,brand,carName,carNo1,type1,price,rentedBy);
                cars.add(c);
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return (Car[])cars.toArray(new Car[cars.size()]);
    }

    // 根据当前用户信息修改被还车辆信息
    public void changeReturnedCarInfo() {

    }

    // 返回数据库中所有车辆
    public Car[] getAllCar() {
        //声明对象
        //jdbc
        //声明连接
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        ArrayList<Car>  cars= new ArrayList<>();
        try {
            //创建连接
            conn = getConnection();

            String sql = "select * from t_car  ";
            ps = conn.prepareStatement(sql);

            //发送sql获取结果集
            resultSet = ps.executeQuery();
            //处理结果

            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String brand = resultSet.getString("brand");

                String carName = resultSet.getString("carName");

                String carNo1 = resultSet.getString("carNo");
                String type1 = resultSet.getString("type");
                BigDecimal price = resultSet.getBigDecimal("price");
                String rentedBy = resultSet.getString("rentedBy");
                //创建对象
                Car c=new Car(id,brand,carName,carNo1,type1,price,rentedBy);
                cars.add(c);
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return (Car[])cars.toArray(new Car[cars.size()]);
    }

    // 返回所有用户信息
    public WebUser [] getAllUser() {
        //声明对象
        //jdbc
        //声明连接
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        ArrayList<WebUser>  webuser= new ArrayList<>();
        try {
            //创建连接
            conn = getConnection();

            String sql = "select * from t_webuser     ";
            ps = conn.prepareStatement(sql);

            //发送sql获取结果集
            resultSet = ps.executeQuery();
            //处理结果

            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String userName = resultSet.getString("userName");
                String password = resultSet.getString("password");
                int rentedCarNum = resultSet.getInt("rentedCarNum");
                //创建对象
                WebUser w=new WebUser(id,userName,password ,rentedCarNum);

                webuser.add(w);
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return (WebUser [])webuser.toArray(new WebUser[webuser.size()]);
    }

    // 返回管理员所查看用户租用的所有车辆
    public void getUserRentedCar() {

    }

}
