<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Registrar Profesor</title>
<link rel="stylesheet" href="<c:url value='/css/form_profesor.css'/>">
<link href="https://fonts.googleapis.com/css2?family=Poppins&display=swap" rel="stylesheet">
</head>
<body>

	
	<div class="container">
        <div class="main">
            <form:form method="post" modelAttribute="grado">
                <div class="title">
                    <h2>Registrar grado</h2>
                </div>
                <div class="label">
                    <label for="">Nombre</label>
                </div>

                <div class="input error">
                    <form:input type="text" path="nombre"/>
                    <form:errors path="nombre"/> 
                </div>


                <div class="input">
                    <input type="submit" value="Actualizar">
                </div>
            </form:form>
        </div>
    </div>
</body>
</html>                                                                                                                                                                                                     