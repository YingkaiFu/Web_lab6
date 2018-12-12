<%--
  Created by IntelliJ IDEA.
  User: 刘文丰
  Date: 2018/12/2
  Time: 22:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="css/bootstrap.min.css" rel="stylesheet"/>
    <link href="css/style.css" rel="stylesheet"/>
    <link href="css/mdui.min.css" rel="stylesheet"/>
    <title>查询用户信息</title>
</head>
<body onload="initAJAX();showUser()" class="mdui-theme-primary-indigo mdui-theme-accent-pink">
<div class="mdui-toolbar mdui-color-theme">
    <span class="mdui-typo-title">用户信息</span>
    <div class="mdui-toolbar-spacer"></div>
    <a href=LogoutController><i class="mdui-icon material-icons">&#xe8ac;</i>登出</a>
</div>
<div style="width: 960px;margin: 10px auto;">
    <div class="mdui-table-fluid" style="width: 960px;margin:0 auto">
        <table class="mdui-table">
            <thead>
            <tr>
                <th>用户ID</th>
                <th>用户名</th>
                <th>电话</th>
                <th>手机</th>
                <th>Email</th>
                <th>地址</th>
            </tr>
            </thead>
            <tbody id="body">
            </tbody>
        </table>
    </div>
    <hr>
    <div style="text-align: right">
        <a href="adminpage.jsp" class="mdui-btn mdui-ripple mdui-color-red">返回</a>
    </div>
</div>
</body>
<script language="JavaScript">
    function showUser() {
        xmlHttp.open("GET", "/getUser", true);
        xmlHttp.onreadystatechange = function () {
            if (xmlHttp.readyState == 4) {
                var data = xmlHttp.responseText;
                var obj = JSON.parse(data);
                var listuser = '';
                for (var i in obj) {
                    var id = obj[i].id;
                    var username = obj[i].username;
                    var phone = obj[i].phone;
                    var cellphone= obj[i].cellphone;
                    var email=obj[i].email;
                    var address=obj[i].address;
                    listuser += `<tr>
                    <td>`+id + `</td>
                    <td>`+username + `</td>
                    <td>`+phone + `</td>
                        <td >`+cellphone + `</td>
                        <td>`+email+`</td>
                        <td>`+address+`</td>
                        </tr>`;
                }
                document.getElementById("body").innerHTML = listuser;
            }
        };
        xmlHttp.send();
    };
</script>
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/commons.js"></script>
</html>
