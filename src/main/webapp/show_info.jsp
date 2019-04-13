<%@ page import="java.util.List" %>
<%@ page import="entity.User" %><%--
  Created by IntelliJ IDEA.
  User: HoleLin
  Date: 2019/4/13
  Time: 17:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<html>
<head>
    <title>Welcome</title>
</head>
<body>
<table border="1" align="center" style="margin-top: 200px">
    <tr>
        <td>用户名</td>
        <td>密码</td>
        <td>昵称</td>
        <td>邮箱</td>
        <td>操作</td>
    </tr>
    <c:forEach var="user" items="${userList}">
        <tr>
            <td><c:out value="${user.userName}"/></td>
            <td><c:out value="${user.passWord}"/></td>
            <td><c:out value="${user.nickName}"/></td>
            <td><c:out value="${user.email}"/></td>
            <td>
                <a href="TransitServlet?username=<c:out value="${user.userName}"/>">修改</a>
                <a href="DeleteUserServlet?username=<c:out value="${user.userName}"/>">删除</a>
            </td>
        </tr>
    </c:forEach>
    <tr>
        <td><a href="register.jsp?tag=add">增加</a></td>
    </tr>
</table>

</body>
</html>
