<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 9/4/2020
  Time: 9:21 AM
  To change this template use File | Settings | File Templates.
--%>

<%--
  renturnCar.jsp:还车页面
  功能：还车，跳转到租车
  用户登录后由LoginServlet重定向至此
  需要rentedCars属性显示用户已租车辆
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.carent.entity.Car"%>

<html>
<head>
    <title>还车页面</title>
</head>
<body>
    <div class="">
        <h2>已租车辆</h2>
<%--        跳转到租车页--%>
        <form action="JEEServlet" method="post">
            <input type="hidden" name="operation" value="gotoRentCar">
            <p>
                <button type="submit"
                        name="gotoRentCar" value="gotoRentCar">
                    去租车</button>
            </p>
        </form>

        <form action="JEEServlet" method="post">
            <table>
                <tr class="title">
                    <th>编号</th>
                    <th>名称</th>
                    <th>备注</th>
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
                    <td><a href="#">还车</a></td>
                </tr>

                <!-- 提交表单时传值 -->
                <input type="hidden" name="operation" value="returnCar">
                <%-- 确定用户登录id --%>
                <input type="hidden" name="uerId" value="<%request.getAttribute("userId");%>">
                <%
                    Car[] rentedCars = (Car[]) request.getAttribute("rentedCars");
                    for (Car car : rentedCars
                    ) {
                        out.println("<tr>");
                        out.println("<td>" + car.getId() + "</td>");
                        out.println("<td>" + car.getCarName() + "</td>");
                        out.println("<td>" + car.getRemarks() + "</td>");
                        out.println("<td>" + car.getBrand() + "</td>");
                        out.println("<td>" + car.getPrice() + "</td>");
                        // 通过车辆id获取信息
                        out.println("<td><button type=\"submit\" name=\"return\" value="
                                + car.getId() + ">还车</button></td>");
                        out.println("<tr>");
                    }
                %>
            </table>
        </form>
    </div>
</body>
</html>
