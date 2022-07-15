<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Login page</title>
    <link rel="stylesheet" href="/css/styles.css" type="text/css"/>
</head>
<body>
<h2>Taxi Service</h2>
<%@include file='/WEB-INF/views/header.jsp' %>
<h4 style="color: red">${errorMsg}</h4>
<form method="post" action="${pageContext.request.contextPath}/login">
    <label><span>Login</span></label>
    <input required type="text" name="login">
    <label><span>Password</span></label>
    <input required type="password" name="password">
    <button class="submit_button" type="submit">Login</button>
</form>
</body>
</html>
