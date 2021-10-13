<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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

<div><label class="negrilla" >Codigo Producto:</label><input type="number" name="codigo_producto" value="<%=buscar_cod_producto%>"></div>
<div><label class="negrilla" >IVA:</label><input type="number" name="iva_compra" value="<%=iva_compra%>"></div>
<div><label class="negrilla" >NIT Proveedor:</label><input type="number" name="nitproveedor" value="<%=nitproveedor%>"></div>
<div><label class="negrilla" >Nombre Producto:</label><input type="text" name="nombre_producto" value="<%=nombre_producto%>"></div>
<div><label class="negrilla" >Precio Compra:</label><input type="number" name="precio_compra" value="<%=precio_compra%>"></div>
<div><label class="negrilla" >Precio Venta:</label><input type="number" name="precio_venta" value="<%=precio_venta%>"></div>
 
<div><label>Archivo: </label><input type="file" name="archivo" value="Examinar" accept="application/vnd.ms-excel"></div>
<input type="submit" name="cargar" value="Cargar Archivo">
<input type="submit" name="actualizar" value="Actualizar">
</form>

<form action="Productos" method="post">
<fieldset>
<legend>Consultar Producto</legend>
<div><label>Codigo Producto:</label><input type="number" name="buscar_cod_producto">
<input type="submit" name="consultar" value="Consultar"></div>
</fieldset>
</form>


</body>
</html>