<%--
  Created by IntelliJ IDEA.
  User: Yingkai
  Date: 2018/11/27
  Time: 19:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
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
                <a class="login" href="login.jsp" rel="tooltip" data-placement="bottom" data-toggle="modal"
                   data-target="#myModal"></a>
                <a class="register" href="logup.jsp" rel="tooltip" data_placement="bottom" data-toggle="modal"
                   data-target="#myModal"></a>
            </div>
        </div>
    </div>
</div> <%--header--%>

<div class="row"> <%--下方左右div控制--%>
    <div class="col-md-3"> <%--左侧菜单div控制--%>
        <ul class="nav nav-list" id="categorylist">
        </ul>
    </div><%--左侧菜单div控制--%>

    <div class="col-md-9" id="book"><%--右侧书本div控制--%>

    </div>
    <%--右侧书本div控制--%>
</div><%--下方左右div控制--%>

<script language="JavaScript">
    function showCategory() {
        xmlHttp.open("GET", "/category", true);
        xmlHttp.onreadystatechange = function () {
            if (xmlHttp.readyState == 4) {
                var data = xmlHttp.responseText;
                var obj = JSON.parse(data);
                var listHtml = "<li class=\"nav-header\">书籍类别</li>\n";
                for (var i in obj) {
                    listHtml += "<li>\n" +
                        " <a href=\"javascript:showBook(" + obj[i].id + ")\">" + obj[i].name + "</a>\n" +
                        "           </li>"
                }
                document.getElementById("categorylist").innerHTML = listHtml;
            }
        }
        xmlHttp.send();
    }

    function showBook(categoryID) {
        xmlHttp.open("GET", "getBookByCategoryID?id=" + categoryID, true);
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
                        `</p><p><a href="login.jsp" class="btn btn-primary" role="button">加入购物车</a> <a href="#" class="btn btn-default" role="button">查看详情` +
                        `</a></p></div></div> </div>`;

                }
                document.getElementById("book").innerHTML = listbook;
            }
        }
        xmlHttp.send();
    }
</script>
<script src="js/jquery.min.js" ></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/commons.js"></script>
</body>
</html>

