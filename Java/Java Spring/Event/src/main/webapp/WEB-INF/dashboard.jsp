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
<title>Home Page</title>
 <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="/style2.css">
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	
	<div class="flex2">
		<h3>Welcome, ${user1.userName}</h3>
		<p>Your state is : ${user1.state}</p>
		<p><a href="/logout">logout</a></p>
	</div>
	<div class="flex2">
			<p>Show All events</p>
			
			<p><a href="/event">Add event</a></p>
	</div>

	<table class="tb1">

    <thead>
        <tr>
            <th>Name</th>
            <th>Date</th>
            <th>Location</th>
            <th>State</th>
            <th>Host</th>
            <th>Avg Rate</th>
            <th>Actions / Status</th>
        </tr>
    </thead>
   <tbody>

   
        <c:forEach var="event" items="${events}">
        <c:choose>
        <c:when test="${user1.state == event.state}">
    	<tr>
        <td><a href="/show/event/${event.id }"><c:out value="${event.name}"></c:out></a> </td>
        <td><c:out value="${event.dueDate}"></c:out></td>
        <td><c:out value="${event.location}"></c:out></td>
        <td><c:out value="${event.state}"></c:out></td>
        
       
        <td><c:out value="${event.user.userName}"></c:out></td>
         <td><c:out value="${event.getAvgRate()}"></c:out></td>
        
        <td>
         <c:choose>
    		<c:when test="${event.user.id==user_id}">
       
     			<a href="edit/event/${event.id }">edit</a> || <a href="delete/event/${event.id}">Delete</a>
     			
		     	
		        <br />
		    </c:when> 
			     <c:when test="${user1.getEvents().contains(event)}">
	            	Joining ||	<a href="/leaveevent/${event.id}">Cancel</a>
	         	</c:when> 
		    <c:otherwise>
		    
        				<a href="/join/event/${event.id}">Join</a>
        <br />
   		 </c:otherwise>  
		</c:choose>
		</td>
        </c:when> 
        </c:choose>
		</c:forEach>
       
    
    </tbody>
	</table>
	<br>
	<hr>
	
	<br>
	
	<h2>Events another states</h2>
	<table class="tb1">

    <thead>
        <tr>
            <th>Name</th>
            
            <th>Date</th>
            <th>Location</th>
            <th>State</th>
            <th>Avg Rate</th>
            <th>Host</th>
            <th>How Many Joined</th>
            <th>Actions</th>
        </tr>
    </thead>
   <tbody>

   
        <c:forEach var="event" items="${events}">
        <c:choose>
        <c:when test="${user1.state != event.state}">
    	<tr>
        <td><a href="/show/event/${event.id }"><c:out value="${event.name}"></c:out></a> </td>
        <td><c:out value="${event.dueDate}"></c:out></td>
        <td><c:out value="${event.location}"></c:out></td>
       	<td><c:out value="${event.state}"></c:out></td>
        
       	<td><c:out value="${event.getAvgRate()}"></c:out></td>
        
        <td><c:out value="${event.user.userName}"></c:out></td>
        
         <c:choose>
        <c:when test="${event.getUsers().size() < event.capcity}">
        
        <td><c:out value="${event.getUsers().size()}"></c:out> / ${event.capcity }</td>
           </c:when>
         <c:otherwise>
          <td>this event is full!</td>
  		</c:otherwise>
  		  
         </c:choose>
         <td>
         <c:choose>
         <c:when test="${event.user.id==user_id}">
       
     			<a href="edit/event/${event.id }">edit</a> || <a href="delete/event/${event.id}">Delete</a>
     			
		     	
		        <br />
		    </c:when> 
          <c:when test="${user1.getEvents().contains(event)}">
	            	Joining ||	<a href="/leaveevent/${event.id}">Cancel</a>
	         	</c:when> 
		    <c:when test="${event.getUsers().size() < event.capcity}">
		    
        				<a href="/join/event/${event.id}">Join</a>
        <br />
   		 </c:when> 
   		 <c:otherwise>
          <td>You Cant Joined </td>
  		</c:otherwise>
  		   
         </c:choose>
         </td>

        </c:when> 
        </c:choose>
		</c:forEach>
       
    
    </tbody>
	</table>
	<form action="/search" method="post">
<%-- 			<form:input type="hidden" path="user" value="${user.id }"/> --%>
	
		<table>
			<tr>
				<td>
					<label id="name"> Search by Location</label>
					<input type="text" name="name" class="form-contro"/>
				</td>
			</tr>
			<tr>
				<td>
					<input type="submit" class="form-control" value="Send">
				</td>
			</tr>
		
		</table>

		
		
</form>
	
</body>
</html>