<%--
  Created by IntelliJ IDEA.
  User: 刘文丰
  Date: 2018/12/2
  Time: 22:37
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

<div class="modal-title">
    <h1 class="text-center">登录</h1>
</div>
<div class="modal-body">
    <form class="form-group" action="AddBookController" method="post">
        <div class="form-group">
            <label>书名</label>
            <input name="bookname" class="form-control" type="text" placeholder="请输入书名">
        </div>
        <div class="form-group">
            <label>作者</label>
            <input name="author" class="form-control" type="text" placeholder="请输入作者">
        </div>
        <div class="form-group">
            <label>价格</label>
            <input name="price" class="form-control" type="text" placeholder="请输入价格">
        </div>
        <div class="form-group">
            <label>图片</label>
            <input name="image" class="form-control" type="text" placeholder="请输入图片链接">
        </div>
        <div class="form-group">
            <label>描述</label>
            <input name="remarks" class="form-control" type="text" placeholder="请简要描述此书">
        </div>
        <div>
            <button class="btn btn-primary" type="submit">提交</button>

        </div>
    </form>
    <div style="margin-top: -48px;margin-left: 200px">
        <form action="adminpage.jsp" method="post">
            <button class="btn btn-danger" data-dismiss="modal">取消</button>
        </form>
    </div>
</div>

</body>
</html>
