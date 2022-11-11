<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1256">
<title>Insert title here</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/style2.css"/>	
</head>
<body>
	<div class="flex">
	<h2>Project Details</h2>
	<a href="/dashboard">Go Back</a>
	</div>
	<br>
	<table>
	<tr>
		<td>
			<p> Project : </p>
		</td>
		<td>${project.title}</td>
	</tr>
	<tr>
		<td>
			<p>Description : </p>
		</td>
		<td> ${project.description }</td>
	</tr>
	<tr>
		<td>
			<p>Due Date : </p>
		</td>
		<td>${project.dueDate }</td>
	</tr>
	
	</table>
	<br>
	<a href="/gettask/${project.id}">See Tasks</a>
</body>
</html>