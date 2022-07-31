<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Add a car</title>
  <link rel="stylesheet" href="/css/styles.css" type="text/css"/>
</head>
<body>
<jsp:include page="/WEB-INF/views/header.jsp"/>
<h2>Add a car</h2>
<form method="post" action="${pageContext.request.contextPath}/cars/add">
  <label><span>Manufacturer</span></label>
  <select style="width: 250px; font-family: 'Work Sans', sans-serif; margin-bottom: 15px" name="manufacturer_id" required>
    <option selected disabled value="">Select one of manufacturers</option>
    <c:forEach items="${manufacturers}" var="manufacturer">
      <option value="${manufacturer.id}">
        ID: <c:out value="${manufacturer.id}"/>,
        Name: <c:out value="${manufacturer.name}"/>,
        Country: <c:out value="${manufacturer.country}"/>
      </option>
    </c:forEach>
  </select>
  <label><span>Model</span></label>
  <input maxlength="45" required class="text_field" type="text" name="model">
  <button class="submit_button" type="submit">Confirm</button>
</form>
</body>
</html>
