package com.carent.servlet;

import com.carent.service.JEEService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class JEEServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    // 登录成功后重定向页面到主页
    public int userLogin(HttpServletRequest req, HttpServletResponse resp,
                         String userName, String password){
        int userId = -1;

        JEEService jes = new JEEService();

        userId = jes.LoginService(userName, password);

        return userId;
    }

    // 注册成功后重定向到登录页
    public int userRegister(HttpServletRequest req, HttpServletResponse resp,
                            String userName, String password){
        int registerOK = 1;

        JEEService jes = new JEEService();

        registerOK = jes.RegisterService(userName, password);

        return registerOK;
    }
}
