<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Tacos</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
   <br>
   		<h1>New Dojo</h1>
   
	<form:form action="/add" method="post" modelAttribute="dojo">
		<table>
			<tr>
				<td>
					<form:label path="name">name</form:label>
					<form:input path="name" class="form-control"/>
					<form:errors path="name" class="red"/>
				</td>
			</tr>
			<tr>
				<td>
					<input type="submit" class="form-control" value="Create">
				</td>
			</tr>
		
		</table>

</form:form>
</body>
</html>