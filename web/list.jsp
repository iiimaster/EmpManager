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

<div id="udiv" style="display: none">
    <br><hr>
    <h2 align="center">本页修改</h2>
    <br>
    <div align="center" >
        编号:<input id="uid" type="text" readonly/>&nbsp;
        名称:<input id="uname" type="text"/>&nbsp;
        年龄:<input id="uage" type="text"/>&nbsp;
        性别:<input class="usex" name="usex" type="radio" value="1"/>男&nbsp;
        <input class="usex" name="usex" type="radio" value="0"/>女&nbsp;&nbsp;
        薪资:<input id="usalary" type="text"/><br><br>

        <input id="updateSubmit" type="button" value="确定"/>
        <input id="reset" type="button" value="取消"/>
    </div>
    <br><br><br><hr>
</div>


</body>
<script>
    $(function () {
        // 展现要修改的数据
        $(".pageUpdate").click(function () {
            $.get("/EmpManager/UpdateEmpPlushServlet", {id : $(this).attr('empID')},
                function (data) {
                    var str = data.split(",");
                    // alert(str)
                    $("#uid").val(str[0].split("-")[1]);
                    $("#uname").val(str[1].split("-")[1]);
                    $("#uage").val(str[2].split("-")[1]);
                    // $(".usex").val(str[3].split("-")[1]);
                    $(":radio").each(function () {
                        if (str[3].split("-")[1] == $(this).val()){
                            $(this).attr("checked","checked")
                        }
                    })
                    $("#usalary").val(str[4].split("-")[1]);

                    // 当要点击本页修改时显示修改页面
                    $("#udiv").show();
                });
        })

        // 提交修改的数据
        $("#updateSubmit").click(function () {
            $.get("/EmpManager/updateSubmitEmpPlushServlet",
                {uid : $("#uid").val(),
                    uname : $("#uname").val(),
                    uage : $("#uage").val(),
                    usex : $(":radio").val(),
                    usalary : $("#usalary").val()
                },
                function (data) {
                    // alert(data);
                    if (data == "1"){
                        alert("修改成功");
                        window.location.href="/EmpManager/ListEmpServlet";
                    }
                    if (data == "0") {
                        alert("修改失败")
                    }
                });
        })

        $("#reset").click(function () {
            window.location.href="/EmpManager/ListEmpServlet";
        })
    })
</script>
</html>
