<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1256">
<title>Edit</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/style2.css"/>
</head>
<body>
<div class="flex">
		<h2>Edit Language</h2>
		<a href="/">Go back</a>
		<form action="/delete/${language.id}" method="post">
	    	<input type="hidden" name="_method" value="delete">
	    	<input type="submit" value="Delete">
    	</form>
	</div>
	
	<form:form action="/edit/${language.id}" method="post" modelAttribute="language">
	<input type="hidden" name="_method" value="put">
	
		<table>
			<tr>
				<td>
					<form:label path="name">Language</form:label>
					<form:input path="name" class="form-control"/>
					<form:errors path="name" class="red"/>
				</td>
			</tr>
			<tr>
				<td>
					<form:label path="creator">Creator</form:label>
					<form:input class="form-control" path="creator"/>
					<form:errors path="creator" class="red"/>
					
				</td>
			</tr>
			<tr>
				<td>
					<form:label  path="version">Version</form:label>
					<form:input class="form-control" path="version"/>
					<form:errors path="version" class="red"/>
					
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