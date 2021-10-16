<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Usuario</title>
		<link rel="stylesheet" href="css/Clientes.css">
</head>
<body class="fondo1" >
<!--VARIABLES GLOBALES-- ======================================================>
<%!	
int buscar_cedula;
String email_usuario="", nombre_usuario="", password="", usuario="";%>
<%
if(request.getParameter("buscar_cedula")!=null){

buscar_cedula=Integer.parseInt(request.getParameter("buscar_cedula"));
email_usuario=request.getParameter("email_usuario");
nombre_usuario=request.getParameter("nombre_usuario");
password=request.getParameter("password");
usuario=request.getParameter("usuario");
}
if(request.getParameter("men")!=null){
	String mensaje=request.getParameter("men");
	out.print("<script type='text/javascript'>alert('"+mensaje+"');</script>");
}
%>
<!--CÓDIGO DEL FORMULARIO ===================================================-->
<h1>Usuarios</h1>		<!--  -->
<form action="Usuario" method="post">

<div class="form-clientes">

	<div class="informacion-form">
	<label class="name-client">Cédula Usuario:</label>
	<input class= "input-caja-texto" type="number" name="cedula_usuario"value="<%=buscar_cedula%>">
	</div>

	<div class="informacion-form">
	<label class="name-client">Email Usuario:</label>
	<input class= "input-caja-texto" type="email" name="email_usuario" value="<%=email_usuario%>">
	</div>
	
	<div class="informacion-form">
	<label class="name-client">Nombre Usuario:</label>
	<input class= "input-caja-texto" type="text" name="nombre_usuario" value="<%=nombre_usuario%>">
	</div>

	<div class="informacion-form">
	<label class="name-client">Password:</label>
	<input class= "input-caja-texto" type="password" name="password" value="<%=password%>">
	</div>

	<div class="informacion-form">
	<label class="name-client">Usuario:</label>
	<input class= "input-caja-texto" type="text" name="usuario" value="<%=usuario%>">
	</div>
	<br>
	
	<div class="botones">
	
		<input class="btn-registrar" type="submit" name="insertar" value="Registrar">
		<input class="btn-actualizar" type="submit" name="actualizar" value="Actualizar">
		<input class="btn-eliminar" type="submit" name="eliminar" value="Eliminar">
	</div>
	  
</div>

</form>
<hr>
<!--BOTÓN PARA EL MÉTODO BUSQUEDA	=========================================-->
<form action="Usuario" method="post">

<div class="consultar">
<fieldset>
<legend>Consultar Usuario</legend>
<div>
	<label>Cédula Usuario:</label>
	<input class="input-caja-texto" type="number" name="buscar_cedula">
	<input class="btn-consultar" type="submit" name="consultar" value="Consultar">
	</div>

</fieldset>
</div>
</form>
</body>
</html>