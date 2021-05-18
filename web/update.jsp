<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <form method="post" action="/EmpManager/UpdateSubmitEmpServlet">
    <table align="center" width="500px" border="1" cellpadding="10px">
        <tr>
            <td align="center">编号</td>
            <td><input class="input-add" align="center" name="id" readonly value="${emp.id}"></td>
        </tr>
        <tr>
            <td align="center">姓名</td>
            <td><input class="input-add" name="name" value="${emp.name}"></td>
        </tr>
        <tr>
            <td align="center">年龄</td>
            <td><input class="input-add" name="age" value="${emp.age}"></td>
        </tr>
        <tr>
            <td align="center">性别</td>
            <td>
                <c:if test="${emp.sex==0}">
                <input type="radio" name="sex" checked value="0">女
                <input type="radio" name="sex" value="1">男
                </c:if>
                <c:if test="${emp.sex==1}">
                    <input type="radio" name="sex" value="0">女
                    <input type="radio" name="sex" checked value="1">男
                </c:if>
            </td>
        </tr>
        <tr>
            <td align="center">薪资</td>
            <td><input class="input-add" name="salary" value="${emp.salary}"></td>
        </tr>
        <tr>
            <td align="center" colspan="2">
                <input class="sub" style="margin-right: 50px" type="submit" value="修改">
                <input class="sub" style="margin-left: 50px" type="submit" value="取消">
            </td>
        </tr>
    </table>
    </form>
    </body>
</html>