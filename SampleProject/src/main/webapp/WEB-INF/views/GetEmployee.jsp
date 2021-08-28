<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>WELCOME TO EMPLOYEE ONE PAGE</h2>
<table>
<tr>
<th>ID</th>
<th>NAME</th>
<th>STATS</th>
<th>EMAIL</th>
<th>SALARY</th>
</tr>
<tr>
<td>${list.id}</td>
<td>${list.name}</td>
<td>${list.status}</td>
<td>${list.email}</td>
<td>${list.salary}</td>
<tr>
</table>

</body>
</html>