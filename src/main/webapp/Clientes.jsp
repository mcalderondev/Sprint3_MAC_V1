<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/Clientes.css">

<meta charset="ISO-8859-1">
<title>Clientes</title>
</head>
<body>
<!--VARIABLES GLOBALES ======================================================-->
<%!	
int buscar_cedula;
String direccion_cliente="", email_cliente="", nombre_cliente="", telefono_cliente="";%>
<%
if(request.getParameter("buscar_cedula")!=null){

buscar_cedula=Integer.parseInt(request.getParameter("buscar_cedula"));
direccion_cliente=request.getParameter("direccion_cliente");
email_cliente=request.getParameter("email_cliente");
nombre_cliente=request.getParameter("nombre_cliente");
telefono_cliente=request.getParameter("telefono_cliente");
}
if(request.getParameter("men")!=null){
	String mensaje=request.getParameter("men");
	out.print("<script type='text/javascript'>alert('"+mensaje+"');</script>");
}
%>
<!--CÓDIGO DEL FORMULARIO ===================================================-->
<h1>Clientes</h1>
<form action="Clientes" method="post">
	<div class="form-clientes">
	
	<div class="informacion-form">
	<label class="name-client">Cédula Cliente:</label>
	<input class= "input-caja-texto" type="number" name="cedula_cliente"value="<%=buscar_cedula%>">
	</div>
	
	<div class="informacion-form">
	<label class="name-client">Dirección Cliente:</label>
	<input class="input-caja-texto" type="text" name="direccion_cliente" value="<%=direccion_cliente%>">
	</div>
	
	<div class="informacion-form">
	<label class="name-client">Email Cliente:</label>
	<input class="input-caja-texto" type="text" name="email_cliente" value="<%=email_cliente%>">
	</div>
	
	<div class="informacion-form">
	<label class="name-client">Nombre del Cliente:</label>
	<input class="input-caja-texto" type="text" name="nombre_cliente" value="<%=nombre_cliente%>">
	</div>
	
	<div class="informacion-form">
	<label class="name-client">Teléfono del Cliente:</label>
	<input class="input-caja-texto" type="number" name="telefono_cliente" value="<%=telefono_cliente%>">
	</div>
	<br>
	
	<div class="botones">
	
		<input class="btn-registrar" type="submit" name="insertar" value="Registrar">
		<input class="btn-actualizar" type="submit" name="actualizar" value="Actualizar">
		<input class="btn-eliminar" type="submit" name="eliminar" value="Eliminar">
	</div>
	
	</div>
	
</form>
<!--BOTÓN PARA EL MÉTODO BUSQUEDA-->
<form action="Clientes" method="post">

<div class="consultar">
	<fieldset>
		<legend>Consultar Cliente</legend>
		<div>
			<label>Cédula Cliente:</label>
			<input class="input-caja-texto" type="number" name="buscar_cedula">
			<input class="btn-consultar" type="submit" name="consultar" value="Consultar">
		</div>
	</fieldset>
</div>

</form>

</body>
</html>