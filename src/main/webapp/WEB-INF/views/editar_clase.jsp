<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta charset="UTF-8">
<meta content="width=device-width, initial-scale=1" name="viewport" />
<title>Editar Clase</title>
<link href="https://fonts.googleapis.com/css?family=Poppins&display=swap" rel="stylesheet">
<link rel="stylesheet" href="<c:url value='/css/editar_clase.css'/>">
</head>


	
	
	    <div class="container">
	    <a href="<c:url value='/clase/${clase.getId_clase()}'/>" class="back">Regresar</a>
        
        <div class="main-clase">
            <div class="clase-info">
                <div class="titulo">
                    <h2>Editar clase</h2>
                </div>
                <form:form method="post" modelAttribute="clase">
                    <div class="label">
                        <label>Nombre de la clase</label>
                    </div>
                    <div class="input">
                        <form:input type="text" path="nombre" />
                    </div>
                    <div class="label">
                        <label>Grado</label>
                    </div>
                    <div class="input">
                        <form:select class="input" path="grado.id_grado">
							<form:options items="${grados}" itemValue="id_grado" itemLabel="nombre"/>
						</form:select>
                    </div>
                    <div class="input">
                        <input type="submit" value="Actualizar" />
                    </div>
                </form:form>
            </div>
            <div class="lista-estudiantes">
                <div class="titulo-lista">
                    <h2>Lista de estudiantes</h2>
                    <a href="<c:url value='/clase/${clase.getId_clase()}?format=pdf'/>">PDF</a>
                </div>
                <div class="tabla-estudiantes">
                    <table>
                        <thead>
                            <tr>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody>
                        	<c:forEach var="card" items="${estudiantes}">
	                            <tr>
	                                <td class="img"><img src="<c:url value='${card.foto}'/>" ></td>
	                                <td class="nombre">${card.nombre} ${card.apellido}</td>
	                                <td class="actions">
	                                
	                                	<a class="reporte" href="<c:url value='/reporteEstudiante/${card.id_estudiante}/${clase.getId_clase()}'/>" ><img src="<c:url value='/imagenes/analytics.svg'/>"></a>
	                                    <a class="delete" href="<c:url value='/delete_E/${card.id_estudiante}/${clase.getId_clase()}'/>" onclick="return confirm('¿Está seguro de eliminar?')"><img src="<c:url value='/imagenes/trash.svg'/>"></a>
	                                </td>
	                            </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</body>
</html>