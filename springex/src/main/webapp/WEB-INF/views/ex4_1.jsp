<%--
  Created by IntelliJ IDEA.
  User: gonikim
  Date: 2024-07-20
  Time: 오후 1:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%-- JSP에서는 별도의 처리 없이 이용 가능 --%>
    <%-- ${}의 변수명은 타입의 앞글자만 소문자로 변경되어서 처리됨 --%>
    <h1>${todoDTO}</h1>

    <%-- @ModelAttribute 적용 시 --%>
    <h1>${dto}</h1>
</body>
</html>
