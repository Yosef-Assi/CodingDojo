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
			<p>Show All shows</p>
			
			<p><a href="/show">Add shows</a></p>
	</div>

	<table class="tb1">

    <thead>
        <tr>
            <th>Title</th>
            <th>Network </th>
            <th>Avg Rate</th>
            <th>Posted By</th>
        </tr>
    </thead>
   <tbody>

        <c:forEach var="show" items="${shows}">
    	<tr>
        <td><a href="/showproject/${project.id }"><c:out value="${show.title}"></c:out></a> </td>
        <td><c:out value="${show.network}"></c:out></td>
    	<td><c:out value="${show.title}"></c:out></td>
        <td><c:out value="${show.user.userName}"></c:out></td>
        
    </c:forEach>

    </tbody>
	</table>
	<br>
	<hr>
	
	
	
</body>
</html>