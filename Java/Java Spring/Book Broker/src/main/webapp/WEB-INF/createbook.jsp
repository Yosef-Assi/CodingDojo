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
    <title>Add Book</title>
   	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/style2.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<h1>Add Book</h1>
  <br>
	<form:form action="/newbook" method="post" modelAttribute="book">
			<form:input type="hidden" path="user" value="${user.id }"/>
	
		<table>
			<tr>
				<td>
					<form:label path="title">title</form:label>
					<form:input path="title" class="form-control"/>
					<form:errors path="title" class="red"/>
				</td>
			</tr>
			<tr>
				<td>
					<form:label path="author">author</form:label>
					<form:input class="form-control" path="author"/>
					<form:errors path="author" class="red"/>
					
				</td>
			</tr>
			<tr>
				<td>
					<form:label  path="myThoughts">myThoughts</form:label>
					<form:input class="form-control" path="myThoughts"/>
					<form:errors path="myThoughts" class="red"/>
					
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