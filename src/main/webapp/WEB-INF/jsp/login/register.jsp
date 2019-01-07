<%--
  Created by IntelliJ IDEA.
  User: wangzhou
  Date: 2019-01-04
  Time: 14:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
</head>
<body>


    <form action="/register", method="post">
        <table>
            <tr>
                <td align="right"><font color="red">*</font>用户名: </td>
                <td><input name="name" type="text" size=20>用户名不得使用特殊字符，只能使用字母和数字 </td>
            </tr>
            <tr>
                <td align="right"><font color="red">*</font>昵称: </td>
                <td><input name="nickname" type="text" size=20></td>
            </tr>
            <tr>
                <td align="right"><font color="red">*</font>密码: </td>
                <td><input name="password" type="password" size=20></td>
            </tr>
            <tr>
                <td align="right"><font color="red">*</font>再次输入密码: </td>
                <td><input name="password2" type="password" size=20></td>
            </tr>
            <tr>
                <td align="right"><font color="red">*</font>电话号码: </td>
                <td><input name="telephone" type="text" size=20></td>
            </tr>
            <tr>
                <td align="right"><font color="red">*</font>邀请码: </td>
                <td><input name="key" type="text" size=20></td>
            </tr>
            <button class="btn btn-lg btn-primary btn-block" type="submit"><span class="glyphicon glyphicon-log-in"></span> 注册</button>
        </table>
    </form>





</body>
</html>
