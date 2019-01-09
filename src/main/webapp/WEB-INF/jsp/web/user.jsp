<%--
  Created by IntelliJ IDEA.
  User: wangzhou
  Date: 2019-01-07
  Time: 14:13
  To change this template use File | Settings | File Templates.
  用来显示用户信息以及修改用户信息，目前只有昵称和电话号码能修改
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User</title>
</head>
<body>

<form action="/web/user", method="post">
    <table>
        <tr>
            <td align="right"><font color="red">*</font>用户名: </td>
            <td>${username} </td>
        </tr>
        <tr>
            <td align="right"><font color="red">*</font>昵称: </td>
            <td> ${nickname} </td>
            <td><input name="nickname" type="text" size=20></td>
        </tr>
        <tr>
            <td align="right"><font color="red">*</font>电话号码: </td>
            <td> ${telephone} </td>
            <td><input name="telephone" type="text" size=20></td>
        </tr>
        <tr>
            <div class="pull-right">
                <a href="mainpage" class="btn btn-default btn-flat">mainPage</a>
            </div>
        </tr>

        <button class="btn btn-lg btn-primary btn-block" type="submit"><span class="glyphicon glyphicon-log-in"></span> 修改</button>
    </table>
</form>

<form action="/web/deleteUser", method="post">
    <table>
        <tr>
            <td align="right"><font color="red">*</font>输入密码删除当前用户: </td>
            <td><input name="password" type="password" size=20></td>
        </tr>


        <button class="btn btn-lg btn-primary btn-block" type="submit"><span class="glyphicon glyphicon-log-in"></span> 删除</button>
    </table>
</form>

</body>
</html>
