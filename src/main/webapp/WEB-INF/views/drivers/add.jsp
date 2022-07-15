<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Add a driver</title>
    <link rel="stylesheet" href="/css/styles.css" type="text/css"/>
</head>
<body>
<jsp:include page="/WEB-INF/views/header.jsp"/>
<h2>Add a driver</h2>
<form method="post" action="${pageContext.request.contextPath}/drivers/add">
    <label><span>Name</span></label>
    <input required class="text_field" type="text" name="name">
    <label><span>License number</span></label>
    <input required class="text_field" type="text" name="license_number">
    <label><span>Login</span></label>
    <input required class="text_field" type="text" name="login">
    <label><span>Password</span></label>
    <input required class="text_field" type="password" name="password">
    <button class="submit_button" type="submit">Confirm</button>
</form>
</body>
</html>
