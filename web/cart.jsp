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
    <title>购物车</title>
</head>
<body onload="initAJAX();Update()">
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
                <h1><a href=""> 购物车</a></h1>
            </div>
            <div class="links span8">
                <a><%=session.getAttribute("username")%>
                </a>
                <a class="logout" href="LogoutController" rel="tooltip" data-placement="bottom" data-toggle="modal"
                   data-target="#myModal"></a>
            </div>
        </div>
    </div>
</div>
<div style="width: 960px;margin: 10px auto;">
    <div style="width: 960px">
        <table>
            <tr>
                <th>
                <td class="style01">选择</td>
                <th>
                <td class="style02">名称</td>
                <th class="style03">
                <td>单价</td>
                <td>数量</td>
                <td>操作</td>
                </th>
            </tr>
            <tr></tr>
        </table>
    </div>
    <hr>
    <%--<%--%>
        <%--List<Book> cart =((Cart) session.getAttribute("cart")).getBookList();--%>
        <%--if(cart!=null) {--%>
            <%--for (Book book : cart) {--%>
                <%--double price = book.getPrice();--%>
                <%--String name = book.getName();--%>
                <%--String author = book.getAuthor();--%>
                <%--String image = book.getImage();--%>
    <%--%>--%>
    <div style="height:300px">
        <table id = "cart">
        <%--<%--%>

                <%--}--%>
            <%--}--%>
        <%--%>--%>
        </table>
    </div>
    <div style="text-align: right">
        <a style="margin-top: 10px" href="SubmitController" class="btn btn-danger" role="button">提交</a>
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
                for (var i in obj) {
                    var bookname = obj[i].name;
                    var price = obj[i].price;
                    var bookSrc = obj[i].image;
                    listbook += `<tr>
                    <th>
                    <td><img src="`+bookSrc+`" width="80" height="80"></td>
                        <td class="style02">`+bookname + `</td>
                        <th class="style03">
                        <td>`+price+`</td>
                        <td>`+"1"+`</td>
                        <td>`+ `<a href="javascript:delete(` + obj[i].id + `)" class="btn btn-primary" role="button">删除</a>`+`</td>
                        </tr>`;
                }
                document.getElementById("cart").innerHTML = listbook;
            }
        };
        xmlHttp.send();
    };
</script>
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/commons.js"></script>
</html>
