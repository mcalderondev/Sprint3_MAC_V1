<%@ page language="java" contentType="text/html; charset=>UTF-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Tienda generica</title>
<link rel="stylesheet" href="css/login.css">
</head>
<body class="fondo">
<div><h1 class="InicioSesion">Bienvenidos a la Tienda Generica</h1></div>
<form action="login" method="post">
<br>
<div class="texto"><label>Usuario</label><input type="text" name="usuario"></div>
<div class="texto"><label>Contraseña</label><input type="password" name="pass"></div>
<br>
<div class="botones"><input type=submit name=enviar value="Ingresar">
<a href="index.jsp"><input type="button" name="cancelar" value="Cancelar"></a></div>

</form>
</body>
</html>