$(document).ready(function(){
	
alert()
//==============================================================================
//		LISTA USUARIOS
//==============================================================================		
function ListaUsuarios(){
	
	$.ajax({
		type:"post",
		url:"Reportes",
		dataType:"json",
		data:{opcion:"usuarios"},
		success: function(result){
			console.log(result)
			var tabla=document.querySelector(".tabla")
			tabla.innerHTML=''
			
			tabla.innerHTML+=`<tr>
			<th>Cedula</th>
			<th>Email</th>
			<th>Nombre</th>
			<th>Password</th>
			<th>Usuario</th>
			</tr>`
			for(let fila of result){
				tabla.innerHTML+=`<tr>
				<td>${fila.cedula_usuario}</td>
				<td>${fila.email_usuario}</td>
				<td>${fila.nombre_usuario}</td>
				<td>${fila.password}</td>
				<td>${fila.usuario}</td>
				</tr>`
			}
		}
	})
	}
//==============================================================================
//		LISTA CLIENTES
//==============================================================================
function ListaClientes(){
	
	$.ajax({
		type:"post",
		url:"Reportes",
		dataType:"json",
		data:{opcion:"clientes"},
		success: function(result){
			console.log(result)
			var tabla=document.querySelector(".tabla")
			tabla.innerHTML=''
			
			tabla.innerHTML+=`<tr>
			<th>Cedula</th>
			<th>Direccion</th>
			<th>Email</th>
			<th>Nombre</th>
			<th>Telefono</th>
			</tr>`
			for(let fila of result){
				tabla.innerHTML+=`<tr>
				<td>${fila.cedula_cliente}</td>
				<td>${fila.direccion_cliente}</td>
				<td>${fila.email_cliente}</td>
				<td>${fila.nombre_cliente}</td>
				<td>${fila.telefono_cliente}</td>
				</tr>`
			}
		}
	})
	}
////////////////////////////////////////////////////////////////////////////////
$('.usuarios').on('click',function(){
	
		ListaUsuarios()
	})
	
$('.clientes').on('click',function(){
	
		ListaClientes()
	})
	
	})

	