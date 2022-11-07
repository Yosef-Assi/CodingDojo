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
	<h2>New Product</h2>
		<a href="/">Home</a>
	
	<form:form action="/add" method="post" modelAttribute="product">
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
					<form:label path="description">Description</form:label>
					<form:input path="description" class="form-control"/>
					<form:errors path="description" class="red"/>
				</td>
			</tr>
			<tr>
				<td>
					<form:label path="price">price</form:label>
					<form:input path="price" class="form-control"/>
					<form:errors path="price" class="red"/>
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