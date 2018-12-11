<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="css/bootstrap.min.css" rel="stylesheet"/>
    <link href="css/style.css" rel="stylesheet"/>
    <link href="css/mdui.min.css" rel="stylesheet"/>
    <title>添加书籍</title>
</head>
<body class="mdui-theme-primary-indigo mdui-theme-accent-pink">
<div class="mdui-toolbar mdui-color-theme">
    <span class="mdui-typo-title">添加书籍</span>
    <div class="mdui-toolbar-spacer"></div>
    <a href=LogoutController><i class="mdui-icon material-icons">&#xe8ac;</i>登出</a>
</div>
<div style="width: 960px;margin: 10px auto;">
    <div class="mdui-table-fluid" style="width: 960px;margin:0 auto">
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
                <div style="float:left;"><button class="mdui-btn mdui-ripple mdui-color-red" type="submit">提交</button></div>
                <div style="float:right;"><a href="adminpage.jsp" class="mdui-btn mdui-ripple mdui-color-red">返回</a></div>
            </div>


        </form>
    </div>
    <hr>

</div>
</body>

<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/commons.js"></script>
</html>
