<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/Proveedores.css">
<meta charset="ISO-8859-1">
<title>Proveedores</title>
		<link rel="stylesheet" href="css/Clientes.css">
</head>
<body>
<!--VARIABLES GLOBALES ======================================================-->
<%!	
int buscar_nit;
String ciudad_proveedor="", direccion_proveedor="", nombre_proveedor="", telefono_proveedor="";%>
<%
if(request.getParameter("buscar_nit")!=null){

buscar_nit=Integer.parseInt(request.getParameter("buscar_nit"));
ciudad_proveedor=request.getParameter("ciudad_proveedor");
direccion_proveedor=request.getParameter("direccion_proveedor");
nombre_proveedor=request.getParameter("nombre_proveedor");
telefono_proveedor=request.getParameter("telefono_proveedor");
}
if(request.getParameter("men")!=null){
	String mensaje=request.getParameter("men");
	out.print("<script type='text/javascript'>alert('"+mensaje+"');</script>");
}
%>
<!--CÓDIGO DEL FORMULARIO ===================================================-->
<h1>Proveedores</h1>
<form action="Proveedores" method="post">

<div class="form-clientes">

<div class="informacion-form">
<label class="name-client">NIT Proveedor:</label>
<input class= "input-caja-texto"  type="number" name="nitproveedor" value="<%=buscar_nit%>">
</div>

<div class="informacion-form">
<label class="name-client">Ciudad Proveedor:</label>
<input class= "input-caja-texto"  type="text" name="ciudad_proveedor" value="<%=ciudad_proveedor%>">
</div>

<div class="informacion-form">
<label class="name-client">Dirección Proveedor:</label>
<input class= "input-caja-texto"  type="text" name="direccion_proveedor" value="<%=direccion_proveedor%>">
</div>

<div class="informacion-form">
<label class="name-client">Nombre:</label>
<input class= "input-caja-texto"  type="text" name="nombre_proveedor" value="<%=nombre_proveedor%>">
</div>

<div class="informacion-form">
<label class="name-client">Teléfono:</label>
<input class= "input-caja-texto"  type="number" name="telefono_proveedor" value="<%=telefono_proveedor%>">
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

<!--BOTÓN PARA EL MÉTODO BUSQUEDA-->
<form action="Proveedores" method="post">

<div class="consultar">
<fieldset>
<legend>Consultar Proveedor</legend>
<div>
<label>NIT Proveedor:</label>
<input class="input-caja-texto" type="number" name="buscar_nit">
<input class="btn-consultar" type="submit" name="consultar" value="Consultar"></div>
</fieldset>
</div>
</form>

</body>
</html>