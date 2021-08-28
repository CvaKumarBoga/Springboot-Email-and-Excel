<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3>WELCOME TO GET ONE EMPLOYEE DATA</h3>
	<form:form action="getone" method="POST" modelAttribute="">
	<table>
	<tr><td>ENTER A ID NUMBER</td></tr>
	<tr>
	<td><form:input path="text" value="id"/></td>
	<td><form:input path="submit" value="SEARCH"/></td>
	</tr>
	
	</table>
	</form:form>
</body>
</html>