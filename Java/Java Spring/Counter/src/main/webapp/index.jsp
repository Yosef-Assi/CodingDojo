<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
    
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


<h2>You have visited <a href="#">http://your_server </a> ${count} </h2>
<a href="/your_server">Test another visit ?</a>

<h2>You have visited <a href="#">http://your_server2 </a> ${count1} </h2>
<a href="/your_server2">Test another visit ?</a>


<br>
<br>	
<br>

<button class="btn-secondary"><a style="text-decoration:none; color:black;" href="/logout">Clear The Counts</a></button>  


</body>
</html>