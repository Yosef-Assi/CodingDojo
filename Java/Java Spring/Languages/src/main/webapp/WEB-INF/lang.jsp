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
<link rel="stylesheet" href="style.css"/>	
</head>
<body>
	<table class="tb1">
    <thead>
        <tr>
            <th>Name</th>
            <th>Creator</th>
            <th>Version</th>
            <th>Actions</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="lang1" items="${lang}">
    	<tr>
        <td><a href="/lang/${lang1.id }"> <c:out value="${lang1.name}"></c:out></a></td>
        <td><c:out value="${lang1.creator}"></c:out> </td>
        <td><c:out value="${lang1.version}"></c:out></td>
        
        <td> <form action="/delete/${lang1.id}" method="post">
    	<input type="hidden" name="_method" value="delete">
    	<input type="submit" value="Delete"> ||
    	<a href="/edit/${lang1.id }">Edit</a>
		</form>
		</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<br>
	<form:form action="/addlangugae" method="post" modelAttribute="language">
		<table>
			<tr>
				<td>
					<form:label path="name">Language</form:label>
					<form:input path="name" class="form-control"/>
					<form:errors path="name" class="red"/>
				</td>
			</tr>
			<tr>
				<td>
					<form:label path="creator">Creator</form:label>
					<form:input class="form-control" path="creator"/>
					<form:errors path="creator" class="red"/>
					
				</td>
			</tr>
			<tr>
				<td>
					<form:label  path="version">Version</form:label>
					<form:input class="form-control" path="version"/>
					<form:errors path="version" class="red"/>
					
				</td>
			</tr>
			<tr>
				<td>
					<input type="submit" class="form-control" value="Send">
				</td>
			</tr>
		
		</table>

</form:form>
</body>
</html>