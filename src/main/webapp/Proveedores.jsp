<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Proveedores</title>

</head>
<body>
<!--VARIABLES GLOBALES-->
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
<h1>Proveedores</h1>
<form action="Proveedores" method="post">
<div><label class="negrilla" >NIT Proveedor:</label><input type="number" name="nitproveedor" value="<%=buscar_nit%>"></div>
<div><label class="negrilla" >Ciudad Proveedor:</label><input type="text" name="ciudad_proveedor" value="<%=ciudad_proveedor%>"></div>
<div><label class="negrilla" >Dirección Proveedor:</label><input type="text" name="direccion_proveedor" value="<%=direccion_proveedor%>"></div>
<div><label class="negrilla" >Nombre:</label><input type="text" name="nombre_proveedor" value="<%=nombre_proveedor%>"></div>
<div><label class="negrilla" >Teléfono:</label><input type="number" name="telefono_proveedor" value="<%=telefono_proveedor%>"></div>

<div>
<input type="submit" name="insertar" value="Registrar">

<input type="submit" name="actualizar" value="Actualizar">
<input type="submit" name="eliminar" value="Eliminar"></div>
</form>
<hr>
<form action="Proveedores" method="post">
<!--BOTÓN PARA EL MÉTODO BUSQUEDA-->
<fieldset>
<legend>Consultar Proveedor</legend>
<div><label>NIT Proveedor:</label><input type="number" name="buscar_nit">
<input type="submit" name="consultar" value="Consultar"></div>
</fieldset>
</form>

</body>
</html>