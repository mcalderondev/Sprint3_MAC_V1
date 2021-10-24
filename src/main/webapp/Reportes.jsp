<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/Clientes.css">

<meta charset="ISO-8859-1">

<script type="text/javascript" src=js/jquery-3.6.0.min.js></script>
<script type="text/javascript" src=js/Reportes.js></script>

<title>Reportes</title>
    <style>
    	
        tabla{
            border-collapse: collapse;
            border-spacing: 0;
            background-color: #ff33cc;
            
        }
        td{
        	background-color: rgb(253, 254, 254);
            padding: 10px 20px;
            border: 2px solid #000;
            border-color: #FFFFFF;
            font-size: 18px;
    		font-family: 'Open Sans Condensed';
    		
    		text-align: center;
		
        }
        th{
        	background-color: rgb(120, 120, 243);
            padding: 10px 20px;
            border: 2px solid #000;
            border-color: #7878F3;
            font-size: 16px;
    		font-family: 'Open Sans Condensed';
    		color: white;
    		text-align: center;
        }

    </style>
</head>
<body>
<h1>Reportes</h1>
<br>
		<div class="botones">
	<button class="usuarios">Listado Usuarios</button>
	<button class="clientes">Listado Clientes</button>
	<button class="ventas">Listado Ventas</button>
		</div>
<br>
<br>
		<div align='center'>
	<table class="tabla">
	</table>
		</div>
</body>
</html>
</html>