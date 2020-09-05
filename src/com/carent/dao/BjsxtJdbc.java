package com.carent.dao;


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//��װjdbc
import java.sql.Statement;
import java.util.Properties;


public class BjsxtJdbc {

    //��ȡ����Ϣ--�����Ժ���з�װ
    private static String driver = "";
    private static String url = "";
    private static String username = "";
    private static String userpwd = "";

    //�������ʱ���Զ�ִ��--��̬�����
    static {
        //ͨ�����ķ�ʽ�����������ļ�������
        //����properties����
        Properties properties = new Properties();
        try {
            //��properties�����ȡ�����ļ�
            properties.load(BjsxtJdbc.class.getClassLoader().getResourceAsStream("Bjsxtjdbc.properties"));
            //��ȡ���ò�����Ϣ
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

    //��������
    public static Connection getConnection() {
        //��������
        Connection connection = null;
        try {
            //��������
            Class.forName(driver);
            //��������
            connection = DriverManager.getConnection(url, username, userpwd);
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("BjsxtJdbc.getConnection(�������Ӳ���)��" + "[url]:" + url + " [username]:" + username + " [userpwd]:" + userpwd);
            e.printStackTrace();
        }
        return connection;
    }

    //����sql�������preparedStatement
    public static PreparedStatement getPreparedStatement(Connection connection, CharSequence sql) {
        //����sql�����������
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql.toString());
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return preparedStatement;
    }

    //����statement�������
    public static Statement getStatement(Connection connection) {
        //����sql�����������
        Statement statement = null;
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return statement;
    }

    //�ر���Դ���� connection,statement,resultset
    public static void closeAll(ResultSet resultSet, Statement statement, Connection connection) {
        //�󿪵��ȹأ� �ж��Ƿ�Ϊ��
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


    //��װDML���
    public static int excuteDML(CharSequence sql, Object... objs) {
        //����һ������
        int n = 0;
        //��������
        Connection connection = null;
        //����sql�������
        PreparedStatement preparedStatement = null;
        try {
            //��������
            connection = getConnection();
            preparedStatement = getPreparedStatement(connection, sql.toString());
            //��ֵ
            for (int i = 0; i < objs.length; i++) {
                preparedStatement.setObject(i + 1, objs[i]);
            }
            //����sql
            n = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            //�ر�����
            closeAll(null, preparedStatement, connection);
        }
        return n;
    }
}























