<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 9/4/2020
  Time: 10:41 AM
  To change this template use File | Settings | File Templates.
--%>

<%--
  admin.jsp:管理员修改车辆页面
  功能：修改车辆信息, 添加车辆
  用户登录后由LoginServlet定向至此
  需要rentableCars属性显示可租车辆
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.carent.entity.Car"%>
<html>
<head>
    <title>管理员修改车辆页面</title>
    <link href="css/adminPage.css" rel="stylesheet" type="text/css" media="all" />
    <link href="css/footer.css" rel="stylesheet" type="text/css" media="all" />
    <link href="css/adminHeader.css" rel="stylesheet" type="text/css" media="all" />
</head>
<body>
    <%@include file="adminHeader.jsp"%>
    <%
        String opMsg = (String)request.getAttribute("opMsg");
        if(opMsg != null){
            out.println("<p>"+opMsg+"</p>");
        }
    %>
    <div>
        <form action="JEEServlet" method="post">
            <table id="tbl" class="table">
                <tr class="title">
                    <th>编号</th>
                    <th>名称</th>
                    <th>车牌</th>
                    <th>品牌</th>
                    <th>型号</th>
                    <th>价格</th>
                    <th>操作</th>
                </tr>
                <%-- 测试显示 --%>
                <tr>
                    <td class="txt">1</td>
                    <td class="txt">朗逸</td>
                    <td class="txt">自动1.6L</td>
                    <td class="txt">大众2</td>
                    <td class="txt">舒适型</td>
                    <td class="txt">72.0/天</td>
                    <td class="adminButton"> <a href="#">修改</a></td>
                </tr>
                <%
                    Car[] cars = (Car[]) request.getAttribute("cars");
                    for (Car car : cars
                    ) {
                        out.println("<tr class=\"txt\">");
                        out.println("<td >" + car.getId() + "</td>");
                        out.println("<td >" + car.getCarName() + "</td>");
                        out.println("<td>" + car.getCarNo() + "</td>");
                        out.println("<td >" + car.getBrand() + "</td>");
                        out.println("<td >" + car.getType() + "</td>");
                        out.println("<td class=\"\">" + car.getPrice() + "</td>");
                        // 通过车辆id获取信息
                        out.println("<td class=\"adminButton\"><button type=\"submit\" name=\"carId\" value=\""
                                + "gotoModifyCar,"+ car.getId() + "\">修改车辆信息</button></td>");
                        out.println("<td class=\"adminButton\"><button type=\"submit\" name=\"operation\" value=\""
                                + "deleteCar," + car.getId() + "\">删除车辆</button></td>");
                        out.println("</tr>");
                    }
                %>
            </table>
        </form>
    </div>
    <%@include file="footer..jsp"%>

</body>
</html>
