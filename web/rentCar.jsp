<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 9/4/2020
  Time: 10:31 AM
  To change this template use File | Settings | File Templates.
--%>

<%--
  rentCar.jsp:租车页面
  功能：租车, 跳转还车页面
  用户登录后由LoginServlet重定向至此
  需要rentableCars属性显示可租车辆
  租车：根据租户id和被租车辆id存入数据库
--%>

<%@ page import="com.carent.entity.Car" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>租车</title>
    <link href="css/rentCar.css" rel="stylesheet" type="text/css"/>
    <link href="css/rentCar2.css" rel="stylesheet" type="text/css"/>
    <link href="css/footer.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="top-Bar">
    <div class="container clearfix">
        <div class="topbar-nav">
            <form style="float:left" action="JEEServlet" method="post">
                <input type="hidden" name="userId" value="<%out.print(request.getAttribute("userId"));%>">
                <button type="submit"
                        name="operation" value="gotoReturnCar">
                    <span class="iconfont">去还车&#xe619;</span></button>
                <a href="login.jsp">退出登录</a>
            </form>
            <%--            --%>
            <div class="topbar-info">
                <span class="iconfont">&#xe604;</span>
                <span class="sep">|</span>
                <a href="#"><%out.print((String) request.getAttribute("currentName"));%></a>
            </div>
        </div>
        <div style="width:100%;height: 50px;">
        </div>

        <form action="JEEServlet" method="post">
            <!-- 提交表单时传值 -->
            <input type="hidden" name="operation" value="rentCar">
            <%-- 确定用户登录id --%>
            <input type="hidden" name="userId" value="<%out.print(request.getAttribute("userId"));%>">
            <table class="container">
                <thead>
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
                </thead>
                <tbody>
                <%
                    Car[] rentableCars = (Car[]) request.getAttribute("rentableCars");
                    for (Car car : rentableCars
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
                                + car.getId() + ">租车</button></td>");
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
