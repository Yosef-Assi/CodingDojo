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
<link rel="stylesheet" href="style.css"/>	
</head>
<body>
	
	<h2>Save Travels</h2>
	<table class="tb1">
	
    <thead>
        <tr>
            <th>Expense</th>
            <th>Vendor</th>
            <th>Amount</th>
            <th>Actions</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="ex1" items="${ex}">
    	<tr>
        <td><a href="/exp/${ex1.id }"> <c:out value="${ex1.name}"></c:out></a></td>
        <td><c:out value="${ex1.vendor}"></c:out> </td>
        <td>$<c:out value="${ex1.amount}"></c:out></td>
        <td><a href="/ex/${ex1.id }">Edit</a></td>
        <td> <form action="/delete/${ex1.id}" method="post">
    	<input type="hidden" name="_method" value="delete">
    	<input type="submit" value="Delete">
		</form>
		</td>
      <%--   <td><a href="/ex/${ex1.id }">Delete</a></td> --%>

        </tr>
    </c:forEach>
    </tbody>
</table>
<br>

	<form:form action="/go" method="post" modelAttribute="expense">
	<h2>Add an expense</h2>
		<table>

		
		
			<tr>
				<td>
					<form:label path="name">Enter Name of expense</form:label>
					<form:input path="name" class="form-control"/>
					<form:errors path="name" class="red"/>
				</td>
			</tr>
			<tr>
				<td>
					<form:label path="vendor">Enter vendor of expense</form:label>
					<form:input class="form-control" path="vendor"/>
					<form:errors path="vendor" class="red"/>
					
				</td>
			</tr>
			<tr>
				<td>
					<form:label  path="amount">Enter amount of expense</form:label>
					<form:input class="form-control" path="amount"/>
					<form:errors path="amount" class="red"/>
					
				</td>
			</tr>
				<tr>
				<td>
					<form:label  path="description">Enter Desc</form:label>
					<form:input  class="form-control" path="description"/>
					<form:errors path="description" class="red"/>
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