<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 9/3/2020
  Time: 7:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="com.carent.entity.Car" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>还车</title>
    <link href="css/rentCar.css" rel="stylesheet" type="text/css"/>
    <link href="css/rentCar2.css" rel="stylesheet" type="text/css"/>
    <link href="css/footer.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="top-Bar">
    <div class="container clearfix">
        <div class="topbar-nav">
            <form action="JEEServlet" method="post">
                <input type="hidden" name="userId" value="<%out.print(request.getAttribute("userId"));%>">
                <button type="submit"
                        name="operation" value="gotoRentCar">
                    <span class="iconfont">租车&#xe6e8;</span>
                </button>
                <a href="login.jsp">退出登录</a>
            </form>
            <div class="topbar-info">
                <span class="iconfont">&#xe604;</span>
                <span class="sep">|</span>
                <a href="#"><%out.print((String) request.getAttribute("currentName"));%></a>
            </div>
        </div>
        <div style="width:100%;height: 50px;">
        </div>

        <form action="JEEServlet" method="post">
            <input type="hidden" name="operation" value="returnCar">
            <input type="hidden" name="userId" value="<%out.print(request.getAttribute("userId"));%>">
            <table class="container">
                <thead>
                <tr>
                    <th>
                        <h1>名称</h1></th>
                    <th>
                        <h1>备注</h1></th>
                    <th>
                        <h1>品牌</h1></th>
                    <th>
                        <h1>类型</h1></th>
                    <th>
                        <h1>价格</h1></th>
                    <th>
                        <h1><b href="#">操作</b></h1></th>
                </tr>
                </thead>
                <tbody>
                <%
                    Car[] rentedCars = (Car[]) request.getAttribute("rentedCars");
                    for (Car car : rentedCars
                    ) {
                        out.println("<tr>");
                        out.println("<td>" + car.getId() + "</td>");
                        out.println("<td>" + car.getCarName() + "</td>");
                        out.println("<td>" + car.getCarNo() + "</td>");
                        out.println("<td>" + car.getBrand() + "</td>");
                        out.println("<td>" + car.getType() + "</td>");
                        out.println("<td>" + car.getPrice() + "</td>");
                        // 通过车辆id获取信息
                        out.println("<td><button type=\"submit\" name=\"carId\" value="
                                + car.getId() + ">还车</button></td>");
                        out.println("<tr>");
                    }
                %>
                </tbody>
            </table>
        </form>
    </div>
</div>
<%@include file="footer.jsp" %>
</body>
</html>