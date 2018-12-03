<%--
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
<div id="book"></div>
<%--<div class="row"> &lt;%&ndash;下方左右div控制&ndash;%&gt;--%>
<%--<div class="col-md-3"> &lt;%&ndash;左侧菜单div控制&ndash;%&gt;--%>
<%--<ul class="nav nav-list" id="categorylist">--%>
<%--</ul>--%>
<%--</div>--%>
<%--&lt;%&ndash;左侧菜单div控制&ndash;%&gt;--%>

<%--<div class="col-md-9" id="book">&lt;%&ndash;右侧书本div控制&ndash;%&gt;--%>

<%--</div>--%>
<%--&lt;%&ndash;右侧书本div控制&ndash;%&gt;--%>
<%--</div>--%>
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
                    var desc = obj[i].description;
                    if (desc.length > 20) {
                        desc = desc.substring(0, 17)
                    }
                    listbook += `<div class="col-sm-9 col-md-3"><div class="thumbnail" ><img src="images/book.jpg"><div class="caption">  <h4>`
                        + bookname +
                        `</h4><p>` + desc +
                        `</p><p><a href="javascript:add(` + obj[i].id + `)" class="btn btn-primary" role="button">加入购物车</a> <a href="#" class="btn btn-default" role="button">查看详情` +
                        `</a></p></div></div> </div>`;

                }
                document.getElementById("book").innerHTML = listbook;
            }
        };
        xmlHttp.send();
    };
</script>
</html>
