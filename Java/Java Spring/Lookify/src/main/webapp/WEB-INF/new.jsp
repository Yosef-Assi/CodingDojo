<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="/css/style.css">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />

<title><c:out value="${artist}"></c:out></title>
</head>
<body>
<br>
<br>
<table>
    <thead>
        <tr>
            <th>Songs by <c:out value="${artist}"></c:out></th>
            <th>
	            <form  action="/search" method="post">
					<input  type="text"  name="search" placeholder="Search"/>
					<input  type="submit" value="New Search"/>
				</form>
            </th>
            <th><a href="/lookifies">Home</a></th>
        </tr>
    </thead>
</table>
<hr>
<table  class="tb1">
    <thead>
        <tr>
            <th>Name</th>
            <th>Rating</th>
            <th>Action</th>
        </tr>
    </thead>
    <tbody>
		<c:forEach var="song" items="${songs}">
			<tr>
				<td><a href="/songs/${song.id}"><c:out value="${song.title}"></c:out></a></td>
				<td><c:out value="${song.rating}"></c:out></td>
				<td><a href="/delete/${song.id}">delete</a></td>
			</tr>	
		</c:forEach>
    </tbody>
</table>
</body>
</html>