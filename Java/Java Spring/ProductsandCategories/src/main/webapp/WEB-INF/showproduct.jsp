<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Tacos</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/style.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
   <br>
   		<h1 style="text-align: center;">${show.name }</h1>
   	<br>
   	<a href="/">Home</a>
   	
   	<h2>Categories :</h2>
   
    	 <c:forEach var="lang1" items="${procat}">
    	
        <p><c:out value="${lang1.name}"></c:out></p>
        
    </c:forEach> 
	<form action="/product/${show.id}" method="post">
		<table>
			<tr>
			<select name="categoryId" id="categoryId" class="form-control">
						<c:forEach var="pro" items="${allcat }">
								<option value="${pro.id }">${pro.name }</option>
						</c:forEach>
			</select>
			</tr>
			<tr>
				<td>
					<input type="submit" class="form-control" value="Create">
				</td>
			</tr>
		
		</table>

</form>
</body>
</html>