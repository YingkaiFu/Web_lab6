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
    <title>网上书店</title>

</head>
<body onload="initAJAX();showCategory()">
<div class="modal fade" id="myModal">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header"></div>
            <div class="modal-body"></div>
            <div class="modal-footer"></div>
        </div>
    </div>
</div>

<div class="header">
    <div class="container">
        <div class="row">
            <div class="login span4">
                <h1><a href=""> 欢迎来到<strong>我的</strong>书店</a>
                    <span class="red">.</span></h1>
            </div>
            <div class="links span8">
                <a class="logout" href="LogoutController" rel="tooltip" data-placement="bottom" data-toggle="modal"
                   data-target="#myModal"></a>
            </div>
        </div>
    </div>
</div>
<%--header--%>

<div style="text-align: center">
    <p style="font-size: 20px;">欢迎您，admin管理员</p><br>
    <input type="button" name="AddBook" value="书籍信息录入" onclick="window.location='AddBook.jsp'" style="height:45px;width:300px;display:inline-block;font-size: 20px;"><br><br>
    <input type="button" name="QueryInit" value="查询出示订单" onclick="window.location='QueryInit.jsp'" style="height:45px;width:300px;display:inline-block;font-size: 20px;"><br><br>
    <input type="button" name="QueryFinish" value="查询已完成订单" onclick="window.location='QueryFinish.jsp'" style="height:45px;width:300px;display:inline-block;font-size: 20px;"><br><br>


        <input type="button" name="QueryUser" value="查询用户信息"  onclick="window.location='QueryUser.jsp'" style="height:45px;width:300px;display:inline-block;font-size: 20px;"><br><br>


</div>
</body>
</html>
