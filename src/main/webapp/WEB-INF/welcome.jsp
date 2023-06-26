<%--
  Created by IntelliJ IDEA.
  User: dejvi
  Date: 6/25/2023
  Time: 6:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<html>
<head>
    <title>Welcome Page</title>
</head>
<body>
<h1>Welcome, <c:out value="${user.userName}"></c:out> ! </h1>

<p>This is your dashboard. Nothing to see here yet.</p>


<p><a href="/logout"   >Logout</a></p>
</body>
</html>
