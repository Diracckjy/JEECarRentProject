<%@ page import="com.carent.entity.Car" %><%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 9/6/2020
  Time: 8:57 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改车辆</title>
    <link href="css/form.css" rel="stylesheet" type="text/css">
</head>
<body>
<form action="JEEServlet" method="post">
    <p><button type="submit"
               name="operation" value="gotoAdmin">返回</button></p>
</form>

<form action="JEEServlet" method="post">
    <%
        Car car = (Car)request.getAttribute("car");
    %>
    <input type="hidden" name="operation" value="modifyCar">
    <input type="hidden" name="carId" value="<%out.print(car.getId());%>">
    <input type="hidden" name="rentedBy" value="<%out.print(car.getRentedBy());%>">
    <p>车辆品牌<input type="text" name="brand"
                  value="<%out.print(car.getBrand());%>"></p>
    <p>车辆名称<input type="text" name="carName"
                  value="<%out.print(car.getCarName());%>"></p>
    <p>车牌号<input type="text" name="carNo"
                 value="<%out.print(car.getCarNo());%>"></p>
    <p>类型<input type="text" name="type"
                value="<%out.print(car.getType());%>"></p>
    <p>租金<input type="text" name="price"
                value="<%out.print(car.getPrice());%>"></p>
    <button type="submit">确认修改</button>
</form>
</body>
</html>
