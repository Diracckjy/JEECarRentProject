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
<%--    <script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>--%>
<%--    <script type="text/javascript">--%>
<%--        console.log("哈哈哈")--%>
<%--        $(function () {--%>
<%--            $(".btn").click--%>
<%--            {--%>
<%--                console.log("哈哈");--%>
<%--            }--%>
<%--        })--%>
<%--    </script>--%>
</head>
<body>
<form action="JEEServlet" method="post">
    <input type="hidden" name="operation" value="login">
    <p>用户名：<input type="text" name="userName"></p>
    <p>密码：<input type="password" name="password"></p>
    <button class="btn" type="submit" name="register">登录</button>
    <p><a href="register.jsp">创建账户</a></p>
</form>
</body>
</html>
