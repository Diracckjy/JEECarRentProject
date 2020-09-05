package com.carent.dao;
import java.util.List;
import com.carent.entity.WebUser;

public interface UserDao {
    //查询所有班级信息
    //List<Clazz> clazzListDao();

    //登陆
    WebUser userloginDao(String name, String pwd);

    //查询所有学生信息
    //List<WebUser> WebUserListDao(int num,int size);
  //  void WebUserListDao(SxtPageUtil<WebUser> sxtPageUtil);

    //查询所有班级信息
   // List<Clazz> clazzListDao();

    //删除学生信息
    int deleteWebUserDao(String WebUserid);

    //批量删除学生信息
    int deleteWebUsersDao(String WebUserids);

    //添加学生信息
    int addWebUserDao(WebUser WebUser);

    //查询单个学生的信息--根据id查询
    WebUser searchWebUserDao(String WebUserid);

    //修改学生信息
    int updateWebUserDao(WebUser WebUser);

    //模糊查询
    List<WebUser> WebUserListDaoLike(String name,String calzz);

    //查询总记录数
    int selectCountDao();
}

