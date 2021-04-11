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
<link rel="stylesheet" href="<c:url value='/css/style-reward.css'/>">
<link href="https://fonts.googleapis.com/css2?family=Poppins&display=swap" rel="stylesheet">
</head>
<body>

	
	<div class="container">
   
	<a href="<c:url value='/dashboard'/>" class="button" style="background: #808080">Regresar</a>
	<a href="<c:url value='/grados/registrar'/>" class="button">Registrar</a>
	<div id="users">
			<div class="title"><h1 style="text-align: center;">Lista de Grados</h1></div>
			<div style="text-align: center;">
			<p>*Si el grado tiene clases relacionadas no se podr&aacute; eliminar.</p>
			</div>
			
			<div class="table">
				<table>
					<thead>
						<tr>
							<th><b>Nombre</b></th>
							<th><b>Clases</b></th>
							<th><b>Acci&oacuten</b></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="grado" items="${grados}">
							<tr>
								<td>${grado.nombre}</td>
								<td class="listaClase">${grado.claseList.size()}</td>
								<td>
									<a href="<c:url value='/grados/${grado.id_grado}'/>" class="btn-editar">Editar</a>
									<a href="<c:url value='/grados/eliminar/${grado.id_grado}'/>" class="btn-eliminar">Eliminar</a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				</div>
		</div>
    </div>
</body>
</html>                                                                                                                                                                                                     