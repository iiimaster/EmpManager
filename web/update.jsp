<%--
  Created by IntelliJ IDEA.
  User: Genius
  Date: 2021/5/17
  Time: 21:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>EmaManager</title>
        <style>
            .input-add {
                height: 25px;
                width: 200px;
            }

            .sub {
                width: 50px;
                height: 30px;
            }
        </style>
    </head>

    <body>

    <h2 align="center">添加员工</h2>
    <table align="center" width="500px" border="1" cellpadding="10px">
        <tr>
            <td align="center">编号</td>
            <td><input class="input-add" align="center"></td>
        </tr>
        <tr>
            <td align="center">姓名</td>
            <td><input class="input-add"></td>
        </tr>
        <tr>
            <td align="center">年龄</td>
            <td><input class="input-add"></td>
        </tr>
        <tr>
            <td align="center">性别</td>
            <td><input class="input-add" type=""></td>
        </tr>
        <tr>
            <td align="center">薪资</td>
            <td><input class="input-add" type="text"/></td>
        </tr>
        <tr>
            <td align="center" colspan="2">
                <input class="sub" style="margin-right: 50px" type="submit" value="修改">
                <input class="sub" style="margin-left: 50px" type="submit" value="取消">
            </td>
        </tr>
    </table>
    </body>
</html>