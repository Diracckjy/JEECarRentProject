package com.carent.dao;


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//封装jdbc
import java.sql.Statement;
import java.util.Properties;


public class BjsxtJdbc {

    //提取参信息--方便以后进行封装
    private static String driver = "";
    private static String url = "";
    private static String username = "";
    private static String userpwd = "";

    //加载类的时候自动执行--静态代码块
    static {
        //通过流的方式来解析配置文件的内容
        //创建properties对象
        Properties properties = new Properties();
        try {
            //用properties对象读取配置文件
            properties.load(BjsxtJdbc.class.getClassLoader().getResourceAsStream("Bjsxtjdbc.properties"));
            //获取配置参数信息
            String jdbcname = properties.getProperty("jdbcname");
            driver = properties.getProperty(jdbcname + "driver");
            url = properties.getProperty(jdbcname + "url");
            username = properties.getProperty(jdbcname + "username");
            userpwd = properties.getProperty(jdbcname + "userpwd");
            System.out.println("BjsxtJdbc.enclosing_method():" + "[driver]" + driver + "[url]" + url + "[username]" + username + "[userpwd]" + userpwd);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    //创建连接
    public static Connection getConnection() {
        //声明连接
        Connection connection = null;
        try {
            //加载驱动
            Class.forName(driver);
            //创建连接
            connection = DriverManager.getConnection(url, username, userpwd);
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("BjsxtJdbc.getConnection(请检查连接参数)：" + "[url]:" + url + " [username]:" + username + " [userpwd]:" + userpwd);
            e.printStackTrace();
        }
        return connection;
    }

    //创建sql命令发生器preparedStatement
    public static PreparedStatement getPreparedStatement(Connection connection, CharSequence sql) {
        //声明sql命令发送器对象
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql.toString());
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return preparedStatement;
    }

    //创建statement命令发生器
    public static Statement getStatement(Connection connection) {
        //声明sql命令发送器对象
        Statement statement = null;
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return statement;
    }

    //关闭资源连接 connection,statement,resultset
    public static void closeAll(ResultSet resultSet, Statement statement, Connection connection) {
        //后开的先关， 判断是否为空
        try {
            if (resultSet != null) {
                resultSet.close();
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        try {
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }


    //封装DML语句
    public static int excuteDML(CharSequence sql, Object... objs) {
        //声明一个变量
        int n = 0;
        //声明连接
        Connection connection = null;
        //声明sql命令发送器
        PreparedStatement preparedStatement = null;
        try {
            //创建连接
            connection = getConnection();
            preparedStatement = getPreparedStatement(connection, sql.toString());
            //赋值
            for (int i = 0; i < objs.length; i++) {
                preparedStatement.setObject(i + 1, objs[i]);
            }
            //发送sql
            n = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            //关闭连接
            closeAll(null, preparedStatement, connection);
        }
        return n;
    }
}























