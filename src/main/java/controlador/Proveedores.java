package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import modelo.ProveedoresDAO;
import modelo.ProveedoresDTO;

@WebServlet("/Proveedores")
public class Proveedores extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Proveedores() {
        super();
    }
    //==========================================================================
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProveedoresDAO provDao= new ProveedoresDAO();
		//======================================================================
		// INSERTAR PROVEEDOR
		//======================================================================
		if (request.getParameter("insertar")!=null) {
			int nitproveedor;
			String ciudad_proveedor, direccion_proveedor, nombre_proveedor, telefono_proveedor;
			nitproveedor=Integer.parseInt(request.getParameter("nitproveedor"));
			ciudad_proveedor=request.getParameter("ciudad_proveedor");
			direccion_proveedor=request.getParameter("direccion_proveedor");
			nombre_proveedor=request.getParameter("nombre_proveedor");
			telefono_proveedor=request.getParameter("telefono_proveedor");
			ProveedoresDTO provDto=new ProveedoresDTO(nitproveedor,ciudad_proveedor,direccion_proveedor,nombre_proveedor,telefono_proveedor);
			if (provDao.InsertarProveedor(provDto)) {
				JOptionPane.showMessageDialog(null,"Registro exitoso");
				response.sendRedirect("Proveedores.jsp");//	redireccionar pagina
			}else {
				JOptionPane.showMessageDialog(null,"No se ha registrado al Proveedor");
				response.sendRedirect("Proveedores.jsp");
			}
		}	
		//======================================================================
		// CONSULTAR PROVEEDOR
		//======================================================================
		if (request.getParameter("consultar")!=null) {
			int buscar_nit;
			String ciudad_proveedor, direccion_proveedor, nombre_proveedor, telefono_proveedor;
			
			buscar_nit=Integer.parseInt(request.getParameter("buscar_nit"));
			ProveedoresDTO provDto=provDao.BuscarProveedor(buscar_nit);
			if(provDto!=null) {
			buscar_nit=provDto.getNitproveedor();
			ciudad_proveedor=provDto.getCiudad_proveedor();
			direccion_proveedor=provDto.getDireccion_proveedor();
			nombre_proveedor=provDto.getNombre_proveedor();
			telefono_proveedor=provDto.getTelefono_proveedor();
					
			response.sendRedirect("Proveedores.jsp?buscar_nit="+buscar_nit+"&&ciudad_proveedor="+ciudad_proveedor+
			"&&direccion_proveedor="+direccion_proveedor+"&&nombre_proveedor="+nombre_proveedor+"&&telefono_proveedor="+telefono_proveedor);
					
		}else {
			response.sendRedirect("Proveedores.jsp?men=No se ha encontrado al Proveedor.");
			}
		}
		//======================================================================
		// ACTUALIZAR PROVEEDOR
		//======================================================================
		if (request.getParameter("actualizar")!=null) {
			int nitproveedor;
			String ciudad_proveedor, direccion_proveedor, nombre_proveedor, telefono_proveedor;
					
			nitproveedor=Integer.parseInt(request.getParameter("nitproveedor"));
			ciudad_proveedor=request.getParameter("ciudad_proveedor");
			direccion_proveedor=request.getParameter("direccion_proveedor");
			nombre_proveedor=request.getParameter("nombre_proveedor");
			telefono_proveedor=request.getParameter("telefono_proveedor");
			ProveedoresDTO provDto=new ProveedoresDTO(nitproveedor,ciudad_proveedor,direccion_proveedor,nombre_proveedor,telefono_proveedor);
			if(provDao.ActualizarProveedor(provDto)) {
				JOptionPane.showMessageDialog(null,"Se han actualizado los datos del Proveedor.");
				response.sendRedirect("Proveedores.jsp?men=Se han actualizado los datos del Proveedor.");
			}else {
				JOptionPane.showMessageDialog(null,"No se pudo modificar los datos del Proveedor.");
				response.sendRedirect("Proveedores.jsp?men=No se pudo modificar los datos del Proveedor.");
					}
				}
		//======================================================================
		// ELIMINAR USUARIO
		//======================================================================
		if (request.getParameter("eliminar")!=null) {
			int nitproveedor;
			nitproveedor=Integer.parseInt(request.getParameter("nitproveedor"));
			int op=JOptionPane.showConfirmDialog(null, "¿Desea eliminar este proveedor?");
			if(op==0) {
				if (provDao.EliminarProveedor(nitproveedor)) {
					response.sendRedirect("Proveedores.jsp?men=Proveedor eliminado.");
				}else {
					response.sendRedirect("Proveedores.jsp?men=No se elimino al proveedor.");

				}
			}else {
				response.sendRedirect("Proveedores.jsp");
			}
		}
		//======================================================================
	}
}
