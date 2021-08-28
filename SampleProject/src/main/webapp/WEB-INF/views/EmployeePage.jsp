<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3>WELCOME TO EMPLOYEE PAGE</h3>
	<form:form action="save" method="POST" enctype="multipart/form-data" modelAttribute="employee">
		<table border="1">
			<tr>
				<td>EMPLOYEE NAME</td>
				<td><form:input path="name" /></td>
			</tr>
			<tr>
				<td>EMPLOYEE STATUS</td>
				<td><form:select path="status">
						<form:option value="">--SELECT--</form:option>
						<form:option value="active">ACTIVE</form:option>
						<form:option value="inactive">INACTIVEK</form:option>
						<form:option value="fultime">FULTIME</form:option>
						<form:option value="parttime">PARTTIME</form:option>
					</form:select></td>
			</tr>
			<tr>
				<td>EMPLOYEE EMAIL</td>
				<td><form:input path="email" /></td>
			</tr>
			<tr>
				<td>EMPLOYEE SAL</td>
				<td><form:input path="salary" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="SUBMIT" /></td>
			</tr>
		</table>
	</form:form>
	${msg}
	${message}
	<a href="get">view all</a>
</body>
</html>