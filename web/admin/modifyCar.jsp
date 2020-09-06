<%--
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
</head>
<body>
<%
    if(request.getAttribute("addSuccess") != null){
        out.println("<p>Add success</p>");
    }
%>
<form action="JEEServlet" method="post">
    <input type="hidden" name="operation" value="addCar">
    <p>车辆品牌<input type="text" name="brand"
                  value="<%out.print(request.getAttribute("brand"));%>"></p>
    <p>车辆名称<input type="text" name="carName"
                  value="<%out.print(request.getAttribute("carName"));%>"></p>
    <p>车牌号<input type="text" name="carNo"
                 value="<%out.print(request.getAttribute("carNo"));%>"></p>
    <p>类型<input type="text" name="type"
                value="<%out.print(request.getAttribute("type"));%>"></p>
    <p>租金<input type="text" name="price"
                value="<%out.print(request.getAttribute("price"));%>"></p>
    <p>状态(不可用, 被租, 可租)<input type="text" name="status"
                             value="<%out.print(request.getAttribute("status"));%>"></p>
    <p>备注<input type="text" name="remarks"
                            value="<%out.print(request.getAttribute("remarks"));%>"></p>
    <button type="submit" value="addCar">确认修改</button>
</form>
</body>
</html>
