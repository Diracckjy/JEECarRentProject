<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 9/4/2020
  Time: 11:14 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.carent.entity.Car"%>
<html>
<head>
    <title>查看租借车辆</title>
</head>
<body>
<p>已租车辆</p>
<table>
    <tr class="title">
        <th>编号</th>
        <th>名称</th>
        <th>备注</th>
        <th>品牌</th>
        <th>类型</th>
        <th>价格</th>
        <th>操作</th>
    </tr>
    <tr>
        <td>1</td>
        <td>朗逸</td>
        <td>自动1.6L</td>
        <td>大众2</td>
        <td>舒适型</td>
        <td>72.0/天</td>
        <td><a href="#">还车</a></td>
    </tr>
    <%
        Car[] rentedCars = (Car[])request.getAttribute("rentedCars");
        for (Car car : rentedCars
        ) {
            out.println("<tr>");
            out.println("<td>"+ car.getId() + "</td>");
            out.println("<td>"+ car.getCarName() + "</td>");
            out.println("<td>"+ car.getRemarks() + "</td>");
            out.println("<td>"+ car.getBrand() + "</td>");
            out.println("<td>"+ car.getType() + "</td>");
            out.println("<td>"+ car.getPrice() + "</td>");
            out.println("<td><a>还车</a></td>");
            out.println("<tr>");
        }
    %>
</table>
</div>
</body>
</html>
