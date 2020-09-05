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
    <title>登录</title>
</head>
<style type="text/css">
    body,form,input{ padding:0;margin:0;border: 0;}
    form{
        width:327px;
        height: 215px;
        margin:200px auto;
        padding-top: 30px;
        background-image: url(picture/carrent.jpg) no-repeat;
    }
    .content{
        width:250px;
        height: 180px;
        margin: 5px auto;

    }
    .content p{
        width:160px;
        height:19px;
        background: #fff;
        margin:10px 0 0 45px;
        padding:2px;
    }
    .content input{
        color:#757575;
        font-size: 16px;
        font-family: 微软雅黑;
    }
</style>
<body>
<form action="JEEServlet" method="post">
    <p>用户名  ：<input type="text" name="userName"></p>
    <p>密码：<input type="password" name="password"></p>
    <button type="submit" name="login">登录</button>
    <p><a href="register.jsp">创建账户</a></p>
</form>
</body>
</html>
