<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 9/7/2020
  Time: 9:24 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Slide Login Form Flat Responsive Widget Template :: w3layouts</title>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="keywords" content="Slide Login Form template Responsive, Login form web template, Flat Pricing tables, Flat Drop downs Sign up Web Templates, Flat Web Templates, Login sign up Responsive web template, SmartPhone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />

    <script>
        addEventListener("load", function () {
            setTimeout(hideURLbar, 0);
        }, false);

        function hideURLbar() {
            window.scrollTo(0, 1);
        }
    </script>

    <!-- Custom Theme files -->
    <link href="css/login_register_style.css" rel="stylesheet" type="text/css" media="all" />
    <link href="css/font-awesome.min.css" rel="stylesheet" type="text/css" media="all" />
    <!-- //Custom Theme files -->

    <!-- web font -->
    <link href="//fonts.googleapis.com/css?family=Hind:300,400,500,600,700" rel="stylesheet">
    <!-- //web font -->

</head>
<body>
<div class="div3">
    <%
        String errorMsg = (String) request.getAttribute("errorMsg");
        if (errorMsg != null) {
            out.println("<h3>" + errorMsg + "</h3>");
        }
    %>
</div>
<!-- main -->
<div class="w3layouts-main">
    <div class="bg-layer">
        <h1>Slide Login form</h1>
        <div class="header-main">
            <div class="main-icon">
                <span class="fa fa-eercast"></span>
            </div>
            <div class="header-left-bottom">
                <form action="JEEServlet" method="post">
                    <input type="hidden" name="operation" value="login">
                    <div class="icon1">
                        <span class="fa fa-user"></span>
                        <input type="email" placeholder="Email Address" required=""
                               name="userName"/>
                    </div>
                    <div class="icon1">
                        <span class="fa fa-lock"></span>
                        <input type="password" placeholder="Password" required=""
                               name="password"/>
                    </div>
                    <div class="login-check">
                        <label class="checkbox"><input type="checkbox" name="checkbox" checked=""><i> </i> Keep me logged in</label>
                    </div>
                    <div class="bottom">
                        <button class="btn" type="submit">Log In</button>
                    </div>
                    <div class="links">
                        <p><a href="#">Forgot Password?</a></p>
                        <p class="right"><a href="register.jsp">New User? Register</a></p>
                        <div class="clear"></div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<!-- //main -->

</body>
</html>