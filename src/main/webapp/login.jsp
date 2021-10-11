<%@ page language="java" contentType="text/html; charset=>ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <!DOCTYPE html>
    <html>
    <head>
    <meta charset="ISO-8859-1">
    <title>Tienda generica</title>
    <link rel="stylesheet" href="css/login.css">
    </head>
    <body>
    <div>
        <h1>Bienvenidos a la Tienda Genérica</h1>
    </div>
    <form action="login" method="post">
    <br>
    <div class="user">
        <label class="title-user">Usuario</label>
        <input type="text" class="input-title" name="usuario" placeholder="Escriba su usuario" required>
    </div>
    <br>
    <div class="password_form">
        <label class="title-password">Contraseña</label>
        <input class="input-title" type="password" name="pass" placeholder="Escriba su contraseña" required>
    </div>
    <br>
    <div class="botones">
        <div>
            <input class="btn-ingresar" type="submit" name=enviar value="Ingresar">
        </div>
        <div>
            <a href="index.jsp">
                <input class="btn-cancelar" type="button" name="cancelar" value="Cancelar">
            </a>
        </div>
    </div>
    
    
    </form>
    </body>
    </html>