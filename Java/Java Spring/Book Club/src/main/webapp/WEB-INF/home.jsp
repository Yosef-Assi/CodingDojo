<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="/style2.css">
<title>Login And Registration</title>
</head>
<body>

<h3>Welcome, ${newUser.userName}</h3>
<p>Show All Books</p>
<p><a href="/logout">logout</a></p>
<p><a href="/book">Add Book</a></p>


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
        <td><a href="/getbook/${book.id }"><c:out value="${book.title}"></c:out></a> </td>
        <td><c:out value="${book.author}"></c:out></td>
        <td><c:out value="${book.user.userName}"></c:out></td>
        
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>