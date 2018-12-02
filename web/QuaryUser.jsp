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
    <title>Insert title here</title>
    <style>
        th, tr, td, table {
            border: 1px solid #000000;
        }
    </style>
</head>
<body>
<table>
    <tr>
        <th>id</th>
        <th>username</th>
        <th>phone</th>
        <th>cellphone</th>
        <th>email</th>
        <th>address</th>
    </tr>

    <c:forEach items="${Users}" var="user" varStatus="idx">
        <tr>
            <td>${user.id}</td><td>${user.username}</td> <td>${user.phone}</td>
            <td>${user.cellphone}</td><td>${user.email}</td><td>${user.address}</td>
        </tr>
    </c:forEach>

</table>

</body>
</html>
