<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 9/3/2020
  Time: 7:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="login.css" type="text/css" rel="stylesheet">
    <title>登录</title>

    <link href="login.css" type="text/css" rel="stylesheet"/>
</head>
<body>
<div class="div1"><img class="img1" src="../picture/rentCar.png"></div>
<div class="div3">
    <%
        String errorMsg = (String) request.getAttribute("errorMsg");
        if (errorMsg != null) {
            out.println("<h3>" + errorMsg + "</h3>");
        }
    %>
</div>
<div class="div2">
<form action="JEEServlet" method="post">
    <input type="hidden" name="operation" value="login">
    <p>用户名：<input type="text" name="userName"></p>
    <p>密&nbsp;&nbsp;&nbsp;码：<input type="password" name="password"></p>
    <button class="btn" type="submit" name="register">登录</button>
    <p><a href="../register.jsp">创建账户</a></p>
    </form>
</div>>
</body>
</html>
