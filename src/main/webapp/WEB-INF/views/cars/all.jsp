<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
  <c:choose>
    <c:when test="${driver != null}">
    <title>My profile</title>
    </c:when>
    <c:otherwise>
      <title>All cars</title>
    </c:otherwise>
  </c:choose>
  <link rel="stylesheet" href="/css/styles.css" type="text/css"/>
</head>
<body>
<jsp:include page="/WEB-INF/views/header.jsp"/>
<c:choose>
  <c:when test="${driver != null}">
    <h2>Driver information</h2>
    <label><span>ID</span>${driver.id}</label>
    <br><br>
    <label><span>Name</span>${driver.name}</label>
    <br><br>
    <label><span>License</span>${driver.licenseNumber}</label>
    <br><br>
    <label><span>Login</span>${driver.login}</label>
    <br><br>
    <h2>List of your cars</h2>
  </c:when>
  <c:otherwise>
    <h2>List of all cars</h2>
    <a class="nav-under" href="${pageContext.request.contextPath}/cars/add">Add a car</a>
    <br><br>
  </c:otherwise>
</c:choose>
<table class="list">
  <tr class="table-header">
    <td style="min-width: 20px">ID</td>
    <td style="min-width: 130px">Manufacturer</td>
    <td style="min-width: 100px">Model</td>
    <td style="min-width: 120px">Drivers</td>
    <td style="min-width: 140px">Drivers manage</td>
    <td>Action</td>
  </tr>
  <c:forEach items="${cars}" var="car">
    <tr>
      <td style="min-width: 20px"><c:out value="${car.id}"/></td>
      <td style="min-width: 130px"><c:out value="${car.manufacturer.name}"/></td>
      <td style="min-width: 100px"><c:out value="${car.model}"/></td>
      <td style="min-width: 120px">
        <select style="width: 340px; font-family: 'Work Sans', sans-serif">
          <option>Show all drivers...</option>
          <c:forEach items="${car.drivers}" var="driver">
            <option disabled>
              ID: ${driver.id}, Login: ${driver.login}, License: ${driver.licenseNumber}
            </option>
          </c:forEach>
        </select>
      </td>
      <td style="min-width: 140px">
        <a class="add" href="${pageContext.request.contextPath}/cars/drivers/add?id=${car.id}">Add</a>
        <a class="remove" href="${pageContext.request.contextPath}/cars/drivers/remove?id=${car.id}">Remove</a>
      </td>
      <td style="min-width: 65px">
        <a class="delete" href="${pageContext.request.contextPath}/cars/delete?id=${car.id}">Delete</a>
      </td>
    </tr>
  </c:forEach>
</table>
</body>
</html>
