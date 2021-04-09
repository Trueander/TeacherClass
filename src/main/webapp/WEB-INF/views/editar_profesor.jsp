<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Editar</title>
<link rel="stylesheet" href="<c:url value='/css/form_profesor.css'/>">
<link href="https://fonts.googleapis.com/css?family=Poppins&display=swap" rel="stylesheet">

</head>
<body>



<div class="container">
		<a href="<c:url value='/dashboard'/>" class="back">Regresar</a>
        <div class="main">
            <form:form method="post" modelAttribute="profesor">
                <div class="title">
                    <h2>Actualizar datos</h2>
                </div>
                <div class="label">
                    <label for="">Nombre</label>
                </div>
                <div class="input" style="display: none">
                    <form:input type="text" path="username" readonly="true"/>
                </div>
                <div class="input" style="display: none">
                    <form:input type="password" path="password"  readonly="true"/>
                </div>
                <div class="input">
                    <form:input type="text" path="nombre"/>
                </div>
                <div class="label">
                    <label for="">Apellido</label>
                </div>
                <div class="input">
                    <form:input id="apellido" class="input" type="text" path="apellidos"/>
                </div>
                <div class="label">
                    <label for="">Edad</label>
                </div>
                <div class="input">
                    <form:input type="text" path="edad"/>
                </div>
                <div class="label">
                    <label for="">Sexo</label>
                </div>
                <div class="input">
                    <form:select path="sexo" >
                    		<form:option value="" label="Seleccione su sexo"/>
							<form:option value="hombre" label="Hombre"/>
							<form:option value="mujer" label="Mujer"/>
					</form:select>
                </div>
                <div class="input">
                    <input type="submit" value="Actualizar">
                </div>
            </form:form>
        </div>
    </div>
</body>
</html>