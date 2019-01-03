<%--
  Created by IntelliJ IDEA.
  User: wangzhou
  Date: 2018-12-29
  Time: 15:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>listUser</title>
</head>
<body>

<table align='center' border='1' cellspacing='0'>
    <tr>
        <td>uid</td>
        <td>username</td>
        <td>nickname</td>
        <td>telephone</td>
    </tr>
    <c:forEach items="${users}" var="user" varStatus="st">
        <tr>
            <td>${user.uid}</td>
            <td>${user.username}</td>
            <td>${user.nickname}</td>
            <td>${user.telephone}</td>

        </tr>
    </c:forEach>
</table>

</body>
</html>
