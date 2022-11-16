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
    <title>Add Event</title>
   	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/style2.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<h1>Add project</h1>
  <br>
	<form:form action="/newevent" method="post" modelAttribute="event">
			<form:input type="hidden" path="user" value="${user.id }"/>
	
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
					<form:label path="dueDate">dueDate</form:label>
					<form:input type="date" class="form-control" path="dueDate"/>
					<form:errors path="dueDate" class="red"/>
					
				</td>
			</tr>
		     <tr>
                    <td><p>State</p></td>
						<td>	<form:select path="state" style="width:100%; margin-left:-100%;">  
							        <form:option value="Asia" label="Asia"/>  
							        <form:option value="Africa" label="Africa"/>  
							        <form:option value="NorthAmerica" label="NorthAmerica"/>  
							        <form:option value="SouthAmerica" label="SouthAmerica"/>  
							        <form:option value="Antarctica" label="Antarctica"/> 
							        <form:option value="Europe" label="Europe"/> 
							        <form:option value="Australia" label="Australia"/> 
							        </form:select> 
						</td>
                            <td> <form:errors path="state" class="text-danger"/> </td>
                    
                </tr>
				<tr>
				<td>
					<form:label  path="location">location</form:label>
					<form:input  class="form-control" path="location"/>
					<form:errors path="location" class="red"/>
					
				</td>
			</tr>
			<tr>
				<td>
					<form:label  path="capcity">capcity</form:label>
					<form:input  class="form-control" path="capcity"/>
					<form:errors path="capcity" class="red"/>
					
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