<%--
  Created by IntelliJ IDEA.
  User: gonikim
  Date: 2024-07-20
  Time: 오후 1:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%-- Model에 담긴 데이터는 내부적으로 HttpServletRequest의 setAttribute()와 동일한 동작을 수행하기 때문에
        JSP에서는 EL을 이용해서 별다른 처리없이 바로 사용할 수 있음 --%>
    <h1>${message}</h1>

    <h1><c:out value="${message}"></c:out></h1>
</body>
</html>
