<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>

<html>
<head>
<meta charset="windows-1256">
<title>Insert title here</title>
 <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="/style2.css">
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	
	<div class="flex1">
		<h3>Welcome, ${user.userName}</h3>
		<p><a href="/logout">logout</a></p>
	</div>
	<div class="flex2">
			<p>Show All projects</p>
			
			<p><a href="/project">Add project</a></p>
	</div>

	<table class="tb1">

    <thead>
        <tr>
            <th>project</th>
            <th>team lead</th>
            <th>Due Date</th>
            <th>Actions</th>
            <th>Numbers users for this team</th>
        </tr>
    </thead>
   <tbody>
   <c:choose>
    <c:when test="${project.user.id != user_id}">
        <c:forEach var="project" items="${projects2}">
    	<tr>
        <td><a href="/showproject/${project.id }"><c:out value="${project.title}"></c:out></a> </td>
        <td><c:out value="${project.user.userName}"></c:out></td>
        <td><fmt:formatDate pattern="MMM dd" value="${project.dueDate}" /></td>
        
        
        <td><a href="/jointeam/${project.id }">Join Team</a></td>
        <td>${project.getUsers().size() }</td>
        
    </c:forEach>
    </c:when>    
    </c:choose>
    </tbody>
	</table>
	<br>
	<hr>
	
	<br>
	
	<h2>Your Projects</h2>
	<table class="tb1">

    <thead>
        <tr>
            <th>project</th>
            <th>team lead</th>
            <th>Due Date</th>
            <th>Actions</th>
        </tr>
    </thead>
   <tbody>
        <c:forEach var="project" items="${user.getProjects()}">
    	<tr>
        <td><a href="/getproject/${project.id }"><c:out value="${project.title}"></c:out></a> </td>
         <td><c:out value="${project.user.userName}"></c:out></td>
         <td><fmt:formatDate pattern="MMM dd" value="${project.dueDate}" /></td>
           <td>
        <c:choose>
    <c:when test="${project.user.id==user_id}">
       
     <a href="edit/project/${project.id }">edit</a>
     	
        <br />
    </c:when>    
    <c:otherwise>
        
    
       <a href="/LeaveTeam/${project.id}">Leave Team</a> 
        <br />
    </c:otherwise>
</c:choose>
      </td>
      <td>${project.getUsers().size() }</td>  
    </c:forEach>
    </tbody>
	</table>
	
</body>
</html>