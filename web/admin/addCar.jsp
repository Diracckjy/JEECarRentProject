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
</head>
<body>
    <%
        if(request.getAttribute("addSuccess") != null){
            out.println("<p>Add success</p>");
        }
    %>
    <form action="JEEServlet" method="post">
        <input type="hidden" name="operation" value="addCar">
        <p>车辆品牌<input type="text" name="brand"></p>
        <p>车辆名称<input type="text" name="carName"></p>
        <p>车牌号<input type="text" name="carNo"></p>
        <p>类型<input type="text" name="type"></p>
        <p>租金<input type="text" name="price"></p>
        <p>状态(不可用, 被租, 可租)<input type="text" name="status"></p>
        <p>备注<input type="text" name="remarks"></p>
        <button type="submit" value="addCar">添加</button>
    </form>
</body>
</html>
