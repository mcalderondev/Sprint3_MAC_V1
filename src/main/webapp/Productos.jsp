<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/Productos.css">
<meta charset="UTF-8">
<title>Productos</title>
</head>
<body>
<%!	
int buscar_cod_producto, iva_compra, nitproveedor, precio_compra, precio_venta;
String nombre_producto="";%>
<%
if(request.getParameter("buscar_cod_producto")!=null){

buscar_cod_producto=Integer.parseInt(request.getParameter("buscar_cod_producto"));
iva_compra=Integer.parseInt(request.getParameter("iva_compra"));
nitproveedor=Integer.parseInt(request.getParameter("nitproveedor"));
precio_compra=Integer.parseInt(request.getParameter("precio_compra"));
precio_venta=Integer.parseInt(request.getParameter("precio_venta"));
nombre_producto=request.getParameter("nombre_producto");
}
if(request.getParameter("men")!=null){
	String mensaje=request.getParameter("men");
	out.print("<script type='text/javascript'>alert('"+mensaje+"');</script>");
}
%>
<h1>Productos</h1>
<form action="Productos" method="post" enctype="multipart/form-data">

<div class="form-clientes">

<div class="informacion-form">
		<label class="name-client">Codigo Producto:</label>
		<input class= "input-caja-texto" type="number" name="codigo_producto" value="<%=buscar_cod_producto%>">
</div>


<div class="informacion-form">
		<label class="name-client">IVA:</label>
		<input class= "input-caja-texto" type="number" name="iva_compra" value="<%=iva_compra%>">
</div>

<div class="informacion-form">
		<label class="name-client">NIT Proveedor:</label>
		<input class= "input-caja-texto" type="number" name="nitproveedor" value="<%=nitproveedor%>">
</div>

<div class="informacion-form">
		<label class="name-client">Nombre Producto:</label>
		<input class= "input-caja-texto" type="text" name="nombre_producto" value="<%=nombre_producto%>">
</div>

<div class="informacion-form">
		<label class="name-client">Precio Compra:</label>
		<input class= "input-caja-texto" type="number" name="precio_compra" value="<%=precio_compra%>">
</div>

<div class="informacion-form">
		<label class="name-client">Precio Venta:</label>
		<input class= "input-caja-texto" type="number" name="precio_venta" value="<%=precio_venta%>">
</div>

<br>
 
<div class="informacion-form">
		<label class="name-client">Archivo</label>
		<input type="file" name="archivo" value="Examinar" accept="application/vnd.ms-excel"></div>
<br>
<div class="botones">

		<input class="btn-registrar" type="submit" name="cargar" value="Cargar Archivo">
		<input class="btn-actualizar" type="submit" name="actualizar" value="Actualizar">
</div>
</div>
</form>

<!-- ======================================================================= -->
<form action="Productos" method="post">

<div class="consultar">
<fieldset>
		<legend>Consultar Producto</legend>
<div>
		<label>Codigo Producto:</label>
		<input class="input-caja-texto type="number" name="buscar_cod_producto">
		<input class="btn-consultar" type="submit" name="consultar" value="Consultar">
	</div>
</fieldset>
</div>

</form>

</body>
</html>