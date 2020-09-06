<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 9/4/2020
  Time: 10:31 AM
  To change this template use File | Settings | File Templates.
--%>

<%--
  rentCar.jsp:租车页面
  功能：租车, 跳转还车页面
  用户登录后由LoginServlet重定向至此
  需要rentableCars属性显示可租车辆
  租车：根据租户id和被租车辆id存入数据库
--%>

<%@ page import="com.carent.entity.Car" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <title>租车页面</title>
    <style type="text/css">
        body,form,input{ padding:0;margin:0;border: 0;
            background-color: rgba(105,105,101,6);
            color:#b0b0b0;
        }
        table{
            width:1500px;
            height:50px;
            border:2px solid #F00;
            text-align: center;
            margin: 0 auto;
        }
        .title{
            text-align: center;
            color:#b0b0b0;
            size:20px;
            font-family: 微软雅黑;
        }
        a:hover{
            color:#ff6700;
        }
        tr{height:50px;}
        .div1{
            width:100%;
            height: 100px;
            position: relative;
        }
        .div2{
            position:absolute;
            top:23px;
            left:1387px;
        }
        .img1{
            position: absolute;
            top:24px;
            left:627px;
            width:233px;
            height:70px
        }
        table a{
            text-decoration: none;
        }
        @font-face {
            font-family: 'iconfont';
            src: url('picture/iconfont/icon/iconfont.eot');
            src: url('picture/iconfont/icon/iconfont.eot?#iefix') format('embedded-opentype'),
            url('picture/iconfont/icon/iconfont.woff2') format('woff2'),
            url('picture/iconfont/icon/iconfont.woff') format('woff'),
            url('picture/iconfont/icon/iconfont.ttf') format('truetype'),
            url('picture/iconfont/icon/iconfont.svg#iconfont') format('svg');
        }
        .iconfont {
            font-family: "iconfont" !important;
            font-size: 43px;
            font-style: normal;
            -webkit-font-smoothing: antialiased;
            -moz-osx-font-smoothing: grayscale;
        }

    </style>
</head>
<body>

<div class="rentedCarTable">
    <h2>可租车辆</h2>
    <%--        跳转到还车页--%>
    <form action="JEEServlet" method="post">
        <p>
            <button type="submit"
                    name="gotoReturnCar" value="gotoReturnCar">
                去还车</button>
        </p>
    </form>
    <form action="JEEServlet" method="post">
        <!-- 提交表单时传值 -->
        <input type="hidden" name="operation" value="rentCar">
        <%-- 确定用户登录id --%>
        <input type="hidden" name="uerId" value="<%request.getAttribute("userId");%>">
        <table>
            <tr class="title">
                <th>编号</th>
                <th>名称</th>
                <th>车牌</th>
                <th>品牌</th>
                <th>价格</th>
                <th>操作</th>
            </tr>
            <%-- 测试显示 --%>
            <tr>
                <td>1</td>
                <td>朗逸</td>
                <td>自动1.6L</td>
                <td>大众2</td>
                <td>舒适型</td>
                <td>72.0/天</td>
                <td><a href="#">租车</a></td>
            </tr>
            <%
                Car[] rentableCars = (Car[]) request.getAttribute("rentableCars");
                for (Car car : rentableCars
                ) {
                    out.println("<tr>");
                    out.println("<td>" + car.getId() + "</td>");
                    out.println("<td>" + car.getCarName() + "</td>");
                    out.println("<td>" + car.getCarNo() + "</td>");
                    out.println("<td>" + car.getBrand() + "</td>");
                    out.println("<td>" + car.getType() + "</td>");
                    out.println("<td>" + car.getPrice() + "</td>");
                    // 通过车辆id获取信息
                    out.println("<td><button type=\"submit\" name=\"carId\" value="
                            + car.getId() + ">租车</button></td>");
                    out.println("<tr>");
                }
            %>
            <tr>
                <td>2</td>
                <td>丰田</td>
                <td>手动2L</td>
                <td>大众2</td>
                <td>舒适性</td>
                <td>50/天</td>
                <td><a href="#">租车</a></td>
            </tr>
            <tr>
                <td>3</td>
                <td>大众</td>
                <td>自动1.5L</td>
                <td>大众2</td>
                <td>舒适性</td>
                <td>50/天</td>
                <td><a href="#">租车</a></td>
            </tr>
            <tr>
                <td>4</td>
                <td>丰田</td>
                <td>手动2L</td>
                <td>大众2</td>
                <td>舒适性</td>
                <td>50/天</td>
                <td><a href="#">租车</a></td>
            </tr>
            <tr>
                <td>5</td>
                <td>丰田</td>
                <td>手动2L</td>
                <td>大众2</td>
                <td>舒适性</td>
                <td>50/天</td>
                <td><a href="#">租车</a></td>
            </tr>
            <tr>
                <td>6</td>
                <td>丰田</td>
                <td>手动2L</td>
                <td>大众2</td>
                <td>舒适性</td>
                <td>50/天</td>
                <td><a href="#">租车</a></td>
            </tr>
            <tr>
                <td>7</td>
                <td>丰田</td>
                <td>手动2L</td>
                <td>大众2</td>
                <td>舒适性</td>
                <td>50/天</td>
                <td><a href="#">租车</a></td>
            </tr>
            <tr>
                <td>8</td>
                <td>丰田</td>
                <td>手动2L</td>
                <td>大众2</td>
                <td>舒适性</td>
                <td>50/天</td>
                <td><a href="#">租车</a></td>
            </tr>

            <!-- 提交表单时传值 -->
            <input type="hidden" name="operation" value="rentCar">
            <%-- 确定用户登录id --%>
            <input type="hidden" name="uerId" value="<%request.getAttribute("userId");%>">
<%--            <%--%>
<%--                Car[] rentableCars = (Car[]) request.getAttribute("rentableCars");--%>
<%--                for (Car car : rentableCars--%>
<%--                ) {--%>
<%--                    out.println("<tr>");--%>
<%--                    out.println("<td>" + car.getId() + "</td>");--%>
<%--                    out.println("<td>" + car.getCarName() + "</td>");--%>
<%--                    out.println("<td>" + car.getRemarks() + "</td>");--%>
<%--                    out.println("<td>" + car.getBrand() + "</td>");--%>
<%--                    out.println("<td>" + car.getPrice() + "</td>");--%>
<%--                    // 通过车辆id获取信息--%>
<%--                    out.println("<td><button type=\"submit\" name=\"rent\" value="--%>
<%--                            + car.getId() + ">租车</button></td>");--%>
<%--                    out.println("<tr>");--%>
<%--                }--%>
<%--            %>--%>
        </table>
    </form>
</div>
</body>
</html>
