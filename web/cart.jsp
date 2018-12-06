<%@ page import="vo.Cart" %>
<%@ page import="vo.Book" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Yingkai
  Date: 2018/12/2
  Time: 14:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="css/bootstrap.min.css" rel="stylesheet"/>
    <link href="css/style.css" rel="stylesheet"/>
    <link href="css/mdui.min.css" rel="stylesheet"/>
    <title>购物车</title>
</head>
<body onload="initAJAX();Update()" class="mdui-theme-primary-indigo mdui-theme-accent-pink">
<div class="mdui-toolbar mdui-color-theme">
    <span class="mdui-typo-title">欢迎来到我的书店</span>
    <div class="mdui-toolbar-spacer"></div>
    <a href="home.jsp"> <i class="mdui-icon material-icons">&#xe834;</i>订单</a>
    <a href="cart.jsp"><i class="mdui-icon material-icons">&#xe8cc;</i>购物车<%=session.getAttribute("count")%></a>
    <a href=LogoutController><i class="mdui-icon material-icons">&#xe8ac;</i>登出</a>
</div>
<div style="width: 960px;margin: 10px auto;">
    <div class="mdui-table-fluid" style="width: 960px;margin:0 auto">
        <table class="mdui-table">
            <thead>
            <tr>
                <th>选择</th>
                <th>名称</th>
                <th>单价</th>
                <th>数量</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody id="body">
            </tbody>
        </table>
    </div>
    <hr>
    <div style="text-align: right">
        <span  style="margin-top: 10px">总价格为：</span>
        <span style="margin-top: 10px" id="total"></span>
        <a href="AddOrderController" class="mdui-btn mdui-ripple mdui-color-red">提交订单</a>
    </div>
</div>
</body>
<script language="JavaScript">
    function Update() {
        xmlHttp.open("GET", "/getCart", true);
        xmlHttp.onreadystatechange = function () {
            if (xmlHttp.readyState == 4) {
                var data = xmlHttp.responseText;
                var obj = JSON.parse(data);
                var listbook = '';
                var total=0.00;
                for (var i in obj) {
                    var bookname = obj[i].name;
                    var price = obj[i].price;
                    var bookSrc = obj[i].image;
                    var number = obj[i].number;
                    total+= parseFloat(price)*parseInt(number);
                    listbook += `<tr>
                    <td><img src="`+bookSrc+`" width="80" height="80"></td>
                        <td>`+bookname + `</td>
                        <td>`+price+`</td>
                        <td>`+number+`</td>
                        <td>`+ `<a href="javascript:delete(` + obj[i].id + `)" class="btn btn-primary" role="button">删除</a>`+
                        `</tr>`;
                }
                document.getElementById("body").innerHTML = listbook;
                document.getElementById("total").innerHTML = total.toFixed(2);
            }
        };
        xmlHttp.send();
    };

    function UpdateCount() {

    }
</script>
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/commons.js"></script>
</html>
