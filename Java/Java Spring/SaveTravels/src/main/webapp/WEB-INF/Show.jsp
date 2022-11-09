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
<link rel="stylesheet" href="/css/style2.css"/>
</head>
<body>

	<form:form action="/edit/${expense.id}" method="post" modelAttribute="expense">
	<input type="hidden" name="_method" value="put">
	<div class="flex">
		<h2>Edit an expense</h2>
		<a href="/">Go back</a>
	</div>
		<table>
			<tr>
				<td>
					<form:label path="name">Enter Name of expense</form:label>
					<form:input path="name" class="form-control"/>
					<form:errors path="name" class="red"/>
				</td>
			</tr>
			<tr>
				<td>
					<form:label path="vendor">Enter vendor of expense</form:label>
					<form:input class="form-control" path="vendor"/>
					<form:errors path="vendor" class="red"/>
					
				</td>
			</tr>
			<tr>
				<td>
					<form:label  path="amount">Enter amount of expense</form:label>
					<form:input class="form-control" path="amount"/>
					<form:errors path="amount" class="red"/>
					
				</td>
			</tr>
				<tr>
				<td>
					<form:label  path="description">Enter Desc</form:label>
					<form:textarea path="description"></form:textarea>
					<form:errors path="description" class="red"/>
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