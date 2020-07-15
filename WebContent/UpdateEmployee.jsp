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
<form action="EmployeeController">
		<table align="center" border="5" cellpadding="5" cellspacing="10">
			<tr>
				<td>Enter Employee ID :</td>  
				<td><input type="number" name="eid"  value="${param.eid}" readonly="readonly"></td>
			</tr>
			<tr>
				<td>Enter Employee Name :</td> 
				<td><input type="text" name="name" value="${param.name}"></td>
			</tr>
			<tr>
				<td>Enter Employee Salary :</td> 
				<td><input type="number" name="salary" value="${param.salary}"></td>
			</tr>
			<tr>
				
				<td><input type="submit" value="UPDATE" name="action"></td>
			</tr>
		</table>
	</form>


</body>
</html>