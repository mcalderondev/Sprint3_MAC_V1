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
<%!	//	VARIABLES GLOBALES	====================================================
int codigo_producto,nitproveedor;
String nombre_producto="";
double ivacompra,precio_compra,precio_venta;%>

<%
if(request.getParameter("codigo_producto")!=null){

codigo_producto=Integer.parseInt(request.getParameter("codigo_producto"));
ivacompra=Double.parseDouble(request.getParameter("ivacompra"));
nitproveedor=Integer.parseInt(request.getParameter("nitproveedor"));
nombre_producto=request.getParameter("nombre_producto");
precio_compra=Double.parseDouble(request.getParameter("precio_compra"));
precio_venta=Double.parseDouble(request.getParameter("precio_venta"));
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
		<input class= "input-caja-texto" type="number" name="codigo_producto" value="<%=codigo_producto%>">
</div>


<div class="informacion-form">
		<label class="name-client">IVA:</label>
		<input class= "input-caja-texto" type="number" name="iva_compra" value="<%=ivacompra%>">
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
		<input class="input-caja-texto" type="number" name="<%=codigo_producto%>">
		<input class="btn-consultar" type="submit" name="consultar" value="Consultar">
	</div>
</fieldset>
</div>

</form>

</body>
</html>