<%@page import="java.util.LinkedList"%>
<%@page import="com.netcracker.dto.Employee"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<body bgcolor="pink">
	<table align="center" border="5" cellpadding="5" cellspacing="10">
		<tr>
			<th>Emp_ID</th>
			<th>Emp_NAME</th>
			<th>Emp_SALARY</th>
			<th>Option1</th>
			<th>Option2</th>
			
		</tr>
				<c:forEach items="${list }" var="emp">
				
				<tr>
				<td>${emp.id}</td>
				<td>${emp.name}</td>
				<td>${emp.salary}</td>
				<td><a href="EmployeeController?action=DELETE&eid=${emp.id }">DELETE</a></td>
				<td><a href="UpdateEmployee.jsp?action=UPDATE&eid=${emp.id }&name=${emp.name}&salary=${emp.salary}">UPDATE</a></td>
				</tr>
				
				</c:forEach>
				

	</table>

</body>
</html>