<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Project</title>
   	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/style2.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <style>
    
    	body {
    			
    		background-color: #d5a6bd;
    	
    	}
    
    </style>
</head>
<body>
<h2> Project: ${project.title}</h2>
<h3>Project lead: ${user.userName}</h3>

<a href="/dashboard">Back to DashBoard</a>
  <br>
	<form:form action="/newtask" method="post" modelAttribute="project">
			<form:input type="hidden" path="users" value="${user.id }"/>
			<form:input type="hidden" path="projects" value="${project.id }"/>
			
	
		<table>
			<tr>
				<td>
					<form:label path="title">Add Task ticket</form:label>
					<form:textarea path="title" class="form-control" />
					<form:errors path="title" class="red"/>
				</td>
			</tr>
			
			<tr>
				<td>
					<input type="submit" class="form-control" value="Send">
				</td>
			</tr>
		
		</table>
		<br>
		<hr>
		
		<br>
		<br>
		 <c:forEach var="task" items="${Tasks}">
    			<c:choose>
    			<c:when test="${task.projects.id == project.id}">
      			<h4>Added by <c:out value="${task.getUsers().userName}"></c:out>  at <fmt:formatDate pattern="hh:mma MMM dd" value="${task.getCreatedAt()}" /> :</h4>
        		<p><c:out value="${task.title}"></c:out> 
        		 </c:when>    
   				 </c:choose>
    	</c:forEach>
		

</form:form>
</body>
</html>