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
	<a href="/dashboard">Go Back</a>
	</div>
	
	<div class="flex1">
		<div>
		<table class="table" style="width:30%;">

    <thead>
        <tr>
            <th>Name</th>
            <th>Location</th>
         
        </tr>
    </thead>
   <tbody>
      	 <c:forEach var="event" items="${event2}">
    	<tr>
        <td><c:out value="${event.name}"></c:out></td>
        <td><c:out value="${event.location}"></c:out></td>
		</c:forEach>
       
    
    </tbody>
	</table>
		</div>
		</div>
</body>
</html>