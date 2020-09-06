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

    // 在登陆时查找给定用户是否存在
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

    public Car findCarBy(int carId){
        Car car = null;

        try {
            Connection conn = getConnection();

            String sql = "select * from t_car where id =  ? ";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, String.valueOf(carId));
            //发送sql获取结果集
            ResultSet resultSet = ps.executeQuery();
            //处理结果
            if (resultSet.next()) {
                int rentedBy = resultSet.getInt("rentedBy");
                int id = resultSet.getInt("id");
                String brand = resultSet.getString("brand");
                String carName = resultSet.getString("carName");
                String carNo1 = resultSet.getString("carNo");
                String type1 = resultSet.getString("type");
                BigDecimal price = resultSet.getBigDecimal("price");

                //创建对象
                car = new Car(id, brand, carName, carNo1, type1, price, rentedBy);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return car;
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

            while(resultSet.next()){

                int rentedBy = resultSet.getInt("rentedBy");
                int id = resultSet.getInt("id");
                String brand = resultSet.getString("brand");
                String carName = resultSet.getString("carName");
                String carNo1 = resultSet.getString("carNo");
                String type1 = resultSet.getString("type");
                BigDecimal price = resultSet.getBigDecimal("price");
                if(rentedBy == 0){
                    //创建对象
                    Car c=new Car(id,brand,carName,carNo1,type1,price,rentedBy);
                    cars.add(c);
                }

            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return (Car[])cars.toArray(new Car[cars.size()]);

    }

    public WebUser findUserInfo(String userName) {
        //声明对象
        WebUser webUser = null;
        //jdbc
        //声明连接

        try {
            Connection conn = getConnection();

            String sql = "select * from t_WebUser where userName = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, userName);
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

    public WebUser findUserInfo(int userId) {
        //声明对象
        WebUser webUser = null;
        //jdbc
        //声明连接

        try {
            Connection conn = getConnection();

            String sql = "select * from t_WebUser where id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, Integer.toString(userId));
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

    // 根据当前用户信息修改被租车辆信息
    public void changeRentedCarInfo(int userId, int carId) {
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

            String sql = " update t_car set rentedBy = ? where id= ? ";
            ps = conn.prepareStatement(sql);
            ps.setString(1, Integer.toString(userId));
            ps.setString(2, Integer.toString(carId));
            //发送sql获取结果集
            ps.executeUpdate();
            //处理结果

            String sql2 = "select * from t_WebUser where id = ?  ";
            ps = conn.prepareStatement(sql2);
            ps.setString(1, Integer.toString(userId));
             resultSet = ps.executeQuery();
            int rentedCarNum = resultSet.getInt("rentedCarNum");
            String sql1 = " update t_webuser set rentedCarNum = ? where id= ? ";
            ps = conn.prepareStatement(sql1);
            ps.setString(1, Integer.toString(rentedCarNum+1));
            ps.setString(2, Integer.toString(userId));
            //发送sql获取结果集
            ps.executeUpdate();
            //处理结果



//            while(resultSet.next()){
//                int id = resultSet.getInt("id");
//                String brand = resultSet.getString("brand");
//
//                String carName = resultSet.getString("carName");
//
//                String carNo1 = resultSet.getString("carNo");
//                String type1 = resultSet.getString("type");
//                BigDecimal price = resultSet.getBigDecimal("price");
//                String rentedBy = resultSet.getString("rentedBy");
//                //创建对象
//                Car c=new Car(id,brand,carName,carNo1,type1,price,rentedBy);
//                cars.add(c);
//            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        //return (Car[])cars.toArray(new Car[cars.size()]);
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
                int rentedBy = resultSet.getInt("rentedBy");
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

    // 根据当前用户信息修改被还车辆信息        //去还车
    public void changeReturnedCarInfo(int userId, int carId) {
        //声明对象
        //jdbc
        //声明连接
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        ArrayList<Car> cars = new ArrayList<>();
        try {
            //创建连接
            conn = getConnection();

            String sql = " update t_car set rentedBy = ? where id= ? ";
            ps = conn.prepareStatement(sql);
            ps.setString(1, Integer.toString(0));
            ps.setString(2, Integer.toString(carId));
            //发送sql获取结果集
            ps.executeUpdate();
            //处理结果

            String sql2 = "select * from t_WebUser where id = ?  ";
            ps = conn.prepareStatement(sql2);
            ps.setString(1, Integer.toString(userId));
            resultSet = ps.executeQuery();
            int rentedCarNum = resultSet.getInt("rentedCarNum");
            String sql1 = " update t_webuser set rentedCarNum = ? where id= ? ";
            ps = conn.prepareStatement(sql1);
            ps.setString(1, Integer.toString(rentedCarNum - 1));
            ps.setString(2, Integer.toString(userId));
            //发送sql获取结果集
            ps.executeUpdate();
            //处理结果


        } catch (SQLException e) {
            e.printStackTrace();
        }

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
                int rentedBy = resultSet.getInt("rentedBy");
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

       //增加车
    public  void addCar(Car car)
    {
        try {
            Connection connection = getConnection();
            String sql = "insert into t_car(id,brand,carName,carNo,type,price,rentedBy) values( default ,?,?,?,?,?,?) ";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, car.getBrand());
            ps.setString(2, car.getCarName());
            ps.setString(3, car.getCarNo());
            ps.setString(4, car.getType());
            ps.setBigDecimal(5, car.getPrice());
            ps.setInt(6, car.getRentedBy());
            ps.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }


  //删除车
    public  void deleteCar(Car car)
    {
        try {
            Connection connection = getConnection();
            String sql = "delete from t_car where id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, car.getId());
            ps.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }


    //修改车
    public void alterCar(Car car)
    {

        try {
            Connection connection = getConnection();
            String sql = "update t_car set brand=?,carName=?,carNo=?,type=?,price=?,rentedBy=?  where id= ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, car.getBrand());
            ps.setString(2,car.getCarName());
            ps.setString(3,car.getCarNo());
            ps.setString(4,car.getType());
            ps.setBigDecimal(5,car.getPrice());
            ps.setInt(6, car.getRentedBy());
            ps.setInt(7, car.getId());
            ps.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

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

}
