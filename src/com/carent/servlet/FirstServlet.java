package com.carent.servlet;

import sun.net.httpserver.HttpServerImpl;

import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

    public class FirstServlet extends HttpServlet {
        @Override
        public void init() throws ServletException {
            System.out.println("开始建成");
        }

        /**response：服务器响应，服务器响应给浏览器的数据
         * request:浏览器的请求，存放了浏览器发送到服务器的数据
         */
        int count=100;
        public void service(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException {
            //0.告诉浏览器响应内容类型
            count--;
            resp.setContentType("text/html;charset=UTF-8");
            //1 获得当前系统时间
            Date date = new Date();
            //2将时间发送给浏览器
            String name=req.getParameter("username");
            System.out.println(name);
            //通过resp获得响应的输出流(server->>brower)
            PrintWriter pw = resp.getWriter();
            synchronized (this) {
                if(count>0){
                    count--;
                }
            }

            pw.print("剩余票的个数为" + count);//字符输出流：将date的字符串形式发送给浏览器
            pw.flush();//不需要自动断开连接，协议会自己断掉
        }

        @Override
        public void destroy() {
            System.out.println("开始销毁");
        }
    }


