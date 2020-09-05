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
    <title>注册</title
</head>
<body>
    <form action="JEEServlet" method="post">
        <p1>用户名：<input type="text" name="userName"></p>
        <p2>密码：<input type="password" name="password"></p>
        <p3>确认密码：<input type="password" name="confirmPaw"></p>
        <button type="submit" name="register">注册</button>
        <p4><a href="login.jsp">已有账户</a></p>
    </form>
</body>
</html>
