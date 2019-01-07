<%--
  Created by IntelliJ IDEA.
  User: wangzhou
  Date: 2019-01-07
  Time: 16:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Password</title>
</head>
<body>
<form action="/web/password", method="post">
    <table>
        <tr>
            <td align="right"><font color="red">*</font>原密码: </td>
            <td><input name="originPassword" type="password" size=20></td>
        </tr>
        <tr>
            <td align="right"><font color="red">*</font>新密码: </td>
            <td><input name="password" type="password" size=20></td>
        </tr>
        <tr>
            <td align="right"><font color="red">*</font>再次输入新密码: </td>
            <td><input name="password2" type="password" size=20></td>
        </tr>
        <tr>
            <div class="pull-right">
                <a href="mainpage" class="btn btn-default btn-flat">mainPage</a>
            </div>
        </tr>

        <button class="btn btn-lg btn-primary btn-block" type="submit"><span class="glyphicon glyphicon-log-in"></span> 注册</button>
    </table>
</form>

</body>
</html>
