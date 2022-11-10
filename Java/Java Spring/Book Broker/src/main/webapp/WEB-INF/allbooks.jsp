<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
    
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
</head>
<body>
<table class="tb1">
    <thead>
        <tr>
            <th>id</th>
            <th>title</th>
            <th>author</th>
            <th>posted_by</th>
        </tr>
    </thead>
   <tbody>
        <c:forEach var="book" items="${allbook}">
    	<tr>
        <td><c:out value="${book.id}"></c:out></td>
        <td><c:out value="${book.title}"></c:out> </td>
        <td><c:out value="${book.author}"></c:out></td>
        <td><c:out value="${book.user.userName}"></c:out></td>
        
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>