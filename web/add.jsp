<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>EmaManager</title>
    <script src="jquery-3.4.0.js"></script>
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
<form method="get" action="/EmpManager/AddEmpServlet">
    <h2 align="center">添加员工</h2>
    <table align="center" width="500px" border="1" cellpadding="10px">

        <tr>
            <td align="center">姓名</td>
            <td>
                <input id="name" name="name" class="input-add">
                <span id="ViliNameMessage"></span>
            </td>
        </tr>
        <tr>
            <td align="center">年龄</td>
            <td><input name="age" class="input-add"></td>
        </tr>
        <tr>
            <td align="center">性别</td>
            <td>
                <input name="sex" type="radio" value="1">男
                <input name="sex" type="radio" value="0">女
            </td>
        </tr>
        <tr>
            <td align="center">薪资</td>
            <td><input name="salary" class="input-add" type="text"/></td>
        </tr>
        <tr>
            <td align="center" colspan="2">
                <input class="sub" style="margin-right: 50px" type="submit" value="添加">
                <input class="sub" style="margin-left: 50px" type="submit" value="取消">
            </td>
        </tr>
    </table>
</form>
</body>
<script>
    $(function () {
        $("#name").blur(function () { // 失去焦点时的事件
            // 判断用户是否已经录入系统：判断员工名称是否存在
            var name = $.trim($("#name").val());// 拿到前端输入的员工名称
            // alert(name)
            if (name != null && name != ""){
                $.get("/EmpManager/ViliNameServlet", {name : name},
                    function (data) {
                        // alert("Data Loaded: " + data );
                        $("#ViliNameMessage").text(data);
                        $("#ViliNameMessage").css("color","red"); // jquery添加样式

                    });
            }

        });
    });
</script>
</html>