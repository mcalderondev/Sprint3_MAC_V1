package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import modelo.UsuarioDAO;
import modelo.UsuarioDTO;

@WebServlet("/Usuario")
public class Usuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Usuario() {
        super();
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UsuarioDAO userDao= new UsuarioDAO();
		//======================================================================
		// INSERTAR USUARIO
		//======================================================================
		if (request.getParameter("insertar")!=null) {
			int cedula_usuario;
			String email_usuario, nombre_usuario, password, usuario;
			cedula_usuario=Integer.parseInt(request.getParameter("cedula_usuario"));
			email_usuario=request.getParameter("email_usuario");
			nombre_usuario=request.getParameter("nombre_usuario");
			password=request.getParameter("password");
			usuario=request.getParameter("usuario");
			UsuarioDTO userDto=new UsuarioDTO(cedula_usuario,email_usuario,nombre_usuario,password,usuario);
			if (userDao.InsertarUsuario(userDto)) {
				JOptionPane.showMessageDialog(null,"Registro exitoso");
				response.sendRedirect("Usuario.jsp");//	redireccionar pagina
			}else {
				JOptionPane.showMessageDialog(null,"No se ha registrado el Usuario");
				response.sendRedirect("Usuario.jsp");
			}
		}
		//======================================================================
		// CONSULTAR USUARIO
		//======================================================================
		if (request.getParameter("consultar")!=null) {
			int buscar_cedula;
			String email_usuario, nombre_usuario, password, usuario;
			
			buscar_cedula=Integer.parseInt(request.getParameter("buscar_cedula"));
			UsuarioDTO userDto=userDao.BuscarUsuario(buscar_cedula);
			if(userDto!=null) {
			buscar_cedula=userDto.getCedula_usuario();
			email_usuario=userDto.getEmail_usuario();
			nombre_usuario=userDto.getNombre_usuario();
			password=userDto.getPassword();
			usuario=userDto.getUsuario();
			
			response.sendRedirect("Usuario.jsp?buscar_cedula="+buscar_cedula+"&&email_usuario="+email_usuario+
			"&&nombre_usuario="+nombre_usuario+"&&password="+password+"&&usuario="+usuario);
			
		}else {
			response.sendRedirect("Usuario.jsp?men=No se ha encontrado el Usuario.");
		}
		}
		//======================================================================
		// ACTUALIZAR USUARIO
		//======================================================================
		if (request.getParameter("actualizar")!=null) {
			int cedula_usuario;
			String email_usuario, nombre_usuario, password, usuario;
			
			cedula_usuario=Integer.parseInt(request.getParameter("cedula_usuario"));
			email_usuario=request.getParameter("email_usuario");
			nombre_usuario=request.getParameter("nombre_usuario");
			password=request.getParameter("password");
			usuario=request.getParameter("usuario");
			UsuarioDTO userDto=new UsuarioDTO(cedula_usuario,email_usuario,nombre_usuario,password,usuario);
			if(userDao.ActualizarUsuario(userDto)) {
				JOptionPane.showMessageDialog(null,"Se han actualizado los datos del Usuario.");
				response.sendRedirect("Usuario.jsp?men=Se han actualizado los datos del Usuario.");
			}else {
				JOptionPane.showMessageDialog(null,"No se pudo modificar los datos del Usuario.");
				response.sendRedirect("Usuario.jsp?men=No se pudo modificar los datos del Usuario.");

			}
		}
		//======================================================================
		// ELIMINAR USUARIO
		//======================================================================
		if (request.getParameter("eliminar")!=null) {
			int cedula_usuario;
			cedula_usuario=Integer.parseInt(request.getParameter("cedula_usuario"));
			int op=JOptionPane.showConfirmDialog(null, "¿Desea eliminar este usuario?");
			if(op==0) {
				if (userDao.EliminarUsuario(cedula_usuario)) {
					response.sendRedirect("Usuario.jsp?men=Usuario eliminado.");
				}else {
					response.sendRedirect("Usuario.jsp?men=No se elimino al usuario.");

				}
			}else {
				response.sendRedirect("Usuario.jsp");
			}
			
		}
		
	}

}
