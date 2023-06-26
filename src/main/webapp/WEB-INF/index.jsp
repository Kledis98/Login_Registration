<%--
  Created by IntelliJ IDEA.
  User: dejvi
  Date: 6/25/2023
  Time: 6:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<html>
<head>
    <title>Home</title>
</head>
<body>

<h1>Welcome!</h1>
<p>Join our growing community</p>

<form:form  action="/register" method="post" modelAttribute="newUser"  >
        <h2>Register</h2>
    <div>
    <form:label path="userName">Username: </form:label>
    <form:input path="userName" />
    <form:errors path="userName"/>
    </div>
    <div>
        <form:label path="email">Email: </form:label>
        <form:input path="email" />
        <form:errors path="email"/>
    </div>
    <div>
        <form:label path="password">Password: </form:label>
        <form:input path="password" type="password" />
        <form:errors path="password"/>
    </div>
    <div>
        <form:label path="confirm">Confirm password: </form:label>
        <form:input path="confirm" type="password" />
        <form:errors path="confirm"/>
    </div>

    <button>Submit!</button>


</form:form>

<br>

<form:form action="/login" method="post" modelAttribute="newLogin">
    <h2>Log In</h2>

    <div>
        <form:label path="email">Email: </form:label>
        <form:input path="email" />
        <form:errors path="email"/>
    </div>
    <div>
        <form:label path="password">Password: </form:label>
        <form:input path="password" type="password" />
        <form:errors path="password"/>
    </div>

    <button>Submit!</button>

</form:form>

</body>
</html>
