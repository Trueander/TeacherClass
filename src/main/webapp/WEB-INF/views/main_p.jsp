<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>TeacherClass</title>
<link rel="stylesheet" href="<c:url value='/css/style.css'/>">
<link href="https://fonts.googleapis.com/css?family=Roboto&display=swap"
	rel="stylesheet">

</head>
<body>
	
	<c:url var="img" value="/imagenes" />

	<div id="modal"
		style="margin: auto; width: 100%; height: 100%; position: absolute; top: 0; left: 0; background: rgba(0, 0, 0, 0.7); display: none; z-index: 1;">
		<div id="modal-item">
			<img Id="close" src="${img}/delete.svg">
			<h3 class="title">Crear nueva clase</h3>
			<form:form method="post" modelAttribute="clase">
			<div>
				<form:input class="input" type="text" path="nombre"
					placeholder="Ingrese el nombre de la clase" />
				<form:errors path="nombre"/>
			</div>
			<div>
				<form:select class="input" path="grado.id_grado">
					<form:options items="${grados}" itemValue="id_grado" itemLabel="nombre"/>
				</form:select>
				<form:errors path="grado.id_grado"/>
			</div>
				<div
					style="border-top: 1px solid #007bff; margin-top: 40px;">
					<button>Crear clase</button>
				</div>
			</form:form>
		</div>
	</div>

	<div class="nav">
		<div class="left">
			<h3>TeacherClass</h3>
		</div>
		<div class="right">
			<h3>${profesor.getNombre()}</h3>
			<img onclick="show_hide()" id="img" src="${img}/arrow-down.svg" />
				<div id="click" class="drop-content" style="display: none;">
					<div>
						<a href="<c:url value='/editar_profesor/${profesor.getId_profesor()}'/>">Editar</a>
					</div>
					<div>
						<a href="<c:url value='/logout'/>">Logout</a>
					</div>
				</div>
		</div>
	</div>
	<div class="container">
		<div class="classes">
			<div class="items-container">
				<c:forEach var="card" items="${bClases}">
					<div class="item">
						<a href="<c:url value='/delete/${card.id_clase}'/>"
							onclick="return confirm('¿Está seguro de eliminar?')"
							class="delete"> <img src="${img}/trash.svg">
						</a>
						<div class="config">
							<a href="<c:url value='/editar_clase/${card.id_clase}'/>" class="editar"> <img src="${img}/wheel.svg">
							</a>
						</div>
						<div class="class-name">
							<h2 style="text-align: center; padding-top: 20px;">${card.nombre} </h2>
						</div>
						<div class="class-info">
							<div style="width: 100%; text-align: center;">
								<b>${card.estudianteList.size()}</b> estudiantes
							</div>
						</div>
						<div class="enter">
							<a href="<c:url value='/clase/${card.id_clase}'/>">Ingresar</a>
						</div>

					</div>

				</c:forEach>
				<div class="item new">
					<div class="img">
						<img src="${img}/anadir.svg"/>
					</div>
					<div class="enter">
						<a href="#" id="button">Crear clase</a>
					</div>
				</div>
			</div>
		</div>
		<div class="info">
			
			<div class="name">
				<div class="teacher">
					<img src="${img}/teacher.svg">
				</div>
				<div class="datos">
					<h3>Profesor</h3>
					
					<h4>${profesor.getNombre()} ${profesor.getApellidos()}</h4>
				</div>
			</div>
			<div class="numberClasses">
				<div class="details">
					<img src="${img}/classroom.svg" >
					<div>
						<H3>Clases registradas</H3>
						<H4>${profesor.getClaseList().size()}</H4>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="<c:url value='/js/script.js'/>"></script>
</body>
</html>