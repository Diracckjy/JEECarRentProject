<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 9/3/2020
  Time: 7:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>租车</title>
    <link href="css/rentCar.css" rel="stylesheet" type="text/css" />
    <link href="css/rentCar2.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div class="top-Bar">
    <div class="container clearfix">
        <div class="topbar-nav">
            <form style="float:left" action="JEEServlet">
            <a href="javascript:void(0);">租车</a>
            <span class="sep">|</span>
            <a href="javascript:void(0);">还车</a>
            <span class="sep">|</span>
            <a href="javascript:void(0);">退出登录</a>
            <span class="sep">|</span>
            </form>
            <div class="topbar-info">
                <span class="iconfont">&#xe604;</span>
                <span class="sep">|</span>
                <a href="#">用户</a>
            </div>
        </div>
        <div style="width:100%;height: 50px;">

        </div>
        <table class="container">
            <thead>
            <tr>
                <th>
                    <h1>名称</h1></th>
                <th>
                    <h1>备注</h1></th>
                <th>
                    <h1>品牌</h1></th>
                <th>
                    <h1>类型</h1></th>
                <th>
                    <h1>价格</h1></th>
                <th>
                    <h1><b href="#">操作</b><h1></th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>朗逸</td>
                <td>自动1.6L</td>
                <td>大众2</td>
                <td>舒适型</td>
                <td>72.0/一天</td>
                <td><a href="#">租车</a></td>
            </tr>
            <tr>
                <td>Twitter</td>
                <td>7326</td>
                <td>10437</td>
                <td>00:51:22</td>
                <td>01:32:50</td>
                <td><a href="#">租车</a></td>
            </tr>
            <tr>
                <td>Amazon</td>
                <td>4162</td>
                <td>5327</td>
                <td>00:24:34</td>
                <td>01:32:50</td>
                <td><a href="#">租车</a></td>
            </tr>
            <tr>
                <td>LinkedIn</td>
                <td>3654</td>
                <td>2961</td>
                <td>00:12:10</td>
                <td>01:32:50</td>
                <td><a href="#">租车</a></td>
            </tr>
            <tr>
                <td>CodePen</td>
                <td>2002</td>
                <td>4135</td>
                <td>00:46:19</td>
                <td>01:32:50</td>
                <td><a href="#">租车</a></td>
            </tr>
            <tr>
                <td>GitHub</td>
                <td>4623</td>
                <td>3486</td>
                <td>00:31:52</td>
                <td>01:32:50</td>
                <td><a href="#">租车</a></td>
            </tr>
            </tbody>
        </table>
</body>
</html>