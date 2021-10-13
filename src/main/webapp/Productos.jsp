<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Productos</h1>
<form action="Productos" method="post" enctype="multipart/form-data">

<!-- 
<div><label class="negrilla" >Codigo Producto:</label><input type="number" name="codigo_producto" value="<>"></div>
<div><label class="negrilla" >IVA:</label><input type="number" ="iva_producto" value="<>"></div>
<div><label class="negrilla" >NIT Proveedor:</label><input type="number" name="nitproveedor" value="<"></div>
<div><label class="negrilla" >Nombre Producto:</label><input type="text" name="nombre_producto" value="<>"></div>
<div><label class="negrilla" >Precio Compra:</label><input type="number" name="precio_producto" value="<>"></div>
<div><label class="negrilla" >Precio Venta:</label><input type="number" name="precio_venta_producto" value="<>"></div>
 -->
 
<div><label>Archivo: </label><input type="file" name="archivo" value="Examinar" accept="application/vnd.ms-excel"></div>
<input type="submit" name="cargar" value="Cargar Archivo">
<input type="submit" name="actualizar" value="Actualizar">
</form>




</body>
</html>