<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<table class="nav">
  <tr>
    <c:choose>
      <c:when test="${isLoggedIn == true}">
        <td><a class="logout" href="${pageContext.request.contextPath}/logout">Logout</a></td>
        <td><a class="nav-link" href="${pageContext.request.contextPath}/drivers">Drivers</a></td>
        <td><a class="nav-link" href="${pageContext.request.contextPath}/manufacturers">Manufacturers</a></td>
        <td><a class="nav-link" href="${pageContext.request.contextPath}/cars">Cars</a></td>
        <td><a class="nav-link" href="${pageContext.request.contextPath}/profile">My profile</a></td>
      </c:when>
      <c:otherwise>
        <td><a class="nav-link" href="${pageContext.request.contextPath}/login">Login page</a></td>
        <td><a class="nav-link" href="${pageContext.request.contextPath}/drivers/register">Register a driver</a></td>
      </c:otherwise>
    </c:choose>
  </tr>
</table>
