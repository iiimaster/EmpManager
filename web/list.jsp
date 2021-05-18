<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>EmaManager</title>
    <style>

    </style>
</head>
<body>
<br>
<h2 align="center">员工管理系统Bate</h2><br>
<table align="center" width="550px" border="1" cellpadding="10px">
    <tr align="center">
        <td>编号</td>
        <td>姓名</td>
        <td>年龄</td>
        <td>性别</td>
        <td>薪资</td>
        <td>相关操作&nbsp;&nbsp;&nbsp;<a href="/EmpManager/add.html">添加</a></td>
    </tr>
    <c:forEach var="emp" items="${emps}">
    <tr align="center">
        <td>${emp.id}</td>
        <td>${emp.name}</td>
        <td>${emp.age}</td>
        <td>${emp.sex == 0?'女':'男'}</td>
        <td>${emp.salary}</td>
        <td><a href="/EmpManager/DeleteEmpServlet?id=${emp.id}" >删除</a>&nbsp;&nbsp;
            <a href="/EmpManager/UpdateEmpServlet?id=${emp.id}" >修改</a></td>
    </tr>
    </c:forEach>
</table>
</body>
</html>
