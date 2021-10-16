package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.ClientesDAO;
import modelo.ClientesDTO;
import modelo.ProductosDAO;
import modelo.ProductosDTO;

@WebServlet("/Ventas")
public class Ventas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Ventas() {
        super(); 
    }
    
//==============================================================================
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if (request.getParameter("consultar_cedula")!=null){
			int cedula_cliente=Integer.parseInt(request.getParameter("cedula_cliente"));
			ClientesDAO ventasDao = new ClientesDAO();
			ventasDao.BuscarCiente(cedula_cliente);
			ClientesDTO cliente = ventasDao.BuscarCiente(cedula_cliente);
			if(cliente!=null) {
				String nombre_cliente=cliente.getNombre_cliente();
				cedula_cliente=cliente.getCedula_cliente();
				response.sendRedirect("Ventas.jsp?cedula_cliente="+cedula_cliente+"&&nombre_cliente="+nombre_cliente);
			}else {
				response.sendRedirect("Ventas.jsp?men=No se encontro al cliente");
			}
		}
//==============================================================================
		///CONSULTAR PRODUCTO
//==============================================================================	
		if (request.getParameter("consultar_codigo")!=null){
			int codigo_producto=Integer.parseInt(request.getParameter("codigo_producto"));
			ProductosDAO productDao = new ProductosDAO();//
			productDao.BuscarProducto(codigo_producto);
			ProductosDTO producto = productDao.BuscarProducto(codigo_producto);
			if(producto!=null) {
				String nombre_producto=producto.getNombre_producto();
				codigo_producto=producto.getCodigo_producto();
				response.sendRedirect("Ventas.jsp?codigo_producto="+codigo_producto+"&&nombre_producto="+nombre_producto);
			}else {
				response.sendRedirect("Ventas.jsp?men=No se encontro el producto");
			}
		}
//==============================================================================
	}

}
