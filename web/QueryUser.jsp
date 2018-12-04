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
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link href="css/bootstrap.min.css" rel="stylesheet"/>
    <link href="css/style.css" rel="stylesheet"/>

    <title>网上书店</title>
    <style>
        th, tr, td, table {
            border: 1px solid #000000;
        }
    </style>
</head>
<body onload="initAJAX();showUser()">

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
                <a class="logout" href="LogoutController" rel="tooltip" data-placement="bottom" data-toggle="modal"
                   data-target="#myModal"></a>
            </div>
        </div>
    </div>
</div>
<%--header--%>

<div>
    <table id = "user">
        <%--<%--%>

        <%--}--%>
        <%--}--%>
        <%--%>--%>
    </table>
</div>
<div style="text-align: right">
    <a style="margin-top: 10px" href="adminpage.jsp" class="btn btn-danger" role="button">返回</a>
</div>
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
                document.getElementById("user").innerHTML = listuser;
            }
        };
        xmlHttp.send();
    };
</script>
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/commons.js"></script>
</body>
</html>
