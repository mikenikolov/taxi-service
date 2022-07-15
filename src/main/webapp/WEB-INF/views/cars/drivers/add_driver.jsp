<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Add a driver to car</title>
    <link rel="stylesheet" href="/css/styles.css" type="text/css"/>
</head>
<body>
<jsp:include page="/WEB-INF/views/header.jsp"/>
<h2>Add a driver to car</h2>
<form method="post" action="${pageContext.request.contextPath}/cars/drivers/add?car_id=${car.id}">
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
    <select style="width: 340px; font-family: 'Work Sans', sans-serif; margin-bottom: 15px" name="driver_id" required>
        <option selected disabled value="">Select one of driver</option>
        <c:forEach items="${drivers}" var="driver">
            <c:choose>
                <c:when test="${currentCarDrivers.contains(driver)}">
                    <option disabled value="${driver.id}">ID: ${driver.id}, Name: ${driver.name}, License: ${driver.licenseNumber}</option>
                </c:when>
                <c:otherwise>
                    <option value="${driver.id}">ID: ${driver.id}, Name: ${driver.name}, License: ${driver.licenseNumber}</option>
                </c:otherwise>
            </c:choose>
        </c:forEach>
    </select>
    <button class="submit_button" type="submit">Confirm</button>
</form>
</body>
</html>
