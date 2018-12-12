<%--
  Created by IntelliJ IDEA.
  User: huwei
  Date: 2018/12/6
  Time: 20:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="css/bootstrap.min.css" rel="stylesheet"/>
    <link href="css/style.css" rel="stylesheet"/>
    <link href="css/mdui.min.css" rel="stylesheet"/>
    <title>我的订单</title>
</head>
<body onload="initAJAX();showOrder()" class="mdui-theme-primary-indigo mdui-theme-accent-pink">
<div class="mdui-toolbar mdui-color-theme">
    <span class="mdui-typo-title">我的订单</span>
    <div class="mdui-toolbar-spacer"></div>
    <a href="mainpage.jsp"><i class="mdui-icon material-icons">&#xe88a;</i>主页</a>
    <a href="myOrderInfo.jsp"> <i class="mdui-icon material-icons">&#xe834;</i>订单</a>
    <a href="cart.jsp"><i class="mdui-icon material-icons">&#xe8cc;</i>购物车<%=session.getAttribute("count")%></a>
    <a href=LogoutController><i class="mdui-icon material-icons">&#xe8ac;</i>登出</a>
</div>
<div style="width: 960px;margin: 10px auto;" id="body">

</div>
</body>
<script>
    function showOrder() {
        xmlHttp.open("GET", "/GetOrderByUserController", true);
        xmlHttp.onreadystatechange = function () {
            if (xmlHttp.readyState == 4) {
                var data = xmlHttp.responseText;
                var obj = JSON.parse(data);
                var listHtml = `<div class="mdui-table-fluid" style="width: 960px;margin:0 auto" >
<table class="mdui-table">
            <thead>
            <tr>
                <th>订单号</th>
                <th>书籍名称</th>
                <th>价格</th>
                <th>数量</th>
                <th>总价</th>
            </tr>
            </thead>`;
                var temp = 0;
                var flag=1;
                for (var i in obj) {
                    if (temp != obj[i].order_id) {
                        var listHtml = listHtml + `</table></div>
    <br><div class="mdui-table-fluid" style="width: 960px;margin:0 auto" ><table class="mdui-table">`;
                        temp = obj[i].order_id;
                        flag=0;
                    }
                    var id = obj[i].id;
                    var state = obj[i].order_state;
                    var date = obj[i].order_time;
                    var quantity = obj[i].quantity;
                    var price = obj[i].item_price;
                    var order_id = obj[i].order_id;
                    var book_name=obj[i].book_name;
                    var total = obj[i].order_price;

                    if(flag==0){
                        listHtml += `<tr>
                    <td>`+state+`</td>
                    <td>`+date+`</td>
                    <td></td>
                    <td></td>
                    <td rowspan="6">`+total+`</td>
                        </tr>`;
                        flag=1;
                    }
                    listHtml += `<tr>
                    <td>`+order_id+`</td>
                    <td>`+book_name+`</td>
                    <td>`+price+`</td>
                    <td>`+quantity+ `</td>
                        </tr>`;

                }
                document.getElementById("body").innerHTML = listHtml;
            }
        }
        xmlHttp.send();
    }
</script>
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/commons.js"></script>
</html>
