<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1256">
<title>Insert title here</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/style.css"/>
</head>
<body>
	<div class="search">
		<div>
			<a href="/add">Add New</a>
			<a href="/thetop">Top Songs</a>
		</div>
		
		<form action="/search" method="post">
			<input type="text" name="search" >
			<input type="submit" value="Search By Artists">
		</form>
	</div>
	
	<table class="tb1">
    <thead>
        <tr>
            <th>Name</th>
            <th>Rating</th>
            <th>Actions</th>
        </tr>
    </thead>
    <tbody>	
        <c:forEach var="lookify" items="${lookify}">
    	<tr>
        <td><a href="/lang/${lookify.id }"> <c:out value="${lookify.title}"></c:out></a></td>
        <td><c:out value="${lookify.rating}"></c:out> </td>        
        <td> <form action="/delete/${lookify.id}" method="post">
    	<input type="hidden" name="_method" value="delete">
    	<input type="submit" value="Delete">
		</form>
		</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>