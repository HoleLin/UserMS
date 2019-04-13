<%--
  Created by IntelliJ IDEA.
  User: HoleLin
  Date: 2019/4/13
  Time: 17:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="AddUserServlet" method="POST">
    <table align="center" style="margin-top: 200px">
        <tr>
            <td>UserName</td>
            <td><input type="text" name="userName"/></td>
        </tr>
        <tr>
            <td>PassWord</td>
            <td><input type="password" name="passWord"/></td>
        </tr>
        <tr>
            <td>NickName</td>
            <td><input type="text" name="nickName"/></td>
        </tr>
        <tr>
            <td>Email</td>
            <td><input type="text" name="email"/></td>
        </tr>
        <tr>
            <td><input type="submit" value="提交"/></td>
        </tr>
        <input type="hidden" name="tag" value="${param.tag}">
    </table>
</form>
</body>
</html>
