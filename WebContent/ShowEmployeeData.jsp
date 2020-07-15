<%@page import="com.netcracker.dto.Employee"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="pink">
	<table align="center" border="5" cellpadding="5" cellspacing="10">
		<tr>
			<th>Emp_ID</th>
			<th>Emp_NAME</th>
			<th>Emp_SALARY</th>
			
			<c:set value="${employee }" var="emp"></c:set>
				
			<tr>
				<td>${emp.id}</td>
				<td>${emp.name}</td>
				<td>${emp.salary}</td>
				</tr>
	
		

	</table>

</body>
</html>