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
<h1>Here's Your Omikuji!</h1>
	<div class="box">
		<h2>In <span>${name }</span> Years , you will Live in <span>${city}</span> with <span>${person}</span> as your roomate , <span>${hobby}</span>
		for see a <span>${liv}</span> you will have good luck. Also <span>${some}</span>
		 </h2>
		
	</div>
	
	<a href="/">Go to home</a>
</body>
</html>