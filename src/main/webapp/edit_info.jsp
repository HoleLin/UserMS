<%--
  Created by IntelliJ IDEA.
  User: HoleLin
  Date: 2019/4/13
  Time: 18:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>修改信息</title>
</head>
<body>
<form action="UpdateUserServlet">
    <table>
        <tr>
            <td>用户名:</td>
            <td><input type="text" name="userName" value="${user.userName}" readonly="readonly"/></td>
        </tr>
        <tr>
            <td>密码:</td>
            <td><input type="text" name="passWord" value="${user.passWord}"/></td>
        </tr>
        <tr>
            <td>昵称</td>
            <td><input type="text" name="nickName" value="${user.nickName}"/></td>
        </tr>
        <tr>
            <td>email</td>
            <td><input type="text" name="email" value="${user.email}"/></td>
        </tr>
        <tr>
            <td><input type="submit" value="提交"></td>
        </tr>
    </table>
</form>
</body>
</html>
