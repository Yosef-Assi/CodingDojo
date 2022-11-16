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
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/style2.css"/>	
</head>
<body>
	<div class="flex">
	<h2>${event.name } Details</h2>
	<a href="/dashboard">Go Back</a>
	</div>
	
	<div class="flex1">
		<div>
			<br>
			<table class="table" style="width:60%;">
			<tr>
				<td>
					<p> Host : </p>
				</td>
				<td>${event2.user.userName}</td>
			</tr>
			<tr>
				<td>
					<p>Date : </p>
				</td>
				<td>${event2.dueDate }</td>
			</tr>
			<tr>
				<td>
					<p>Location : </p>
				</td>
				<td> ${event2.location }</td>
			</tr>
				<tr>
				<td>
					<p>People who are attending this event  : </p>
				</td>
				<td> ${event2.getUsers().size() }</td>
			</tr>
			
			</table>
		</div>
		<div  class="t1">
			<h2>Message Wall</h2>
			
				
			
    		
       			<textarea rows="8" cols="40">
     			 <c:forEach var="msg" items="${messages}">
     			 <c:choose>
     			 <c:when test="${msg.event.id == event2.id}">
			       ${msg.users.userName} : ${msg.comment} 
			       -------------
			 	</c:when> 
			 	 </c:choose>
				</c:forEach>
			</textarea>
     			
		     	
		        <br />

		    
				
			
			<form:form action="/new/message" method="post" modelAttribute="message">
			<form:input type="hidden" path="users" value="${user.id }"/>
			<form:input type="hidden" path="event" value="${events.id }"/>
	
			<table  class="table">
			<tr>
				<td>
					<form:label path="comment">Add Comment</form:label>
					<form:textarea path="comment" class="form-control"></form:textarea>
					<form:errors path="comment" class="red"/>
				</td>
				<tr>
				<td>
					<input type="submit" class="form-control" value="Send">
				</td>
			</tr>
		</table>

</form:form>
			
		</div>
	</div>
	
	<table class="table" style="width:30%;">

    <thead>
        <tr>
            <th>Name</th>
            <th>Location</th>
         
        </tr>
    </thead>
   <tbody>
      	 <c:forEach var="event" items="${event2.getUsers()}">
    	<tr>
        <td><c:out value="${event.userName}"></c:out></td>
        <td><c:out value="${event.location}"></c:out></td>
		</c:forEach>
       
    
    </tbody>
	</table>
	
			<form:form action="/new/rate/${events.id }" method="post" modelAttribute="rate">
			<input type="hidden" name="_method" value="put">
			<form:input type="hidden" path="user" value="${user.id }" />
			<form:input type="hidden" path="event" value="${events.id }"/>
	
			<table  class="table">
			<tr>
				<td>
					<form:label path="rate">Add Rate</form:label>
					<form:input path="rate" type="number" class="form-control"/>
					<form:errors path="rate" class="red"/>
				</td>
				<tr>
				<td>
					<input type="submit" class="form-control" value="Send">
				</td>
			</tr>
		</table>

</form:form>
</body>
</html>