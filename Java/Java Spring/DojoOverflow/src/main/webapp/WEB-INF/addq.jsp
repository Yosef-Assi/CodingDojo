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
<meta charset="windows-1256">
<title>Insert title here</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/style.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>

<h2>What is your question?</h2>

<form action="/add" method="post">
		<table>
			<tr>
				<td><label id="question">Question</label></td>
			
				<td><input type="text" class="form-control" name="question"></td>
			</tr>
			<tr>
				<td><label id="question">Tag</label></td>
				<td><input type="text" class="form-control" name="tag"></td>
			</tr>
			<tr>
				<td>
					<input type="submit" class="form-control" value="Create">
				</td>
			</tr>
		
		</table>

</form>

</body>
</html>