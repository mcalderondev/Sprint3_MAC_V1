<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ventas</title>
</head>
<body>
<h1>Ventas</h1>
<!-- ======================================================================= -->
<%!//	VARIABLES GLOBALES  ====================================================
String nombre_cliente=""; 	int cedula_cliente;	//Variables Cliente
String nombre_producto=""; 	int codigo_producto;	//Variables Producto
double iva, precio_venta; 	double valor_venta,total_venta,ivaventa; //Variables confirmar venta


		
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
	
	iva=Double.parseDouble(request.getParameter("iva"));
	precio_venta=Double.parseDouble(request.getParameter("precio_venta"));
}
////////////////////////////////////////////////////////////////////////////////
if(request.getParameter("men")!=null){
	String mensaje=request.getParameter("men");
	out.print("<script type='text/javascript'>alert('"+mensaje+"');</script>");
}
////////////////////////////////////////////////////////////////////////////////
if(request.getParameter("confirmar")!=null){
	valor_venta=Double.parseDouble(request.getParameter("valor_venta"));
	total_venta=Double.parseDouble(request.getParameter("total_venta"));
	ivaventa=Double.parseDouble(request.getParameter("ivaventa"));
}
%>
<form action="Ventas" method="post">
	<div><label>Cédula Cliente:</label><input type="number" name="cedula_cliente" value="<%=cedula_cliente%>">
		<input type="submit" name="consultar_cedula" value="Consultar">
		<label>Nombre cliente:</label><input type="text" name="nombre_cliente" value="<%=nombre_cliente%>">
		<div><label>Cedula Usuario</label><input type="number" name="cedula_usuario"></div>

	</div>
</form>
<hr>

<form  action="Ventas" method="post">
	<div><label>Código de Producto:</label><input type="number" name="codigo_producto" value="<%=codigo_producto%>">
		<input type="submit" name="consultar_codigo" value="Consultar Producto">
		<input type="text" name="nombre_producto" placeholder="Nombre del Producto" value="<%=nombre_producto%>">
		<label>Cantidad:</label><input type="number" name="cantidad" value="cantidad" min="1">
				<input type="hidden" name="iva" value="<%=iva%>">
				<input type="hidden" name="precio_venta" value="<%=precio_venta%>">
		
		<label>Vlr. Total:</label><input type="number" name="valor_total" value="<%=valor_venta%>">	
	</div>
	<div><input type="submit" name="confirmar" value="Confirmar"></div>
</form>		
		

		
<br>
	<div>
		<label>Total Venta</label>
		<input type="text" value="<%=valor_venta%>">
	</div>

	<div>
		<label>Total IVA</label>	<!--  -->
		<input type="text" value="<%=ivaventa%>">
	</div>

	<div>
		<label>Total venta con IVA</label>
		<input type="text" value="<%=total_venta%>">
	</div>


</body>
</html>