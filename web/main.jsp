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
    <link href="css/mdui.min.css" rel="stylesheet"/>
    <title>网上书店</title>
</head>
<body onload="initAJAX();showCategory()" class="mdui-theme-primary-indigo mdui-theme-accent-pink">
<div class="modal fade" id="myModal">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header"></div>
            <div class="modal-body"></div>
            <div class="modal-footer"></div>
        </div>
    </div>
</div>
<div class="mdui-toolbar mdui-color-theme">
    <span class="mdui-typo-title">欢迎来到我的书店</span>
    <div class="mdui-toolbar-spacer"></div>
    <a href="main.jsp"><i class="mdui-icon material-icons">&#xe88a;</i>主页</a>
    <a href="login.jsp" rel="tooltip" data-placement="bottom" data-toggle="modal" data-target="#myModal">
        <i class="mdui-icon material-icons">&#xe853;</i>登陆</a>
    <a href="signUp.jsp" rel="tooltip" data_placement="bottom" data-toggle="modal" data-target="#myModal">
        <i class="mdui-icon material-icons">&#xe147;</i>注册</a>
</div>

<div class="mdui-row"> <%--下方左右div控制--%>
    <div class="mdui-col-md-2" style="height:1000px"> <%--左侧菜单div控制--%>
        <div class="mdui-list" id="categorylist">
        </div>
    </div>
    <%--左侧菜单div控制--%>
    <div class="mdui-row-xs-5" id="book"><%--右侧书本div控制--%>
    </div>
    <%--右侧书本div控制--%>
</div>
<%--下方左右div控制--%>

<script language="JavaScript">
    function showCategory() {
        xmlHttp.open("GET", "/category", true);
        xmlHttp.onreadystatechange = function () {
            if (xmlHttp.readyState == 4) {
                var data = xmlHttp.responseText;
                var obj = JSON.parse(data);
                var listHtml = `<li class="mdui-list-item mdui-ripple">书籍类别</li>`;
                for (var i in obj) {
                    listHtml += `<a class="mdui-list-item mdui-ripple"
                    href="javascript:showBook(` + obj[i].id + `)">` + obj[i].name + `</a>`;
                }
                showBook(1);
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
                    var bookSrc = obj[i].image;
                    var author = obj[i].author;
                    if (desc.length > 20) {
                        desc = desc.substring(0, 18)
                    }
                    listbook += `<div class="mdui-col" style="padding: 8px">
      <div class="mdui-card">
        <div class="mdui-card-media">
          <img src="` + bookSrc + `"/><div class="mdui-card-menu">
            <button class="mdui-btn mdui-btn-icon mdui-text-color-white"><i class="mdui-icon material-icons">share</i></button>
          </div></div>
        <div class="mdui-card-primary" style="padding:10px 16px">
          <div class="mdui-card-primary-title">` + bookname +
                        `</div>
          <div class="mdui-card-primary-subtitle">` + author + `</div>
        </div>
        <div class="mdui-card-content" style="padding: 8px">` + desc + `</div>
        <div class="mdui-card-actions">
          <a href="login.jsp" rel="tooltip" data-placement="bottom" data-toggle="modal" data-target="#myModal" class="mdui-btn mdui-ripple">加入购物车</a>
          <button class="mdui-btn mdui-ripple">查看详情</button>` + `<button class="mdui-btn mdui-btn-icon mdui-float-right"><i class="mdui-icon material-icons">expand_more</i></button>
        </div>
      </div>
    </div>`;
                }
                document.getElementById("book").innerHTML = listbook;
            }
        }
        xmlHttp.send();
    }
</script>
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/commons.js"></script>
</body>
</html>

