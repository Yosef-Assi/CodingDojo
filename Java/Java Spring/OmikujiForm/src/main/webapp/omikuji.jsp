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


<h1>Send on Omikuji!</h1>
<form action="/send" method="post">
		<table>
			<tr>
				<td>
					<label>Pick Any number from 5 to 25</label>
					<input type="number" class="form-control" min="5" max="25" name="name">
				</td>
			</tr>
			<tr>
				<td>
					<label>Enter Name of any city</label>
					<input type="text" class="form-control" name="city">
				</td>
			</tr>
			<tr>
				<td>
					<label>Enter Name of any person</label>
					<input type="text" class="form-control" name="person">
				</td>
			</tr>
			<tr>
				<td>
					<label>Enter Name hobby</label>
					<input type="text" class="form-control" name="hobby">
				</td>
			</tr>
				<tr>
				<td>
					<label>Enter Name living</label>
					<input type="text" class="form-control" name="liv">
				</td>
			</tr>
				<tr>
				<td>
					<label>Say something</label>
					<input type="text" class="form-control" name="some">
				</td>
			</tr>
				<tr>
				<td>
					<input type="submit" class="form-control" value="Send">
				</td>
			</tr>
		
		</table>

</form>


</body>
</html>