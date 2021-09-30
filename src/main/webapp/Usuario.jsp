<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Usuario</title>
 <link rel="stylesheet" href="css/Usuario.css">
</head>
<body class="fondo1" >
<!--VARIABLES GLOBALES-->
<%!	
int buscar_cedula;
String email_usuario="", nombre_usuario="", password="", usuario="";%>
<%
if(request.getParameter("buscar_cedula")!=null){

buscar_cedula=Integer.parseInt(request.getParameter("buscar_cedula"));
email_usuario=request.getParameter("email_usuario");
nombre_usuario=request.getParameter("nombre_usuario");
password=request.getParameter("password");
usuario=request.getParameter("usuario");
}
if(request.getParameter("men")!=null){
	String mensaje=request.getParameter("men");
	out.print("<script type='text/javascript'>alert('"+mensaje+"');</script>");
}
%>
<h1>Usuarios</h1>
<form action="Usuario" method="post">
<div class="texto_principal" ><label class="negrilla" >Cédula Usuario:</label><input class="caja_cedula_usuario" type="number" name="cedula_usuario" pattern="[1-9]+" title="digite solo numeros" value="<%=buscar_cedula%>"></div>
<div class="texto_principal" ><label class="negrilla" >Email Usuario:</label><input class="caja_email_usuario" type="text" name="email_usuario" value="<%=email_usuario%>"></div>
<div class="texto_principal" ><label class="negrilla" >Nombre Usuario:</label><input type="text" name="nombre_usuario" value="<%=nombre_usuario%>"></div>
<div class="texto_principal" ><label class="negrilla" >Password:</label><input class="caja_password_usuario" type="password" name="password" value="<%=password%>"></div>
<div class="texto_principal" ><label class="negrilla" >Usuario:</label><input class="caja_usuario" type="text" name="usuario" value="<%=usuario%>"></div>

<div class="botones_usuario" ><input class="size_botones" type="submit" name="insertar" value="Registrar">

<input type="submit" name="actualizar" value="Actualizar">
<input type="submit" name="eliminar" value="Eliminar"></div>
</form>
<hr>
<form action="Usuario" method="post">

<fieldset>
<legend>Consultar Usuario</legend>
<div><label>Cédula Usuario:</label><input type="number" name="buscar_cedula">
<input type="submit" name="consultar" value="Consultar"></div>
</fieldset>
</form>
</body>
</html>