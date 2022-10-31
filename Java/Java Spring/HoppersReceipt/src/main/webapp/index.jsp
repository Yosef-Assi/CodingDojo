<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h2>Customer Name <c:out value="${name1}"/></h2>
<p>Item Name : 	<c:out value="${itemName}"/></p>
<p>price : 	<c:out value="${price}"/></p>
<p>Description :<c:out value="${description}"/></p>
<p>Vendor : <c:out value="${vendor}"/></p>

</body>
</html>