<%--
  Created by IntelliJ IDEA.
  User: HoleLin
  Date: 2019/4/13
  Time: 16:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="LoginServlet" method="POST">
    <table align="center" style="margin-top: 200px">
        <tr>
            <td>UserName</td>
            <td><input type="text" name="userName" value="admin"/></td>
        </tr>
        <tr>
            <td>PassWord</td>
            <td><input type="password" name="passWord" value="chen"/></td>
        </tr>
        <tr>
            <td><input type="submit" value="登录"/></td>
            <td><a href="register.jsp?tag=login">注册</a></td>
        </tr>
    </table>
</form>

</body>
</html>
