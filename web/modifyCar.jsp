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
<div class="header">
    <form action="JEEServlet" method="post">
        <p><button type="submit"
                   name="operation" value="gotoAdmin">返回</button></p>
    </form>
</div>

<div class="container">
    <form action="JEEServlet" method="post">
        <%
            Car car = (Car)request.getAttribute("car");
        %>
        <input type="hidden" name="operation" value="modifyCar">
        <input type="hidden" name="carId" value="<%out.print(car.getId());%>">
        <input type="hidden" name="rentedBy" value="<%out.print(car.getRentedBy());%>">

        <label for="brand">车辆品牌</label>
        <input id="brand" type="text" name="brand" required
               value="<%out.print(car.getBrand());%>">

        <label for="carName">车辆名称</label>
        <input id="carName" type="text" name="carName" required
               value="<%out.print(car.getCarName());%>">

        <label for="carNo">车牌号</label>
        <input id="carNo" type="text" name="carNo" required
               value="<%out.print(car.getCarNo());%>">

        <label for="type">类型</label>
        <input id="type" type="text" name="type" required
               value="<%out.print(car.getType());%>">

        <label for="price">租金</label>
        <input id="price" type="text" name="price" required
               value="<%out.print(car.getPrice());%>">

        <input type="submit" value="确认修改">
    </form>
</div>

</body>
</html>
