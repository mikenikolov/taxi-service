<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Remove a driver</title>
  <link rel="stylesheet" href="/css/styles.css" type="text/css"/>
</head>
<body>
<jsp:include page="/WEB-INF/views/header.jsp"/>
<h2>Remove a driver from car</h2>
<form method="post" action="${pageContext.request.contextPath}/cars/drivers/remove?id=${car.id}">
  <h3>Car's information</h3>
  <label><span>ID</span>${car.id}</label>
  <br><br>
  <label><span>Country</span>${car.manufacturer.country}</label>
  <br><br>
  <label><span>Name</span>${car.manufacturer.name}</label>
  <br><br>
  <label><span>Model</span>${car.model}</label>
  <br><br>
  <label><span>Drivers</span></label>
  <select required style="width: 340px; font-family: 'Work Sans', sans-serif; margin-bottom: 15px" name="drivers">
    <option selected disabled value="">Select one of driver</option>
    <c:forEach items="${drivers}" var="driver">
      <option value="${driver.id}">ID: ${driver.id}, Name: ${driver.name}, License: ${driver.licenseNumber}</option>
    </c:forEach>
  </select>
  <button class="submit_button" type="submit">Confirm a remove</button>
</form>
</body>
</html>
