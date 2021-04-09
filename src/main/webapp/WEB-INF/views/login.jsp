<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Log In</title>
</head>
<link rel="stylesheet" href="css/login.css">
<link href="https://fonts.googleapis.com/css?family=Poppins&display=swap" rel="stylesheet">
</head>
<body>
	<img class="wave" src="imagenes/wave.png">
	<div class="mensaje">${login}</div>
<div class="container">
			
			<div class="img">
				<img src="imagenes/login.svg">
			</div>
			<div class="login-container">
			<c:url var="loginURL" value="/login"/>
			<form name="" method="post" action="${loginURL}" >
			
			<input type="hidden" 
                   name="${_csrf.parameterName}" 
                   value="${_csrf.token}"/>
            
            <h1 style="color:rgba(0,0,0,0.7);">TeacherClass</h1>
				<img src="imagenes/img.svg">
				<!-- si existe error de logeo -->
            <c:if test="${param.error != null}">
                <p style="color:red">
                    Error, username y/o password incorrecto!
                </p>
            </c:if>
            
            <!-- si existe cierre de sesión -->
            <c:if test="${param.logout != null}">
                <p style="color:green">
                    Usted a cerrado sesión!
                </p>
            </c:if>
				<input type="text" placeholder="Username" name="username"/>
				<input type="password" placeholder="&#128272; Password" name="password"/>
				<input class="btn" type="submit" value="Sign in"/>
				<p>¿Aún no estás registrado?</p>
				<button class="btn" type="button" onclick='location.href="<c:url value="/registrar"/>"'>Crear cuenta</button>
			</form>
			</div>

	
</div>
</body>

</html>