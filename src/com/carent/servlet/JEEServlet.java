package com.carent.servlet;

import com.carent.service.JEEService;
import com.carent.entity.WebUser;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import com.carent.service.JEEService;

public class JEEServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        String name=req.getParameter("userName");
        String psw=req.getParameter("password");
        String opa=req.getParameter("operation");
        PrintWriter pw=resp.getWriter();
        if("login".equals(opa)){
            userLogin(req,resp,name,psw);
                req.getRequestDispatcher("/rentCar.jsp").forward(req,resp);//向浏览器要一个页面

        }
        else if("register".equals(opa)){
            userRegister(req,resp,name,psw);
            }

        else if ("rentCar".equals(opa)){

        }
    }

    // 登录成功后重定向页面到主页
    public void userLogin(HttpServletRequest req, HttpServletResponse resp, String userName, String password)
            throws IOException,ServletException
    {

        PrintWriter pw=resp.getWriter();
        JEEService jes = new JEEService();
        WebUser userId= jes.loginService(userName,password);
        if (userId==null){
            req.getRequestDispatcher("/login.jsp").forward(req,resp);
        }
        else{
            req.getRequestDispatcher("/returnCar.jsp").forward(req,resp);
        }

    }

    // 注册成功后重定向到登录页
    public int userRegister(HttpServletRequest req, HttpServletResponse resp,
                            String userName, String password){
        int registerOK = 1;

        JEEService jes = new JEEService();

        return registerOK;
    }


    }
