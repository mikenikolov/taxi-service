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
    <h3>Driver information</h3>
    <label><span>ID</span><c:out value="${driver.id}"/></label>
    <br><br>
    <label><span>Name</span><c:out value="${driver.name}"/></label>
    <br><br>
    <label><span>License</span><c:out value="${driver.licenseNumber}"/></label>
    <br><br>
    <label><span>Login</span><c:out value="${driver.login}"/></label>
    <br><br>
    <h3>List of your cars</h3>
  </c:when>
  <c:otherwise>
    <h3>List of all cars</h3>
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
              ID: <c:out value="${driver.id}"/>,
              Login: <c:out value="${driver.login}"/>,
              License: <c:out value="${driver.licenseNumber}"/>
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
