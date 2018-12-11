<%--
  Created by IntelliJ IDEA.
  User: 刘文丰
  Date: 2018/12/2
  Time: 21:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="css/bootstrap.min.css" rel="stylesheet"/>
    <link href="css/style.css" rel="stylesheet"/>
    <link href="css/mdui.min.css" rel="stylesheet"/>
    <title>管理员页面</title>
</head>
<body class="mdui-theme-primary-indigo mdui-theme-accent-pink">
<div class="mdui-toolbar mdui-color-theme">
    <span class="mdui-typo-title">管理员页面</span>
    <div class="mdui-toolbar-spacer"></div>
    <a href=LogoutController><i class="mdui-icon material-icons">&#xe8ac;</i>登出</a>
</div>
<div style="width: 960px;margin: 10px auto;">
    <div class="mdui-table-fluid" style="width: 960px;margin:0 auto;text-align: center">

        <p style="font-size: 20px;">欢迎您，admin管理员</p><br>
        <input type="button" name="AddBook" value="书籍信息录入" onclick="window.location='AddBook.jsp'" style="height:45px;width:300px;display:inline-block;font-size: 20px;"><br><br>
        <input type="button" name="QueryInit" value="查询初始订单" onclick="window.location='QueryInit.jsp'" style="height:45px;width:300px;display:inline-block;font-size: 20px;"><br><br>
        <input type="button" name="QueryFinish" value="查询已完成订单" onclick="window.location='QueryFinish.jsp'" style="height:45px;width:300px;display:inline-block;font-size: 20px;"><br><br>
        <input type="button" name="QueryUser" value="查询用户信息"  onclick="window.location='QueryUser.jsp'" style="height:45px;width:300px;display:inline-block;font-size: 20px;"><br><br>
    </div>
    <hr>

</div>
</body>

<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/commons.js"></script>
</html>
