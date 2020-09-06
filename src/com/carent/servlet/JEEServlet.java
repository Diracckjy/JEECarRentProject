package com.carent.servlet;

import com.carent.entity.Car;
import com.carent.service.JEEService;
import com.carent.entity.WebUser;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import com.carent.entity.WebUser;

public class JEEServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        String opa = req.getParameter("operation");
        if ("login".equals(opa)) {
            userLogin(req, resp);
        } else if ("register".equals(opa)) {
            userRegister(req, resp);
        } else if ("rentCar".equals(opa)) {
            rentCar(req, resp);
        } else if("returnCar".equals(opa)){
            returnCar(req, resp);
        }else if("gotoReturnCar".equals(opa)){
            int userId = Integer.parseInt(req.getParameter("userId"));
            gotoReturnCar(req,resp, userId);
        }else if ("gotoRentCar".equals(opa)){
            int userId = Integer.parseInt(req.getParameter("userId"));
            gotoRentCar(req, resp, userId);
        }
    }

    // 登录成功后重定向页面到主页
    public void userLogin(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, ServletException {
        String name = req.getParameter("userName");
        String psw = req.getParameter("password");
        JEEService jes = new JEEService();
        WebUser webUser = jes.findUserService(name, psw);

        if (name == "admin" && psw == "admin") {
            adminLogin(req, resp);
        } else {//webUser是看是否数据库里面有这个用户，没有返回null
            if (webUser == null) {
                req.setAttribute("errorMsg", "登陆失败，用户名或密码错误。");
                req.getRequestDispatcher("/login.jsp").forward(req, resp);
            } else {
                int userId = webUser.getId();
                gotoReturnCar(req, resp, userId);

            }
        }
    }

    // 注册成功后重定向到登录页
    public void userRegister(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, ServletException {
        String userName = req.getParameter("userName");
        String password = req.getParameter("password");
        JEEService jes = new JEEService();

        if(userName == null || password == null){
            req.setAttribute("errorMsg", "注册失败，密码或用户名不能为空。");
            req.getRequestDispatcher("/register.jsp").forward(req, resp);
        } else {
            WebUser webUser = jes.findUserService(userName);
            if(webUser != null){
                req.setAttribute("errorMsg", "注册失败, 用户名重复。");
                req.getRequestDispatcher("/register.jsp").forward(req, resp);
            }else {
                jes.registerService(userName,password);
                req.getRequestDispatcher("/login.jsp").forward(req, resp);
            }
        }
    }

    public void rentCar(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, ServletException {
        int userId = Integer.parseInt(req.getParameter("userId"));
        int carId = Integer.parseInt(req.getParameter("carId"));
        JEEService jes = new JEEService();
        jes.carRentService(userId, carId);

        gotoRentCar(req, resp, userId);
    }

    public void returnCar(HttpServletRequest req, HttpServletResponse resp)
        throws IOException, ServletException{
        int userId = Integer.parseInt(req.getParameter("userId"));
        int carId = Integer.parseInt(req.getParameter("carId"));
        JEEService jes = new JEEService();
        jes.carReturnService(userId,carId);

        gotoReturnCar(req, resp, userId);
    }

    public void gotoReturnCar(HttpServletRequest req, HttpServletResponse resp, int userId)
            throws IOException, ServletException{
        Car[] listCar= new JEEService().carReturnPageService(userId);
        WebUser webuser = new JEEService().findUserService(userId);
        req.setAttribute("currentName", webuser.getUserName());
        req.setAttribute("rentedCars",listCar);
        req.setAttribute("userId", userId);
        req.getRequestDispatcher("/returnCar.jsp").forward(req,resp);
    }

    public void gotoRentCar(HttpServletRequest req, HttpServletResponse resp, int userId)
            throws IOException, ServletException{
        Car[] carlist = new JEEService().carRentPageService();
        WebUser webuser = new JEEService().findUserService(userId);
        req.setAttribute("currentName", webuser.getUserName());
        req.setAttribute("rentableCars", carlist);
        req.setAttribute("userId", userId);
        req.getRequestDispatcher("/rentCar.jsp").forward(req, resp);
    }

    public void adminLogin(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, ServletException {

        req.getRequestDispatcher("/admin.jsp").forward(req, resp);
    }
}
