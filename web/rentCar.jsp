<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 9/4/2020
  Time: 10:31 AM
  To change this template use File | Settings | File Templates.
--%>

<%--
  rentCar.jsp:租车页面
  功能：租车, 跳珠到还车页面
  用户登录后由LoginServlet重定向至此
  需要rentableCars属性显示可租车辆
--%>

<%@ page import="com.carent.entity.Car"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>租车页面</title>
</head>
<body>
<div class="userMenu">
    <p><a href="#">租车</a></p>
</div>
    <div class="rentedCarTable">
        <p>可租车辆</p>
        <table>
            <tr class="title">
                <th>编号</th>
                <th>名称</th>
                <th>备注</th>
                <th>品牌</th>
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
                <td><a href="#">租车</a></td>
            </tr>
            <%
                Car[] rentableCars = (Car[])request.getAttribute("rentableCars");
                for (Car car : rentableCars
                        ) {
                    out.println("<tr>");
                    out.println("<td>"+ car.getId() + "</td>");
                    out.println("<td>"+ car.getCarName() + "</td>");
                    out.println("<td>"+ car.getRemarks() + "</td>");
                    out.println("<td>"+ car.getBrand() + "</td>");
                    out.println("<td>"+ car.getPrice() + "</td>");
                    out.println("<td><a href=\"#\">租车</a></td>");
                    out.println("<tr>");
                }
            %>
    </table>
    </div>
</body>
</html>
