<%--
  Created by IntelliJ IDEA.
  User: G201
  Date: 2024-07-15
  Time: 오후 3:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <c:if test="${param.result == 'error'}">
        <h1>로그인 에러</h1>
    </c:if>

    <form action="/login" method="post">
        <input type="text" name="mid">
        <input type="password" name="mpw">
        <button type="submit">LOGIN</button>
    </form>
</body>
</html>
