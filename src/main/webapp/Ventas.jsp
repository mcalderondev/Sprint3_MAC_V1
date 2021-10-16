<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/Ventas.css">
<meta charset="ISO-8859-1">
<title>Ventas</title>
</head>
<body>
<h1>Ventas</h1>
<!-- ======================================================================= -->
<%!//	VARIABLES GLOBALES  ====================================================
String nombre_cliente=""; int cedula_cliente;	//Variables Cliente
String nombre_producto=""; int codigo_producto;	//Variables Producto
%>
<%
//		Consultar Cliente  =====================================================
if(request.getParameter("nombre_cliente")!=null){
	nombre_cliente=request.getParameter("nombre_cliente");
	cedula_cliente=Integer.parseInt(request.getParameter("cedula_cliente"));
}

//		Consultar producto 1 ===================================================	
if(request.getParameter("nombre_producto")!=null){
	nombre_producto=request.getParameter("nombre_producto");
	codigo_producto=Integer.parseInt(request.getParameter("codigo_producto"));
}
////////////////////////////////////////////////////////////////////////////////
if(request.getParameter("men")!=null){
	String mensaje=request.getParameter("men");
	out.print("<script type='text/javascript'>alert('"+mensaje+"');</script>");
}
%>
<form action="Ventas" method="post">
<div><label>Cédula Cliente:  </label><input type="number" name="cedula_cliente" value="<%=cedula_cliente%>">
<input type="submit" name="consultar_cedula" value="Consultar"></div>
<div><label>Nombre cliente:  </label><input type="text" name="nombre_cliente" value="<%=nombre_cliente%>"></div>
<input type="reset" value="Limpiar campos">

</form>
<hr>
<form  action="Ventas" method="post">
<div><label>Código de Producto:  </label><input type="number" name="codigo_producto" value="<%=codigo_producto%>">
<input type="submit" name="consultar_codigo" value="Consultar Producto"></div>
<div><label>Nombre producto:  </label><input type="text" name="nombre_producto" value="<%=nombre_producto%>"></div>
<div><label>Cantidad:  </label><input type="number" name="cantidad" value="cantidad"></div>
<div><label>Vlr. Total:  </label><input type="number" name="valor_total"></div>


</form>


</body>
</html>