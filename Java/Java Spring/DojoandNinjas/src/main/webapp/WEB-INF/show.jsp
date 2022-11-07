<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1256">
<title>Languages Display and Add</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/style.css"/>	
</head>
<body>
	<table class="tb1">
    <thead>
        <tr>
            <th>First_name</th>
            <th>Last_name</th>
            <th>Age</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="lang1" items="${show.ninjas}">
    	<tr>
        <td><c:out value="${lang1.firstName}"></c:out></td>
        <td><c:out value="${lang1.lastName}"></c:out> </td>
        <td><c:out value="${lang1.age}"></c:out></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<br>

</body>
</html>