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
	<table class="tb1">
    <thead>
        <tr>
            <th>Name</th>
            <th>Rating</th>
            <th>Create by</th>
        </tr>
    </thead>
    <tbody>	
        <c:forEach var="lookify" items="${songs}">
    	<tr>
    	<td><c:out value="${lookify.title}"></c:out></td>
    	
        <td><c:out value="${lookify.rating}"></c:out></td>
        <td><c:out value="${lookify.artist}"></c:out> </td>        
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>