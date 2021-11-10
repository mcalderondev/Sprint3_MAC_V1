package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import modelo.ClientesDAO;
import modelo.ClientesDTO;
import modelo.UsuarioDAO;
import modelo.UsuarioDTO;
import modelo.VentasDAO;
import modelo.VentasDTO;

@WebServlet("/Reportes")
public class Reportes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Reportes() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String op=request.getParameter("opcion");
		PrintWriter salida=response.getWriter();
		Gson datos=new Gson();
		//======================================================================
		//		BOTON USUARIOS
		//======================================================================
		if(op.equals("usuarios")) {
			UsuarioDAO userDao = new UsuarioDAO();
			ArrayList<UsuarioDTO> lista=new ArrayList<>();
			lista=userDao.ListadoUsuarios();
			salida.println(datos.toJson(lista));
		}
		//======================================================================
		//		BOTON CLIENTES
		//======================================================================
		if(op.equals("clientes")) {
			ClientesDAO clienteDao = new ClientesDAO();
			ArrayList<ClientesDTO> lista=new ArrayList<>();
			lista=clienteDao.ListadoClientes();
			salida.println(datos.toJson(lista));
		}
		
//==============================================================================
	if(op.equals("ventas")) {
		VentasDAO ventasDao = new VentasDAO();
		ArrayList<VentasDTO> lista=new ArrayList<>();
		lista=ventasDao.ListadoVentas();
		salida.println(datos.toJson(lista));
	}

}
}
