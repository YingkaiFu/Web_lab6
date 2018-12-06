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
</head>
<body>
<div class="mdui-toolbar mdui-color-theme">
    <span class="mdui-typo-title">订单状况</span>
    <div class="mdui-toolbar-spacer"></div>
    <a href="home.jsp"> <i class="mdui-icon material-icons">&#xe834;</i>订单</a>
    <a href="cart.jsp"><i class="mdui-icon material-icons">&#xe8cc;</i>购物车
        <span id="count"><%=session.getAttribute("count")%></span>
    </a>
    <a href=LogoutController><i class="mdui-icon material-icons">&#xe8ac;</i>登出</a>
</div>
<div align="center">
    <img src="/images/success.png" alt="成功">
</div>
</body>
</html>
