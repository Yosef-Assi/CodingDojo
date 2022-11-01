<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1256">
<title>Fruity Loops</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="style.css"/>
</head>
<body>
 <h1>Fruity Loops</h1>
 	<table border=1>
 	<tr>
 		<th>Name</th>
 		<th>Price</th>
 	</tr>
    <c:forEach var="oneDojo" items="${fruits1}">
    	<tr>
        <td><c:out value="${oneDojo.name}"></c:out></td>
        <td><c:out value="${oneDojo.price}"></c:out></td>
        </tr>
    </c:forEach>
    </table>
</body>
</html>