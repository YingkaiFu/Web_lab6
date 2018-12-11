<%--
  Created by IntelliJ IDEA.
  User: Yingkai
  Date: 2018/12/5
  Time: 2:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="css/bootstrap.min.css" rel="stylesheet"/>
    <link href="css/style.css" rel="stylesheet"/>
    <link href="css/mdui.min.css" rel="stylesheet"/>
    <title>Title</title>
    <style>
        img {
            padding: 15px;
            float: left;
        }
        .Suc{
            padding: 20px 20px 20px 0px;
            font-family: 宋体, serif;
            font-size: 18px;
        }
    </style>
</head>
<body class="mdui-theme-primary-indigo mdui-theme-accent-pink">
<div class="mdui-toolbar mdui-color-theme">
    <span class="mdui-typo-title">订单状况</span>
    <div class="mdui-toolbar-spacer"></div>
    <a href="mainpage.jsp"><i class="mdui-icon material-icons">&#xe88a;</i>主页</a>
    <a href="myOrderInfo.jsp"> <i class="mdui-icon material-icons">&#xe834;</i>订单</a>
    <a href="cart.jsp"><i class="mdui-icon material-icons">&#xe8cc;</i>购物车
        <span id="count"><%=session.getAttribute("count")%></span>
    </a>
    <a href=LogoutController><i class="mdui-icon material-icons">&#xe8ac;</i>登出</a>
</div>
<div class="mdui-container">
    <div class="mdui-row" style="padding-top: 100px">
    <div class="mdui-col-xs-4">
        <i class="mdui-icon material-icons" style="font-size: 100px;color: #3f51b5 ;display: block">&#xe876;</i>
    </div>
        <div class="mdui-col-xs-4">
            <div class="Suc">成功支付！</div>
            <div>你可以在<a href="myOrderInfo.jsp">我的订单</a>中查看订单了</div>
        </div>
    </div>
</div>

</body>
</html>
