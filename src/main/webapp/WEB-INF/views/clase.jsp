<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Clase</title>
<link rel="stylesheet" href="<c:url value='/css/style-clase.css'/>">
<link rel="stylesheet" href="<c:url value='/css/style-music.css'/>">
<link href="https://fonts.googleapis.com/css?family=Roboto&display=swap" rel="stylesheet">
</head>
<body id="body">
	<c:url var="img" value="/imagenes" />
	<div id="modal"
		style="margin: auto; width: 101%; height: 100%; position: fixed; top: 0; left: 0; background: rgba(0, 0, 0, 0.7); display: none; z-index: 1;">
		<div id="modal-item">
			<img Id="close" src="${img}/delete.svg">
			<h3 class="title">Añadir estudiante</h3>
			<form:form method="post" modelAttribute="estudianteVo">
				<div>
					<label>Nombre</label>
					<form:input class="input" type="text" path="nombre" />
				</div>
				<div>
					<label>Apellido</label>
					<form:input class="input" type="text" path="apellido" />
				</div>
				<div>
					<button>Añadir</button>
				</div>
			</form:form>
		</div>
	</div>

	<div id="modalPicker">
		<button class="close" onclick="cerrar()">X</button>
		<button id="pick">Alumno al azar</button>
		<div id="containerPicker">
			
		</div>
	</div>
	
	<div id="modal-music">
        
        <div id="music-container">
            <button id="closeMusic">X</button>
            <img id="radio" src="${img}/modal-music/speaker.svg">
            <div id="type">
                <div id="relax">
                    <img id="yoga" src="${img}/modal-music/yoga.svg" width="60px">
                    <img id="playR" src="${img}/modal-music/multimedia.svg" width="40px">
                    <img id="stopR" src="${img}/modal-music/stop.svg" width="40px" style="display: none;">
                </div>
                <div id="active"> 
                    <img id="fun" src="${img}/modal-music/fun.svg" width="60px">
                    <img id="playA" src="${img}/modal-music/multimedia.svg" width="40px">
                    <img id="stopA" src="${img}/modal-music/stop.svg" width="40px" style="display: none;">
                </div>
            </div>
        </div>
    </div>



	<div class="nav">
		<a style="height: 18px;" href="<c:url value='/dashboard'/>"> <img style="width: 20px;" src="${img}/directional.svg" />
		</a>
		<div class="left">
			<p class="nombre-clase">${clase.getNombre()}</p>
			<p class="grado-clase"><span style="font-size: 20px;">${clase.getGrado().getNombre()}</span></p>
			<p class="grado-clase"><span style="font-size: 20px;">${clase.getEstudianteList().size()}</span>
				estudiantes</p>
			<p class="grado-clase"><span style="font-size: 20px;" id="puntosClase"> ${puntosClase}</span> puntos en total</p>
		</div>
	</div>
	<div class="container">

		<div class="classes">
			<div style="width: 100%; text-align: center;">
				<h3 style="">Estudiantes</h3>
				
				
			</div>
			<div class="items-container">
				<c:forEach var="card" items="${alumnos}">
					<div class="item">
						<div style="display:none;" class="id_estudiante">${card.id_estudiante}</div>
						<div class="contenido">
							<div class="points mas">
								<a
									href="<c:url value='/addPoints/${card.id_estudiante}/${clase.getId_clase()}'/>">
									<p>+</p>
								</a>
							</div>
							<div class="points menos">
								<a
									href="<c:url value='/removePoints/${card.id_estudiante}/${clase.getId_clase()}'/>">
									<p>-</p>
								</a>
							</div>
							<div class="points">
								<div class="point" id="puntosTotal">${card.puntosTotal}</div>
							</div>
							<div class="imgs">
								<img src="<c:url value='${card.foto}'/>"
									style="width: 68%; position: relative; top: -26px; transition: all 400ms ease-in-out;" />
							</div>
							<div class="name">
								<p
									style="height: 20%; text-align: center; color: #009688; font-weight: 600;">${card.nombre} ${card.apellido.charAt(0)}</p>
							</div>
						</div>
					</div>
				</c:forEach>
				<div class="item">
					<div class="contenido add-c">
						<a id="button">Agregar estudiante</a>
						<div class="img add">
							<img src="${img}/anadir.svg" />
						</div>

					</div>

				</div>
			</div>

		</div>
		<div class="actions">
			<div class="actions-contenido" >
			<a href="<c:url value='/rewardAll/${clase.getId_clase()}'/>" style="text-decoration: none;color:cornflowerblue;">
				<div>Premios</div>
				<div>
					<img style="width: 30px; height: 30px;" src="${img}/reward.png">
				</div>
			</a>
			</div>
			<div class="actions-contenido" id="azar">
				<div>Al azar</div>
				<div>
					<img style="width: 30px; height: 30px;" src="${img}/random.png">
				</div>
			</div>
			<div class="actions-contenido" id="music">
				<div>Musica</div>
				<div>
					<img style="width: 30px; height: 30px;" src="${img}/music.png">
				</div>
			</div>
			<div class="actions-contenido">
			<a href="<c:url value='/editar_clase/${clase.getId_clase()}'/>" style="text-decoration: none;color:cornflowerblue;">
				<div>Ver clase</div>
				<div>
					<img style="width: 30px; height: 30px;" src="${img}/gear.png">
				</div>
			</a>
			</div>
			

		</div>
	</div>
	<script type="text/javascript" src="<c:url value='/js/music.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/js/script.js'/>"></script>
	
</body>
</html>