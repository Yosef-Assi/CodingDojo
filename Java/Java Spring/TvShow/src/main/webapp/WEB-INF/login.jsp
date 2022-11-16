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
    <title>LOGIN</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/style.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
        <div class="reg">
            
            <h1 class="h1">Registration</h1>
            <br><br>
            <form:form action="/register" method="post" modelAttribute="newUser">
                
            <table>
                <tr>
                    <td><p>User Name</p></td>
                    <td><form:input type="text" path="userName"/></td>
                   <td> <form:errors path="userName" class="text-danger"/> </td>
                </tr>
                <tr>
                    <td><p>Email</p></td>
                    <td><form:input type="email" path="email"/></td>
                    <td> <form:errors path="email" class="text-danger"/> </td>
                    
                </tr>
                <tr>
                    <td><p>Password</p></td>
                    <td><form:input type="password" path="password"/></td>
                    <td> <form:errors path="password" class="text-danger"/> </td>
                    
                </tr>
                <tr>
                    <td><p>Confirm Password</p></td>
                    <td><form:input type="password" path="confirm"/></td>
                    <td> <form:errors path="confirm" class="text-danger"/> </td>
                    
                </tr>

                <tr>
                    <td><p></p></td>
                    <td><input type="submit" name="sumbit" value="Register" class="btn btn-danger"></td>
                </tr>
            </table>
        </form:form>
        </div>
        <div class = "vertical"></div>

        <div class="login">
            <h1>Login</h1>
            <br><br>
            <form:form action="/login" method="post" modelAttribute="newLogin">
            <table>
                <tr>
                    <td><p>Email</p></td>
                    <td><form:input type="email" path="email"/></td>
                  	<td> <form:errors path="email" class="text-danger"/> </td>
                    
                </tr>
                <tr>
                    <td><p>Password</p></td>
                    <td><form:input type="password" path="password"/></td>
                    <td> <form:errors path="password" class="text-danger"/> </td>
                </tr>
                <tr>
                    <td><p></p></td>
                    <td><input type="submit" name="sumbit2" value="Login" class="btn btn-danger"></td>
                </tr>
            </table>
        </form:form>
        </div>
    </div>
</body>
</html>