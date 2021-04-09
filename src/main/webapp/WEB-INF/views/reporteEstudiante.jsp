<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Reporte Estudiantil</title>
<link rel="stylesheet" href="<c:url value='/css/chart-style.css'/>">
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<link href="https://fonts.googleapis.com/css?family=Poppins&display=swap" rel="stylesheet">
</head>
<body onload="monsterDance()">
<c:url var="img" value="/imagenes" />
<div id="modal"
		style="margin: auto; width: 100%; height: 100%; position: fixed; top: 0; left: 0; background: rgba(0, 0, 0, 0.7); display: none; z-index: 1;">
		<div id="modal-item">
			<img id="close" src="${img}/delete.svg">
			<h3 class="title">Premio</h3>
			<form:form method="post" modelAttribute="premio">
				<form:input type="text" class="input" path="nombre_premio" placeholder="Ingrese el premio"/>
				<div
					style="border-top: 1px solid rgba(0, 123, 255, 0.9); margin-top: 40px;">
					<button>Añadir</button>
				</div>
			</form:form>
		</div>
	</div>
	<div class="container">
        <a href="<c:url value='/editar_clase/${clase.getId_clase()}'/>" class="back">Regresar</a>
        
        <div class="piecharts">
            <div class="title"> 
                <h2>Reporte General del estudiante</h2>
                
            </div>
            <div style="display: flex;">
            <a id="button" class="premio">Premiar</a>
            <a class="premio" href="<c:url value='/reporteEstudiante/${estudiante.id_estudiante}/${clase.getId_clase()}?format=pdf'/>" >PDF</a>
            </div>
            <div class="charts">
                <div class="estudiante">
                    <div class="name">
                        <img id="estudianteMonster" src="<c:url value='${estudiante.foto}'/>" width="120px">
                        <div class="details">
                            <div class="left-n">
                                <p>Nombre:</p>
                                <p>Clase:</p>
                                <p>Grado:</p>
                            </div>
                            <div class="right-n">
                                <p>${estudiante.getNombre()} ${estudiante.getApellido()}</p>
                                <p>${clase.getNombre()}</p>
                                <p>${clase.getGrado().getNombre()}</p>
                            </div>
                        </div>
                    </div>
                </div>
                    <div id="piechart" style="width: 600px; height: 400px; margin: auto;">
                        <div id="usuarios" style="display: none;">${estudiante.getPuntosContra()}</div>
                        <div id="encuestas" style="display: none;">${estudiante.getPuntosFavor()}</div>
                    </div>
            </div>
        </div>
        
    </div>
    <div id="users">
			<div class="title"><h1 style="text-align: center;">Premios</h1></div>
			<div class="table">
				<table>
					<thead>
						<tr>
							<th><b>Premio</b></th>
							<th><b>Acciones</b></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="card" items="${estudianteRewards}">
							<tr>
								<td>${card.nombre_premio}</td>
								<td>
									<a class="deleteR" href="<c:url value='/delete_reward/${card.id_premio}/${estudiante.getId_estudiante()}/${clase.getId_clase()}'/>">Eliminar</a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				</div>
		</div>
    <script src="<c:url value='/js/chart-script.js'/>"></script>
    <script src="<c:url value='/js/script.js'/>"></script>
</body>
</html>