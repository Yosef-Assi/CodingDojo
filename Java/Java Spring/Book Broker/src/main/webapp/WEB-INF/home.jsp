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
            <th>Owner</th>
            <th>Actions</th>
        </tr>
    </thead>
   <tbody>
        <c:forEach var="book" items="${booknoborrow}">
    	<tr>
    	<%-- <c:choose>
    	<c:when test="${book.borrow.id!=user_id || book.user.id==user_id }"> --%>
        <td><c:out value="${book.id}"></c:out></td>
        <td><a href="/getbook/${book.id }"><c:out value="${book.title}"></c:out></a> </td>
        <td><c:out value="${book.author}"></c:out></td>
        <td><c:out value="${book.user.userName}"></c:out></td>
   
<%--     </c:when>    
 
</c:choose>
        --%>
        
        <td>
        <c:choose>
    <c:when test="${book.user.id==user_id}">
       
     <a href="edit/getbook/${book.id }">edit</a><form action="/delete/${book.id}" method="post">
    	<input type="hidden" name="_method" value="delete">
    	<input type="submit" value="Delete">
    	</form>
     	
        <br />
    </c:when>    
    <c:otherwise>
        
    
       <a href="/addborrow/${book.id}">borrow</a> 
        <br />
    </c:otherwise>
</c:choose>
        </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
















<table class="tb1">

    <thead>
        <tr>
            <th>id</th>
            <th>title</th>
            <th>author</th>
            <th>Owner</th>
            <th>Actions</th>
        </tr>
    </thead>
   <tbody>
        <c:forEach var="book" items="${bk}">
    	<tr>

        <td><c:out value="${book.id}"></c:out></td>
        <td><a href="/getbook/${book.id }"><c:out value="${book.title}"></c:out></a> </td>
        <td><c:out value="${book.author}"></c:out></td>
        <td><c:out value="${book.user.userName}"></c:out></td>
   

       
        
        <td>
        <c:choose>
    <c:when test="${book.user.id==user_id}">
       
     <a href="edit/getbook/${book.id }">edit</a> || <a href="delete/${book.id }">delete</a>
     	
        <br />
    </c:when>    
    <c:otherwise>
       <a href="Removeborrow/${book.id }">return</a> 
        <br />
    </c:otherwise>
</c:choose>
        </td>
        </tr>
    </c:forEach>
    </tbody>
</table>









</body>
</html>