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
        <input type="hidden" name="operation" value="rentCarPage">
        <%-- 确定用户登录id --%>
        <input type="hidden" name="uerId" value="<%request.getAttribute("userId");%>">
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
