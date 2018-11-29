<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
</head>
<body>
<div class="modal-title">
    <h1 class="text-center">注册</h1>
</div>
<div class="modal-body">
    <form class="form-group" action="LogupController" method="post">
        <div class="form-group">
            <label id="username">用户名</label>
            <input name="id" class="form-control" type="text" placeholder="请输入用户名">
        </div>
        <div class="form-group">
            <label id="password">密码</label>
            <input name="pwd" class="form-control" type="password" placeholder="请输入密码">
        </div>
        <div class="form-group">
            <label id="phone">手机(可选)</label>
            <input name="phone" class="form-control" type="text" placeholder="请输入手机号码">
        </div>
        <div class="form-group">
            <label>电话(可选)</label>
            <input name="tel" class="form-control" type="text" placeholder="请输入电话">
        </div>
        <div class="form-group">
            <label>邮箱(可选)</label>
            <input name="email" class="form-control" type="text" placeholder="请输入邮箱">
        </div>
        <div class="form-group">
            <label>地址(可选)</label>
            <input name="add" class="form-control" type="text" placeholder="请输入地址">
        </div>
        <div>
            <button class="btn btn-primary" type="submit">注册</button>
        </div>
    </form>
    <div style="margin-top: -48px;margin-left: 200px">
    <form action="main.jsp" method="post">
        <button class="btn btn-danger" data-dismiss="modal">取消</button>
    </form>
    </div>
</div>

<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>