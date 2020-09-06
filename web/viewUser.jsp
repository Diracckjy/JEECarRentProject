<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 9/4/2020
  Time: 10:50 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.carent.entity.Car"%>
<%@page import="com.carent.entity.WebUser" %>
<html>
<head>
    <title>查看用户</title>
</head>
<body>
<div class="allCars">
    <table>
        <tr class="title">
            <th>编号</th>
            <th>用户名</th>
            <th>已租借车辆数</th>
            <th>操作</th>
        </tr>
        <tr>
            <td>1</td>
            <td>BigRed</td>
            <td>4</td>
            <td><a href="#">查看用户租借车辆</a> </td>
        </tr>
        <%
            WebUser[]  users = (WebUser[])request.getAttribute("users");
            for (WebUser user : users
            ) {
                out.println("<tr>");
                out.println("<td>"+user.getId()+"</td>");
                out.println("<td>"+user.getUserName()+"</td>");
                out.println("<td>"+user.getRentedCarNum()+"</td>");
                out.println("<td><a href=\"#\">查看租借车辆</a></td>");
                out.println("<tr>");
            }
        %>
    </table>
</div>
</body>
</html>
