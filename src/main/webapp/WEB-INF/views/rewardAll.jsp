<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Premios</title>
<link rel="stylesheet" href="<c:url value='/css/style-reward.css'/>">
<link href="https://fonts.googleapis.com/css?family=Poppins&display=swap" rel="stylesheet">
</head>
<body>
<c:url var="img" value="/imagenes" />
<div class="container">

	</div>
	<a href="<c:url value='/dashboard'/>" class="button">Regresar</a>
	<div id="users">
			<div class="title"><h1 style="text-align: center;">Lista de Premios</h1></div>
			<div class="table">
				<table>
					<thead>
						<tr>
							<th><b>Clase</b></th>
							<th><b>Premio</b></th>
							<th><b>Estudiante</b></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="card" items="${rewards}">
							<tr>
								<td>${clase.getNombre()}</td>
								<td>${card.nombre_premio}</td>
								<td>${card.estudiante.getNombre()} ${card.estudiante.getApellido()}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				</div>
		</div>
</div>	
	<script type="text/javascript" src="<c:url value='/js/script.js'/>"></script>
</body>
</html>