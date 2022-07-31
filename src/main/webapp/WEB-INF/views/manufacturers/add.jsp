<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Add a manufacturer</title>
    <link rel="stylesheet" href="/css/styles.css" type="text/css"/>
</head>
<body>
<jsp:include page="/WEB-INF/views/header.jsp"/>
<h2>Add a manufacturer</h2>
<form method="post" action="${pageContext.request.contextPath}/manufacturers/add">
    <label><span>Name</span></label>
    <input maxlength="45" required class="text_field" type="text" name="name">
    <label><span>Country</span></label>
    <input maxlength="45" required class="text_field" type="text" name="country">
    <button class="submit_button" type="submit">Confirm</button>
</form>
</body>
</html>
