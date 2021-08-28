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
	<table>
		<tr>
			<td><form:select path="">
				<form:option value=""></form:option>
				<form:options items="${list}" itemLabel="status" itemValue=""/>
				</form:select></td>
		</tr>
	</table>
</body>
</html>