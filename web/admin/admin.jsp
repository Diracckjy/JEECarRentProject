<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 9/4/2020
  Time: 10:41 AM
  To change this template use File | Settings | File Templates.
--%>

<%--
  admin.jsp:管理员修改车辆页面
  功能：修改车辆信息, 添加车辆
  用户登录后由LoginServlet定向至此
  需要rentableCars属性显示可租车辆
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.carent.entity.Car"%>
<html>
<head>
    <title>管理员修改车辆页面</title>
</head>
<body>
    <p><a href="../login.jsp">登出</a></p>
    <div class="allCars">
        <p><a href="addCar.jsp">添加车辆</a></p>
    </div>
    <div>
        <form action="JEEServlet" method="post">
            <input type="hidden" name="operation" value="modifyCar">
            <table>
                <tr class="title">
                    <th>编号</th>
                    <th>名称</th>
                    <th>车牌</th>
                    <th>品牌</th>
                    <th>型号</th>
                    <th>价格</th>
                    <th>操作</th>
                </tr>
                <%-- 测试显示 --%>
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
                    Car[] cars = (Car[]) request.getAttribute("cars");
                    for (Car car : cars
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
            </table>
        </form>
    </div>


</body>
</html>
