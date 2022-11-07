<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1256">
<title>Insert title here</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/style.css"/>
</head>
<body>
	<h2>New Category</h2>
	<a href="/">Home</a>
	<form:form action="/addcat" method="post" modelAttribute="categorie">
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