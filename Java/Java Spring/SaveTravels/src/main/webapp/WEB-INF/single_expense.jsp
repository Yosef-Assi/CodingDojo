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
	<h2>Expense Details</h2>
	<a href="/">Go Back</a>
	</div>
	<br>
	<table>
	<tr>
		<td>
			<p>Expense Name : </p>
		</td>
		<td>${expense.name}</td>
	</tr>
	<tr>
		<td>
			<p>Expense Description : </p>
		</td>
		<td> ${expense.description }</td>
	</tr>
	<tr>
		<td>
			<p>Expense Vendor : </p>
		</td>
		<td>${expense.vendor }</td>
	</tr>
	<tr>
		<td>
			<p>Expense Amount : </p>
		</td>
		<td>$ ${expense.amount }</td>
	</tr>
		
	
	</table>
</body>
</html>