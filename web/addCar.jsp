<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 9/6/2020
  Time: 8:37 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加车辆</title>
    <link href="css/form.css" rel="stylesheet" type="text/css">

</head>
<body>
<%
    String opMsg = (String)request.getAttribute("opMsg");
    if(opMsg != null && opMsg.equals("addSuccess")){
        out.println("<p>添加成功</p>");
    }

%>
<div class="header">
    <form action="JEEServlet" method="post">
        <p><button type="submit"
                   name="operation" value="gotoAdmin">返回</button></p>
    </form>
</div>

<div class="container">
    <form action="JEEServlet" method="post">
        <input type="hidden" name="operation" value="addCar" required>

        <label for="brand">车辆品牌</label>
        <input id="brand" type="text" name="brand" required>

        <label for="carName">车辆名称</label>
        <input id="carName" type="text" name="carName" required>

        <label for="carNo">车牌号</label>
        <input id="carNo" type="text" name="carNo" required>

        <label for="type">类型</label>
        <input id="type" type="text" name="type" required>

        <label for="price">租金</label>
        <input id="price" type="text" name="price" required>

        <input type="submit" value="确认添加">
    </form>
</div>

</body>
</html>
