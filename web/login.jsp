
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EMP-login</title>
    <style>

    </style>
</head>
<body>
<br><h2 align="center">用户登录</h2><hr><br>
    <div align="center" style="color: red">${error}</div>
    <form method="post" action="/EmpManager/LoginEmpServlet">
        <table align="center" width="400px" border="1">
            <tr>
                <td align="center"class="user">用户名</td><td><input name="username" type="text"></td>
            </tr>
            <tr>
                <td align="center" class="user">密码</td><td><input name="password" type="password"></td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="checkbox" style="margin-left: 80px" name="autoLoginNum" value="2">两周内免登录
                </td>
            </tr>
            <tr>
                <td align="center" colspan="2">
                    <input class="sub" style="margin-right: 50px" type="submit" value="登录">
                    <input class="sub" style="margin-left: 50px" type="submit" value="取消">
                </td>
            </tr>
        </table>
    </form>
</body>
</html>
