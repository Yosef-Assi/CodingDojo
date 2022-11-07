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
    <title>Add Ninja</title>
   	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<h1>Add Ninja</h1>
  <br>
	<form:form action="/newninja" method="post" modelAttribute="ninja">
		<table>
			<tr>
				<td>
					<form:select path="dojo" class="form-control">
						<c:forEach var="dojos" items="${alldojos }">
								<option value="${dojos.id }">${dojos.name }</option>
						</c:forEach>
					</form:select>
				</td>
			</tr>
			<tr>
				<td>
					<form:label path="firstName">first_name</form:label>
					<form:input path="firstName" class="form-control"/>
					<form:errors path="firstName" class="red"/>
				</td>
			</tr>
			<tr>
				<td>
					<form:label path="lastName">last_name</form:label>
					<form:input class="form-control" path="lastName"/>
					<form:errors path="lastName" class="red"/>
					
				</td>
			</tr>
			<tr>
				<td>
					<form:label  path="age">age</form:label>
					<form:input class="form-control" path="age"/>
					<form:errors path="age" class="red"/>
					
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