<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Clientes</title>
</head>
<body>
<!--VARIABLES GLOBALES-->
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
<!--CÓDIGO DEL FORMULARIO-->
<h1>Clientes</h1>
<form action="Clientes" method="post">
<div><label>Cédula Cliente:</label><input type="number" name="cedula_cliente" pattern="[1-9]+" title="digite solo numeros" value="<%=buscar_cedula%>"></div>
<div><label>Dirección Cliente:</label><input type="text" name="direccion_cliente" value="<%=direccion_cliente%>"></div>
<div><label>Email Cliente:</label><input type="text" name="email_cliente" value="<%=email_cliente%>"></div>
<div><label>Nombre del Cliente:</label><input type="text" name="nombre_cliente" value="<%=nombre_cliente%>"></div>
<div><label>Teléfono del Cliente:</label><input type="number" name="telefono_cliente" value="<%=telefono_cliente%>"></div>

<div><input type="submit" name="insertar" value="Registrar">

<input type="submit" name="actualizar" value="Actualizar">
<input type="submit" name="eliminar" value="Eliminar"></div>
</form>
<hr>
<form action="Clientes" method="post">
<!--BOTÓN PARA EL MÉTODO BUSQUEDA-->
<fieldset>
<legend>Consultar Cliente</legend>
<div><label>Cédula Cliente:</label><input type="number" name="buscar_cedula">
<input type="submit" name="consultar" value="Consultar"></div>
</fieldset>
</form>



</body>
</html>