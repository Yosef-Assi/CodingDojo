<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1256">
<title>Show Book</title>
</head>
<body>

<c:choose>
    <c:when test="${allbook.user.id==user_id}">
        <h2>${allbook.title }</h2>
        ${allbook.user.userName } read ${allbook.title } by ${allbook.author }
        <hr>
         ${allbook.myThoughts }
       
        <hr>
        <a href="/edit/getbook/${allbook.id }">Edit</a>
         <form action="/delete/${allbook.id}" method="post">
    	<input type="hidden" name="_method" value="delete">
    	<input type="submit" value="Delete">
    	</form>
        <h2></h2>
        <br />
    </c:when>    
    <c:otherwise>
       <h2>this book not for you</h2>
        <br />
    </c:otherwise>
</c:choose>


</body>
</html>