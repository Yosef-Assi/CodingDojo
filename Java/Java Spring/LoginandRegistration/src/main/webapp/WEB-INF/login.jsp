<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1256">
<title>Insert title here</title>
</head>
<body>

	<div class="container">
        <div class="reg">
            
            <h1 class="h1">Registration</h1>
            <br><br>
            <form action="/reg" method="post" >
                {% csrf_token %}
            <table>
                <tr>
                    <td><p>First Name</p></td>
                    <td><input type="text" name="first_name"></td>
                </tr>
                <tr>
                    <td><p>Last Name</p></td>
                    <td><input type="text" name="last_name"></td>
                </tr>
                <tr>
                    <td><p>Email</p></td>
                    <td><input type="email" name="email"></td>
                </tr>
                <tr>
                    <td><p>Password</p></td>
                    <td><input type="password" name="password"></td>
                </tr>
                <tr>
                    <td><p>Confirm Password</p></td>
                    <td><input type="password" name="cpassword"></td>
                </tr>

                <tr>
                    <td><p></p></td>
                    <td><input type="submit" name="sumbit" value="Register" class="btn btn-danger"></td>
                </tr>
                {% if messages %}
                <ul class="messages">    
                    {% for message in messages %}    
                        <li {% if message.tags %} class="{{ message.tags }}"{% endif %}>{{ message }}</li>    
                    {% endfor %}
                </ul>
                {% endif %}
            </table>
        </form>
        </div>
        <div class = "vertical"></div>

        <div class="login">
            <h1>Login</h1>
            <br><br>
            <form action="/login" method="post">
                {% csrf_token %}
            <table>
                <tr>
                    <td><p>Email</p></td>
                    <td><input type="email" name="email2"></td>
                </tr>
                <tr>
                    <td><p>Password</p></td>
                    <td><input type="password" name="password2"></td>
                </tr>
                <tr>
                    <td><p></p></td>
                    <td><input type="submit" name="sumbit2" value="Login" class="btn btn-danger"></td>
                </tr>
            </table>
        </form>
        </div>
    </div>
</body>
</html>