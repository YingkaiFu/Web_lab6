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
                <a><%=session.getAttribute("username")%>
                </a>
                <a class="car" href="cart.jsp" rel="tooltip" data-placement="bottom" data-toggle="modal"
                   data-target="#myModal"></a>
                <a class="logout" href="LogoutController" rel="tooltip" data-placement="bottom" data-toggle="modal"
                   data-target="#myModal"></a>
            </div>
        </div>
    </div>
</div>
<%--header--%>

<div style="text-align: center">
    <p style="font-size: 20px;">欢迎您，admin管理员</p><br>
    <form action="AdminController" method="post">
        <input type="submit" name="AddBook" value="书籍信息录入" style="height:45px;width:300px;display:inline-block;font-size: 20px;"><br><br>
        <input type="submit" name="QueryInit" value="查询初始订单" style="height:45px;width:300px;display:inline-block;font-size: 20px;"><br><br>
        <input type="submit" name="QueryFinish" value="查询已完成订单" style="height:45px;width:300px;display:inline-block;font-size: 20px;"><br><br>
        <input type="submit" name="QueryUser" value="查询用户信息" style="height:45px;width:300px;display:inline-block;font-size: 20px;"><br><br>
    </form>
</div>
</body>
</html>
