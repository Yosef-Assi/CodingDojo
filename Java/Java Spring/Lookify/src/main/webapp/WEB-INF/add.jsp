<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1256">
<title>Display and Add</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/style.css"/>	
</head>
<body>
	
<br>
	<form:form action="/add" method="post" modelAttribute="yosef">
		<table>
			<tr>
				<td>
					<form:label path="title">Title</form:label>
					<form:input path="title" class="form-control"/>
					<form:errors path="title" class="red"/>
				</td>
			</tr>
			<tr>
				<td>
					<form:label path="artist">artist</form:label>
					<form:input class="form-control" path="artist"/>
					<form:errors path="artist" class="red"/>
					
				</td>
			</tr>
			<tr>
				<td>
					<form:label  path="rating">rating</form:label>
					<form:input class="form-control" path="rating"/>
					<form:errors path="rating" class="red"/>
					
				</td>
			</tr>
			<tr>
				<td>
					<input type="submit" class="form-control" value="Send">
				</td>
			</tr>
		
		</table>

</form:form>
</body>
</html>