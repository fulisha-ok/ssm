<%--
  Created by IntelliJ IDEA.
  User: fulisha
  Date: 2020/2/8
  Time: 13:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
        <h1>查询所有账户信息</h1>
        <c:forEach items="${list}" var="list">
            ${list.username}
        </c:forEach>
</body>
</html>
