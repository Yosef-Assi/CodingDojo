<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
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
	<div class="flex">
	<h2>Language Details</h2>
	<a href="/">Go Back</a>
	</div>
	<br>
	<table>
	<tr>
		<td>
			<p> Name : </p>
		</td>
		<td>${language.name}</td>
	</tr>
	<tr>
		<td>
			<p>Creator : </p>
		</td>
		<td> ${language.creator }</td>
	</tr>
	<tr>
		<td>
			<p>Version : </p>
		</td>
		<td>${language.version }</td>
	</tr>
	
	</table>
	<a href="/edit/${language.id}">Edit</a>
	<form action="/delete/${language.id}" method="post">
    	<input type="hidden" name="_method" value="delete">
    	<input type="submit" value="Delete">
		</form>
</body>
</html>