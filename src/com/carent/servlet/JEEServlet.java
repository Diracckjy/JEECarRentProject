package com.carent.servlet;

import com.carent.service.JEEService;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class JEEServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        String name=req.getParameter("userName");
        String psw=req.getParameter("password");
        String opa=req.getParameter("operation");
        PrintWriter pw=resp.getWriter();
        if("login".equals(opa)){
            int flag=userLogin(req,resp,name,psw);
            if(flag==1){
                req.getRequestDispatcher("/rentCar.jsp").forward(req,resp);//向浏览器要一个页面
            }
            else{
                pw.print("登录失败，请重新登录");
            }
        }
        else if("register".equals(opa)){
            int a=userRegister(req,resp,name,psw);
            if (a==1){
                req.getRequestDispatcher("/login.jsp").forward(req,resp);
            }
            else{
                pw.print("注册失败");
            }
        }
        else if ("rentCar".equals(opa)){

        }
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