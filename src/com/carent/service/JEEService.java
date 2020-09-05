package com.carent.service;
import com.carent.dao.DBLinker;
import com.carent.entity.WebUser;

// 业务处理类
public class JEEService {
    // 在数据库中查询用户数据是否存在, 不存在时返回-1
    public WebUser loginService(String userName, String password){
        return new DBLinker().findUserInfo(userName, password);
    }

    // 将用户名、密码存入数据库
    public WebUser registerService(String userName, String password){
        WebUser webUser = new WebUser();

        return webUser;
    }

    //  打开租车页面功能，返回可租汽车数组
    public void carRentPageServie(){

    }

    // 租车功能, 根据用户数据和被租车辆数据调整数据库
    public void carRentService(){

    }

    // 打开还车页功能，返回当前用户已租车辆的数组
    public void carRenturnPageService(){

    }

    // 还车功能，根据所还车辆信息修改数据库
    public void carRenturnService(){

    }

    // 管理员主页功能，返回所有车辆信息供管理员查看
    public void adminPageService(){

    }

    // 管理员查看用户信息功能，返回所有用户供管理员查看
    public void adminViewUserService(){

    }

    // 管理员查看用户租用车辆功能，返回当前选择用户所租的所有车辆
    public void adminViewUserRentsService(){

    }
}
