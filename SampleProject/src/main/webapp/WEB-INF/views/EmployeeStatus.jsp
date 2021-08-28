<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3>WELCOME TO EMPLOYEE DATA PAGE</h3>
	
	<table border=1>
	<tr>
	<th>ID</th>
	<th>NAME</th>
	<th>STATUS</th>
	<th>EMAIL</th>
	<th>SALARY</th>
	
	<c:forEach items="${list}" var="ob">
	<tr>
	<td><c:out value="${ob.id}"/></td>
	<td><c:out value="${ob.name}"/></td>
	<td><c:out value="${ob.status}"/></td>
	<td><c:out value="${ob.email}"/></td>
	<td><c:out value="${ob.salary}"/></td>
	</tr>
	</c:forEach>
	</table>
    <a href="excel">Download Excel Data</a>
	
</body>
</html>