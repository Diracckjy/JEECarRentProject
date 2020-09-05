package com.carent.dao;

// JDBC Java Database connectivity

import com.carent.entity.WebUser;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.*;
import java.util.Properties;

public class DBLinker {
    // 在登陆时查找给定用户是否存在
    public WebUser findUserInfo(String userName, String password) {
        //声明对象
        WebUser webUser = null;
        //jdbc
        //声明连接
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            //创建连接
          //  connection = BjsxtJdbc.getConnection();



            InputStream is=DBLinker.class.getClassLoader().getResourceAsStream("jdbc.properties");
            Properties pros=new Properties();
            pros.load(is);
            String user = pros.getProperty("user");
            String password1 = pros.getProperty("password");
            String url = pros.getProperty("url");
            String driverClass = pros.getProperty("driverClass");
            Class.forName(driverClass);
            connection=DriverManager.getConnection(url,user,password1);

            String sql = "select * from t_WebUser where name = ? and pwd = ? ";
       //     ps = BjsxtJdbc.getPreparedStatement(connection, sql);
            ps=connection.prepareStatement(sql);
            ps.setString(1, userName);
            ps.setString(2, password);
            //发送sql获取结果集
            resultSet = ps.executeQuery();
            //处理结果
            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                String uname = resultSet.getString("userName");
                String upwd = resultSet.getString("password");
               int rentedCarNum = resultSet.getInt("rentedCarNum");

                //创建对象
                //   WebUser = new WebUser(id, uname, upwd,  clazz);
                webUser = new WebUser(id ,uname,upwd,rentedCarNum);

            }

        } catch (SQLException | IOException | ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            BjsxtJdbc.closeAll(resultSet, ps, connection);
        }


        return webUser;
    }

    // 在注册时存储用户信息
    public void storeUserInfo(String userName, String password) {
            //sql
//            String sql = "insert into t_student(id,userName,password,rentedCarNum) values( ?,?,?,?) ";
//        WebUser w=new WebUser();
//        w.setUserName(userName);
//        w.setPassword(password);
//            //数组
//            Object[] objs = {w.getId(),w.getUserName(),w.getPassword(),w.getRentedCarNum()};
//            return BjsxtJdbc.excuteDML(sql, objs);

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
//
//    public class WebUserDaoImpl implements UserDao {
//
//        //登陆
//        @Override
//        public WebUser WebUserloginDao(String name, String pwd) {
//            //声明对象
//            WebUser WebUser = null;
//            //jdbc
//            //声明连接
//            Connection connection = null;
//            PreparedStatement ps = null;
//            ResultSet resultSet = null;
//            try {
//                //创建连接
//                connection = BjsxtJdbc.getConnection();
//                String sql = "select * from t_WebUser where name = ? and pwd = ? ";
//                ps = BjsxtJdbc.getPreparedStatement(connection, sql);
//                ps.setString(1, name);
//                ps.setString(2, pwd);
//                //发送sql获取结果集
//                resultSet = ps.executeQuery();
//                //处理结果
//                if (resultSet.next()) {
//                    String id = resultSet.getString("id");
//                    String uname = resultSet.getString("name");
//                    String upwd = resultSet.getString("pwd");
//                    int age = resultSet.getInt("age");
//                    int sex = resultSet.getInt("sex");
//                    Date enterdate = resultSet.getDate("enterdate");
//                    String clazz = resultSet.getString("clazz");
//                    //创建对象
//                    // WebUser = new WebUser(id, uname, upwd, age, sex, enterdate, clazz);
//                }
//
//            } catch (SQLException e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//            } finally {
//                BjsxtJdbc.closeAll(resultSet, ps, connection);
//            }
//
//
//            return WebUser;
//        }

//        //查询所有学生信息
//        @Override
//        public void WebUserListDao(SxtPageUtil<WebUser> sxtPageUtil) {
//            //声明对象
//            List<WebUser> WebUserList = new ArrayList<>();
//            //jdbc
//            //声明连接
//            Connection connection = null;
//            PreparedStatement ps = null;
//            ResultSet resultSet = null;
//            try {
//                //创建连接
//                connection = BjsxtJdbc.getConnection();
//                StringBuilder sql = new StringBuilder("select * from t_WebUser where 1=1 ");
//                sql.append(" limit "+ sxtPageUtil.getStart() +","+ sxtPageUtil.getSize());
//                ps = BjsxtJdbc.getPreparedStatement(connection, sql);
//                //发送sql获取结果集
//                resultSet = ps.executeQuery();
//                //处理结果
//                while(resultSet.next()){
//                    String id = resultSet.getString("id");
//                    String uname = resultSet.getString("name");
//                    String upwd = resultSet.getString("pwd");
//                    int age = resultSet.getInt("age");
//                    int sex = resultSet.getInt("sex");
//                    Date enterdate = resultSet.getDate("enterdate");
//                    String clazz = resultSet.getString("clazz");
//                    //创建对象
//                    WebUser WebUser = new WebUser(id, uname, upwd, age, sex, enterdate, clazz);
//                    //把对象存放到集合中
//                    WebUserList.add(WebUser);
//                }
//
//            } catch (SQLException e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//            }finally{
//                BjsxtJdbc.closeAll(resultSet, ps, connection);
//            }
//
//            sxtPageUtil.setList(WebUserList);
//            //return WebUserList;
//        }
//
//        //查询所有班级信息
//        @Override
//        public List<Clazz> clazzListDao() {
//            //声明对象
//            List<Clazz> clazzList = new ArrayList<>();
//            //jdbc
//            //声明连接
//            Connection connection = null;
//            PreparedStatement ps = null;
//            ResultSet resultSet = null;
//            try {
//                //创建连接
//                connection = BjsxtJdbc.getConnection();
//                String sql = "select * from t_class  ";
//                ps = BjsxtJdbc.getPreparedStatement(connection, sql);
//                //发送sql获取结果集
//                resultSet = ps.executeQuery();
//                //处理结果
//                while(resultSet.next()){
//                    String id = resultSet.getString("id");
//                    String uname = resultSet.getString("name");
//                    //创建对象
//                    Clazz clazz = new Clazz(id, uname);
//                    //把对象存放到集合中
//                    clazzList.add(clazz);
//                }
//
//            } catch (SQLException e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//            }finally{
//                BjsxtJdbc.closeAll(resultSet, ps, connection);
//            }
//            return clazzList;
//        }
//
//        @Override
//        public WebUser userloginDao(String name, String pwd) {
//            return null;
//        }
//
//        //删除学生信息
//        @Override
//        public int deleteWebUserDao(String WebUserid) {
//            //sql
//            String sql = "delete from t_WebUser where id = ? ";
//            //数组
//            Object[] objs = {WebUserid};
//            return BjsxtJdbc.excuteDML(sql, objs);
//        }
//
//        //批量删除学生信息
//        @Override
//        public int deleteWebUsersDao(String WebUserids) {
//
//            //数组
//            String newWebUserids = WebUserids.substring(0, WebUserids.length()-1);
//            Object[] objs = newWebUserids.split(",");
//
//            //sql
//            StringBuilder sql = new StringBuilder("delete from t_WebUser where id in (  " ) ;
//            //拼接数组
//            for (int i = 0; i < objs.length; i++) {
//                if(i==objs.length-1){
//                    sql.append(" ? )" );
//                }else{
//                    sql.append(" ? , " );
//                }
//            }
//
//            System.out.println("WebUserDaoImpl.deleteWebUsersDao(sql):"+sql);
//
//            return BjsxtJdbc.excuteDML(sql, objs);
//        }
//
//        //添加学生信息
//        @Override
//        public int addWebUserDao(WebUser s) {
//            //sql
//            String sql = "insert into t_WebUser(id,name,pwd,age,sex,enterdate,clazz) values( ?,?,?,?,?,?,? ) ";
//
//            //数组
//            Object[] objs = {s.getId(),s.getName(),s.getPwd(),s.getAge(),s.getSex(),s.getEnterdate(),s.getClazz()};
//            return BjsxtJdbc.excuteDML(sql, objs);
//        }
//
//        //查询单个学生的信息--根据id查询
//        @Override
//        public WebUser searchWebUserDao(String WebUserid) {
//            //声明对象
//            WebUser WebUser = null;
//            //jdbc
//            //声明连接
//            Connection connection = null;
//            PreparedStatement ps = null;
//            ResultSet resultSet = null;
//            try {
//                //创建连接
//                connection = BjsxtJdbc.getConnection();
//                String sql = "select * from t_WebUser where id = ? ";
//                ps = BjsxtJdbc.getPreparedStatement(connection, sql);
//                ps.setString(1, WebUserid);
//
//                //发送sql获取结果集
//                resultSet = ps.executeQuery();
//                //处理结果
//                if(resultSet.next()){
//                    String id = resultSet.getString("id");
//                    String uname = resultSet.getString("name");
//                    String upwd = resultSet.getString("pwd");
//                    int age = resultSet.getInt("age");
//                    int sex = resultSet.getInt("sex");
//                    Date enterdate = resultSet.getDate("enterdate");
//                    String clazz = resultSet.getString("clazz");
//                    //创建对象
//                    WebUser = new WebUser(id, uname, upwd, age, sex, enterdate, clazz);
//                }
//
//            } catch (SQLException e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//            }finally{
//                BjsxtJdbc.closeAll(resultSet, ps, connection);
//            }
//
//            return WebUser;
//
//        }
//
//        //修改学生信息
//        @Override
//        public int updateWebUserDao(WebUser s) {
//            //sql
//            String sql = "update t_WebUser set name = ? ,pwd = ? ,age = ?,sex = ?,enterdate = ?,clazz = ? where id = ? ";
//            //数组
//            Object[] objs = {s.getName(),s.getPwd(),s.getAge(),s.getSex(),s.getEnterdate(),s.getClazz(),s.getId()};
//
//            return BjsxtJdbc.excuteDML(sql, objs);
//        }
//
//        //模糊查询
//        @Override
//        public List<WebUser> WebUserListDaoLike(String name, String clazz) {
//            //声明对象
//            List<WebUser> WebUserList = new ArrayList<>();
//            //jdbc
//            //声明连接
//            Connection connection = null;
//            PreparedStatement ps = null;
//            ResultSet resultSet = null;
//            try {
//                //创建连接
//                connection = BjsxtJdbc.getConnection();
//                //sql
//                StringBuilder sql =  new StringBuilder("select * from t_WebUser where 1 = 1 ") ;
//                //判断传入的参数是否为空
//                if((name!=null&&!"".equals(name))&&(clazz!=null&&!"".equals(clazz))){
//                    sql.append(" and name like ? and clazz like ? ");
//                    ps = BjsxtJdbc.getPreparedStatement(connection, sql);
//                    ps.setString(1, "%"+name+"%");
//                    ps.setString(2, "%"+clazz+"%");
//
//                }else if((name!=null&&!"".equals(name))&&(clazz==null||"".equals(clazz))){
//                    sql.append(" and name like ?  ");
//                    ps = BjsxtJdbc.getPreparedStatement(connection, sql);
//                    ps.setString(1, "%"+name+"%");
//                }else if((name==null||"".equals(name))&&(clazz!=null&&!"".equals(clazz))){
//                    sql.append(" and clazz like ?  ");
//                    ps = BjsxtJdbc.getPreparedStatement(connection, sql);
//                    ps.setString(1, "%"+clazz+"%");
//                }else{
//                    ps = BjsxtJdbc.getPreparedStatement(connection, sql);
//                }
//                //发送sql获取结果集
//                resultSet = ps.executeQuery();
//                //处理结果
//                while(resultSet.next()){
//                    String id = resultSet.getString("id");
//                    String uname = resultSet.getString("name");
//                    String upwd = resultSet.getString("pwd");
//                    int age = resultSet.getInt("age");
//                    int sex = resultSet.getInt("sex");
//                    Date enterdate = resultSet.getDate("enterdate");
//                    String clazz2 = resultSet.getString("clazz");
//                    //创建对象
//                    WebUser WebUser = new WebUser(id, uname, upwd, age, sex, enterdate, clazz2);
//                    //把对象存放到集合中
//                    WebUserList.add(WebUser);
//                }
//
//            } catch (SQLException e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//            }finally{
//                BjsxtJdbc.closeAll(resultSet, ps, connection);
//            }
//            return WebUserList;
//
//        }
//
//        //查询总记录数
//        @Override
//        public int selectCountDao() {
//            //声明一个变量
//            int total = 0;
//            //jdbc
//            //声明连接
//            Connection connection = null;
//            PreparedStatement ps = null;
//            ResultSet resultSet = null;
//            try {
//                //创建连接
//                connection = BjsxtJdbc.getConnection();
//                String sql = "select count(*) from t_WebUser ";
//                ps = BjsxtJdbc.getPreparedStatement(connection, sql);
//                //发送sql获取结果集
//                resultSet = ps.executeQuery();
//                //处理结果
//                if(resultSet.next()){
//                    total = resultSet.getInt(1);
//                }
//
//            } catch (SQLException e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//            }finally{
//                BjsxtJdbc.closeAll(resultSet, ps, connection);
//            }
//            return total;
//        }
//
//    }


}
