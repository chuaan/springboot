<%--
  Created by IntelliJ IDEA.
  User: wangzhou
  Date: 2019-01-02
  Time: 16:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>ListAdmin</title>
</head>
<body>

<table align='center' border='1' cellspacing='0'>
    <tr>
        <td>admin</td>
        <td>uid</td>
        <td>username</td>
    </tr>
    <tr>
        <td>${admin}</td>
        <td>${uid}</td>
        <td>${name}</td>

    </tr>
</table>

</body>
</html>
