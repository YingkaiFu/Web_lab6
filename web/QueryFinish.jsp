<%--
  Created by IntelliJ IDEA.
  User: 刘文丰
  Date: 2018/12/2
  Time: 22:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="css/bootstrap.min.css" rel="stylesheet"/>
    <link href="css/style.css" rel="stylesheet"/>
    <link href="css/mdui.min.css" rel="stylesheet"/>
    <title>查询所有订单</title>
</head>
<body onload="initAJAX();showOrder()" class="mdui-theme-primary-indigo mdui-theme-accent-pink">
<div class="mdui-toolbar mdui-color-theme">
    <span class="mdui-typo-title">查询所有订单</span>
    <div class="mdui-toolbar-spacer"></div>
    <a href=LogoutController><i class="mdui-icon material-icons">&#xe8ac;</i>登出</a>
</div>
<div style="width: 960px;margin: 10px auto;">
    <div class="mdui-table-fluid" style="width: 960px;margin:0 auto">
        <table class="mdui-table">
            <thead>
            <tr>
                <th>订单号</th>
                <th width="200px">时间</th>
                <th>总价</th>
                <th>状态</th>
                <th>用户ID</th>
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
    function showOrder() {
        xmlHttp.open("GET", "/getOrder", true);
        xmlHttp.onreadystatechange = function () {
            if (xmlHttp.readyState == 4) {
                var data = xmlHttp.responseText;
                var obj = JSON.parse(data);
                var listorder = '';
                for (var i in obj) {
                    var id = obj[i].id;
                    var ordertime = obj[i].ordertime;
                    var price = obj[i].price;
                    var state= obj[i].state;
                    var user_id=obj[i].user_id;

                    listorder += `<tr>
                    <td>`+id + `</td>
                    <td width="100px">`+ordertime + `</td>
                    <td>`+price + `</td>
                        <td >`+state + `</td>
                        <td>`+user_id+`</td>
                        </tr>`;
                }
                document.getElementById("body").innerHTML = listorder;
            }
        };
        xmlHttp.send();
    };


</script>
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/commons.js"></script>
</html>