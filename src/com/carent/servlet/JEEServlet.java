package com.carent.servlet;

import com.carent.entity.Car;
import com.carent.service.JEEService;
import com.carent.entity.WebUser;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;

import com.carent.entity.WebUser;

public class JEEServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        req.setCharacterEncoding("utf-8");
        String op = req.getParameter("operation");
        String[] values = op.split(",");
        String opa = values[0];
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
        }else if("modifyCar".equals(opa)){
            modifyCar(req, resp);
        }else if("addCar".equals(opa)){
            addCar(req, resp);
        }else if("gotoModifyCar".equals(opa)){
            gotoModifyCar(req, resp);
        }else if("gotoAddCar".equals(opa)){
            gotoAddCar(req, resp);
        }else if("gotoAdmin".equals(opa)){
            gotoAdmin(req, resp);
        }else if("deleteCar".equals(opa)){
            deleteCar(req, resp);
        }
    }

    public void deleteCar(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, ServletException {
        resp.setContentType("text/html;charset=utf-8");
        String op = req.getParameter("operation");
        String[] values = op.split(",");
        int carId = Integer.parseInt(values[1]);
        Car car = new JEEService().findCarBy(carId);
        new JEEService().deleteCar(car);
        req.setAttribute("opMsg", "删除成功");
        gotoAdmin(req, resp);
    }

    public void gotoAdmin(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, ServletException {

        Car[] cars = new JEEService().adminPageService();
        req.setAttribute("cars", cars);
        req.getRequestDispatcher("admin.jsp").forward(req, resp);
    }

    // 登录成功后重定向页面到主页
    public void userLogin(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, ServletException {
        String name = req.getParameter("userName");
        String psw = req.getParameter("password");

        if (name.equals("admin") && psw.equals("admin")) {
            adminLogin(req, resp);
        } else {//webUser是看是否数据库里面有这个用户，没有返回null
            WebUser webUser = new JEEService().findUserService(name, psw);
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
        gotoAdmin(req, resp);
    }

    public void modifyCar(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, ServletException{
        int id = Integer.parseInt(req.getParameter("carId"));
        String brand = req.getParameter("brand");
        String carName = req.getParameter("carName");
        String carNo = req.getParameter("carNo");
        String type = req.getParameter("type");
        BigDecimal price = new BigDecimal(req.getParameter("price"));

        int rentedBy = Integer.parseInt(req.getParameter("rentedBy"));

        Car car = new Car(id,brand,carName,carNo,type,price,rentedBy);
        new JEEService().modifyCar(car);
        req.setAttribute("opMsg", "修改成功");
        adminLogin(req, resp);
    }

    public void addCar(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, ServletException{
        int id = 0;
        String brand = req.getParameter("brand");
        String carName = req.getParameter("carName");
        String carNo = req.getParameter("carNo");
        String type = req.getParameter("type");
        BigDecimal price = new BigDecimal(req.getParameter("price"));
        int rentedBy = 0;

        Car car = new Car(id,brand,carName,carNo,type,price,rentedBy);
        new JEEService().addCar(car);
        req.setAttribute("opMsg", "addSuccess");
        gotoAddCar(req, resp);
    }

    public void gotoModifyCar(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, ServletException{
        resp.setContentType("text/html;charset=utf-8");
        String op = req.getParameter("operation");
        String[] values = op.split(",");
        int carId = Integer.parseInt(values[1]);
        Car car = new JEEService().findCarBy(carId);
        req.setAttribute("car", car);
        req.getRequestDispatcher("modifyCar.jsp").forward(req, resp);
    }

    public void gotoAddCar(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, ServletException{
        req.getRequestDispatcher("addCar.jsp").forward(req, resp);
    }
}
