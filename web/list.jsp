<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>EmaManager</title>
    <script src="jquery-3.4.0.js"></script>
</head>
<body>
<br>
<h2 align="center">员工管理系统Bate</h2>
<div style="margin-left: 1200px" ><span>访问量：${traffic}</span>&nbsp;&nbsp;&nbsp;<span>在线人数：${online}</span></div>
<br>
<table align="center" width="750px" border="1" cellpadding="10px">
    <tr align="center">
        <td>编号</td>
        <td>姓名</td>
        <td>年龄</td>
        <td>性别</td>
        <td>薪资</td>
        <td>相关操作&nbsp;&nbsp;&nbsp;<a href="/EmpManager/add.jsp">添加</a></td>
    </tr>
    <c:forEach var="emp" items="${emps}">
    <tr align="center">
        <td>${emp.id}</td>
        <td>${emp.name}</td>
        <td>${emp.age}</td>
        <td>${emp.sex == 0?'女':'男'}</td>
        <td>${emp.salary}</td>
        <td>
            <a href="/EmpManager/DeleteEmpServlet?id=${emp.id}" ><button value="delete">删除</button></a>&nbsp;&nbsp;
            <a href="/EmpManager/UpdateEmpServlet?id=${emp.id}" >修改</a>&nbsp;&nbsp;
<%--            <span class="pageUpdate" empID="${emp.id}" href="#"><button class="pageUpdate" value="updatePlus">同页修改</button></span>--%>
            <span class="pageUpdate" empID="${emp.id}" style="text-decoration: underline;color: blue">同页修改</span>
        </td>
    </tr>
    </c:forEach>
</table>
</body>
<script>
    $(function () {
        $(".pageUpdate").click(function () {
            $.get("/EmpManager/UpdateEmpPlushServlet", {id : $(this).attr('empID')},
                function (data) {
                    alert("Data Loaded: " + data );
                });
        })
    })
</script>
</html>
