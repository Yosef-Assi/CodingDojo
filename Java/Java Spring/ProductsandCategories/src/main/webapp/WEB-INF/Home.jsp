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
	<h2 style="text-align: center;">Home Page</h2>
	
	<a href="/products">New Product</a>
	<br>
	<a href="/cat">New Category</a>
	<hr>
	<table class="tb1">
    <thead>
        <tr>
            <th>Product</th>
            <th>Category</th>
        </tr>
    </thead>
   <tbody>	
       
    <tr>
    	<td>
    	<ul>
	    	 <c:forEach var="product" items="${product}">
	    
	     <li>   <a href="/product/${product.id }"> <c:out value="${product.name}"></c:out></a></li>
	       
	         </c:forEach>
     	</ul>
         </td>
      	<td>
      	<ul>
          <c:forEach var="cat" items="${cat}">
          
        <li><a href="/cat/${cat.id }"> <c:out value="${cat.name}"></c:out></a></li>
        
         </c:forEach>
         </ul>
        </td>
         
      </tr>
     
        
  
    </tbody>
</table>
</body>
</html>