<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Error!!!</title>
</head>
<body>
<c:set value="${exception }" var="e"></c:set>
<c:catch var="e" >
		<p>	
			<font color="red">Error message is: ${e.message }</font>

		</p>

</c:catch>
<br>
<a href="EmployeeHome.html">GO BACK</a>

</body>
</html>