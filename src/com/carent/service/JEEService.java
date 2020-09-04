package com.carent.service;

import com.carent.doa.DBLinker;

// 业务处理类
public class JEEService {
    // 在数据库中查询用户数据是否存在, 不存在时返回-1
    public int LoginService(String userName, String password){
        int userId = -1;
        DBLinker db = new DBLinker();

        userId = db.findUserInfo(userName, password);

        return userId;
    }

    // 将用户名、密码存入数据库
    public int RegisterService(String userName, String password){
        int storeSuccess = 1;  // 存储是否成功

        DBLinker db = new DBLinker();

        storeSuccess = db.storeUserInfo(userName, password);

        return storeSuccess;
    }
}
