<%--
  Created by IntelliJ IDEA.
  User: G201
  Date: 2024-07-05
  Time: 오후 4:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%--    <form action="calcResult.jsp" method="post">--%>
<%--        <input type="number" name="num1">--%>
<%--        <input type="number" name="num2">--%>
<%--        <button type="submit">SEND</button>--%>
<%--    </form>--%>

    <form action="/calc/makeResult" method="post">
        <input type="number" name="num1">
        <input type="number" name="num2">
        <button type="submit">SEND</button>
    </form>
</body>
</html>
