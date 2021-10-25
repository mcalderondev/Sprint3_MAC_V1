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
import modelo.DetalleVentasDTO;
import modelo.ProductosDAO;
import modelo.ProductosDTO;
import modelo.VentasDAO;
import modelo.VentasDTO;

@WebServlet("/Ventas")
public class Ventas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Ventas() {
        super();
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	VentasDAO registroVenta = new VentasDAO();
		
//==============================================================================
				///CONSULTAR PRODUCTO
//==============================================================================
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
				////
				double iva=producto.getIvacompra();
				double precio_venta=producto.getPrecio_venta();
				
				
				response.sendRedirect("Ventas.jsp?codigo_producto="+codigo_producto+"&&nombre_producto="+nombre_producto+
						"&&iva="+iva+"&&precio_venta="+precio_venta);
			}else {
				response.sendRedirect("Ventas.jsp?men=No se encontro el producto");
			}
		}
//==============================================================================
				//CONFIRMAR VENTA
//==============================================================================		
		if (request.getParameter("confirmar")!=null) {
			int cantidad_producto,codigo_producto,
			cedula_cliente,cedula_usuario;
			double ivaventa,total_venta,valor_venta,valor_total,valoriva,
			precio_venta;
			
			
			cantidad_producto=Integer.parseInt(request.getParameter("cantidad"));
			codigo_producto=Integer.parseInt(request.getParameter("codigo_producto"));
			
			cedula_cliente=Integer.parseInt(request.getParameter("cedula_cliente"));
			cedula_usuario=Integer.parseInt(request.getParameter("cedula_usuario"));
			
			valoriva=Double.parseDouble(request.getParameter("iva"));
			ivaventa=valoriva*cantidad_producto;
						precio_venta=Double.parseDouble(request.getParameter("precio_venta"));
			
			valor_venta=cantidad_producto*precio_venta;
			total_venta=(precio_venta+valoriva)*cantidad_producto;	
			valor_total=(precio_venta+valoriva)*cantidad_producto;	
			
			VentasDTO venta=new VentasDTO(cedula_cliente,cedula_usuario,ivaventa,total_venta,valor_venta);
			DetalleVentasDTO detalles=new DetalleVentasDTO(cantidad_producto,codigo_producto,
					valor_total,valor_venta,valoriva);
			
			if(registroVenta.RegistrarVenta(venta)&&registroVenta.DetalleVentas(detalles)){
				
				JOptionPane.showMessageDialog(null,"Venta registrada");
				response.sendRedirect("Ventas.jsp?ivaventa="+ivaventa+"&&valor_venta="+valor_venta+"&&total_venta"+total_venta);//	redireccionar pagina
			}else {
				JOptionPane.showMessageDialog(null,"No se ha registrado la venta");
				response.sendRedirect("Ventas.jsp");
			}
		}
//==============================================================================
		
	}
}