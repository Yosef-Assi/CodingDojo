<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1256">
<title>Ninja Gold in Java</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="style.css"/>	
</head>
<body>
    <h2>Your Gold: <span>${gold}</span></h2>
    <div class="flex">
        <div class="box">
            <form method="post" action="/process">
                <input type="hidden" name="hide" value="farm">
                <h3>Farm</h3>
                <p>(earns 10-20 gold)</p>
                <button name="form">Find Gold!</button>
            </form>
        </div>
        <div class="box">
            <form method="post" action="/process">
                <input type="hidden" name="hide" value="cave">
                <h3>Cave</h3>
                <p>(earns 10-20 gold)</p>
                <button name="cave">Find Gold!</button>
            </form>
          
        </div>
        <div class="box">
            <form method="post" action="/process">
                <input type="hidden" name="hide" value="house">
                <h3>House</h3>
                <p>(earns 10-20 gold)</p>
                <button name="home">Find Gold!</button>
            </form>
        </div>
        <div class="box">
            <form method="post" action="/process">
                <input type="hidden" name="hide" value="quest">
                <h3>Quest</h3>
                <p>(earns/takes 0-50 gold)</p>
                <button name="quest">Find Gold!</button>
                
            </form>
        </div>
    </div>
    <br><br>
    <h2>Activities :</h2>
    <div class="bot"> 	
    	    <c:forEach items="${log}" var="event">
		      		<c:choose>
					<c:when test="${event.contains('lost')}">
                  	<p style="color:red;"><c:out value="${event}"/> </p><br>
					</c:when>
					<c:otherwise>
                  	<p style="color:green;"><c:out value="${event}"/> </p><br>
					</c:otherwise>
					</c:choose>

            </c:forEach>
    </div>
</body>
</html>