<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>TeacherClass</title>
<link href="https://fonts.googleapis.com/css?family=Roboto&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Raleway:300,400,700,800" rel="stylesheet">
<link rel="stylesheet" href="css/style-index.css">

</head>
<body>
<div class="container">
<header>
        <nav id="home">
            <div class="logo">
                <h3 class="fancy">TeacherClass</h3>
            </div>
            <div class="icono" id="icono">
                <img src="imagenes/menu.svg" style="width: 30px;">
            </div>
            <ul class="ul enlaces uno" id="enlaces">
            	<a href="#home">Home</a>
                <a href="<c:url value='/login'/>">Iniciar sesión</a>
                <a href="#carrusel">Herramientas</a>
                <a href="#quien">¿Quiénes somos?</a>
            </ul>
        </nav>
        <div class="titulo">
        <h1>Controla tu clase de la mejor forma.</h1>
        <p>TeacherClass lo hace posible.</p>
        <a href="<c:url value='/registrar'/>">Registrate ahora</a>
        </div>        
        </header>
        <div id="carrusel">
        	<h2>Herramientas de TeacherClass<h2>
        	<img id="imgBanner" src="imagenes/carrusel/main_p.png">
        </div>
        
        <div id="quien" class="contenido">
	            <div class="left">
	                    <img src="imagenes/classImg.svg">
	            </div>
	            <div class="right">
	                <h2>
	                <b>TeacherClass</b> es una extraordinaria 
	                herramienta que ayuda a los docentes a manejar mejor su clase.
	                 </h2>
	            </div>
        </div>
       
        <footer>
        
            
            <div class="icons">
                <a href="https://www.facebook.com/AndersonBengolea"><img src="imagenes/facebook.svg"></a>
                <a href="www.twitter.com"><img src="imagenes/twitter.svg"></a>
                <a href="https://www.youtube.com/channel/UCFed5tLVmXn5GFFR9o6jQ2A?view_as=subscriber"><img src="imagenes/youtube.svg"></a>
                <a href="https://github.com/Trueander"><img src="imagenes/cat.svg"></a>
        </div>
        <h3>Copyright © 2020 Anderson Bengolea Company. All rights reserved.</h3>
        </footer>
    </div>
  <script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
    <script type="text/javascript" src="js/codigo.js"></script>
    
</body>
</html>