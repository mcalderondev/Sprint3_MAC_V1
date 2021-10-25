package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import modelo.ClientesDAO;
import modelo.ClientesDTO;

@WebServlet("/Clientes")
public class Clientes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Clientes() {
        super();
    }
    //==========================================================================
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	ClientesDAO clienteDao = new ClientesDAO();
		//======================================================================
		// INSERTAR CLIENTE
		//======================================================================
		if (request.getParameter("insertar")!=null) {
			int cedula_cliente;
			String direccion_cliente, email_cliente, nombre_cliente, telefono_cliente;
			cedula_cliente=Integer.parseInt(request.getParameter("cedula_cliente"));
			direccion_cliente=request.getParameter("direccion_cliente");
			email_cliente=request.getParameter("email_cliente");
			nombre_cliente=request.getParameter("nombre_cliente");
			telefono_cliente=request.getParameter("telefono_cliente");
			ClientesDTO clienteDto=new ClientesDTO(cedula_cliente,direccion_cliente,email_cliente,nombre_cliente,telefono_cliente);
			if (clienteDao.InsertarCliente(clienteDto)) {
				//JOptionPane.showMessageDialog(null,"Registro exitoso");
				response.sendRedirect("Clientes.jsp");//	redireccionar pagina
			}else {
				//JOptionPane.showMessageDialog(null,"No se ha registrado al Cliente");
				response.sendRedirect("Clientes.jsp");
			}
		}
		//======================================================================
		// CONSULTAR USUARIO
		//======================================================================
		if (request.getParameter("consultar")!=null) {
			
			int buscar_cedula;
			String direccion_cliente, email_cliente, nombre_cliente, telefono_cliente;
			
			buscar_cedula=Integer.parseInt(request.getParameter("buscar_cedula"));
			ClientesDTO clienteDto=clienteDao.BuscarCiente(buscar_cedula);
			if(clienteDto!=null) {
			buscar_cedula=clienteDto.getCedula_cliente();
			direccion_cliente=clienteDto.getDireccion_cliente();
			email_cliente=clienteDto.getEmail_cliente();
			nombre_cliente=clienteDto.getNombre_cliente();
			telefono_cliente=clienteDto.getTelefono_cliente();
					
			response.sendRedirect("Clientes.jsp?buscar_cedula="+buscar_cedula+"&&direccion_cliente="+direccion_cliente+
			"&&email_cliente="+email_cliente+"&&nombre_cliente="+nombre_cliente+"&&telefono_cliente="+telefono_cliente);
				
		}else {
			response.sendRedirect("Clientes.jsp?men=No se ha encontrado el cliente.");
		}
	}	
		//======================================================================
		// ACTUALIZAR CLIENTE
		//======================================================================
		if (request.getParameter("actualizar")!=null) {
			int cedula_cliente;
			String direccion_cliente, email_cliente, nombre_cliente, telefono_cliente;
			
			cedula_cliente=Integer.parseInt(request.getParameter("cedula_cliente"));
			direccion_cliente=request.getParameter("direccion_cliente");
			email_cliente=request.getParameter("email_cliente");
			nombre_cliente=request.getParameter("nombre_cliente");
			telefono_cliente=request.getParameter("telefono_cliente");
			ClientesDTO clienteDto=new ClientesDTO(cedula_cliente,direccion_cliente,email_cliente,nombre_cliente,telefono_cliente);
			if(clienteDao.ActualizarCliente(clienteDto)) {
				//JOptionPane.showMessageDialog(null,"Se han actualizado los datos del cliente.");
				response.sendRedirect("Clientes.jsp?men=Se han actualizado los datos del cliente.");
			}else {
				//JOptionPane.showMessageDialog(null,"No se pudo modificar los datos del Usuario.");
				response.sendRedirect("Clientes.jsp?men=No se pudo modificar los datos del cliente.");

			}
		}
		//======================================================================
		// ELIMINAR CLIENTE
		//======================================================================
		if (request.getParameter("eliminar")!=null) {
			int cedula_cliente;
			cedula_cliente=Integer.parseInt(request.getParameter("cedula_cliente"));
			//int op=JOptionPane.showConfirmDialog(null, "¿Desea eliminar este cliente?");
			//if(op==0) {
			if(request.getParameter("eliminar")!=null) {
				if (clienteDao.EliminarCliente(cedula_cliente)) {
					response.sendRedirect("Clientes.jsp?men=Cliente eliminado.");
				}else {
					response.sendRedirect("Clientes.jsp?men=No se elimino al cliente.");

				}
			}else {
				response.sendRedirect("Clientes.jsp");
			}
			
		}
		
	//==========================================================================	
	}

}
