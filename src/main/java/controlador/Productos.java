package controlador;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.swing.JOptionPane;

import modelo.ProductosDAO;
import modelo.ProductosDTO;
import modelo.ProveedoresDTO;

/**
 * Servlet implementation class Productos
 */
@WebServlet("/Productos")
@MultipartConfig
public class Productos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Productos() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductosDAO prodDao= new ProductosDAO();
		
		
		if (request.getParameter("cargar")!=null) {
			
			JOptionPane.showMessageDialog(null, "PRUEBA");
			ProductosDAO prodDAO= new ProductosDAO();
			Part archivo=request.getPart("archivo");
			String Url= "/Users/mcalderon/Documents/MINTIC/CICLO 3/equipo04_grupo08-main/Tienda Generica v1/src/main/webapp/Documentos/";
		
		//if(archivo.getContentType().equals("application/vnd.ms-excel"))	//USAR ESTA LINEA EN WINDOWS{
			if(archivo.getContentType().equals("text/csv")) { // USAR ESTA LINEA EN MAC
			JOptionPane.showMessageDialog(null, archivo.getContentType());
			JOptionPane.showMessageDialog(null, "PRUEBA 2");	
		try {
			InputStream file= archivo.getInputStream();
			File copia = new File (Url+"prueba08.csv");
			FileOutputStream escribir= new FileOutputStream(copia);
			int num=file.read();
			while (num!=-1) {
				escribir.write(num);
				num=file.read();
			}
			file.close();
			escribir.close();
			JOptionPane.showMessageDialog(null, "Se cargo el archivo correctamente");
			if (prodDAO.Cargar_Productos(Url+"prueba08.csv")) {
				response.sendRedirect("Productos.jsp?men=Se registraron los productos correctamente");
			}else
			{
				response.sendRedirect("Productos.jsp?men=No se registraron los productos");
			}
			}catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Error al cargar el archivo correctamente"+e);
				response.sendRedirect("Productos.jsp?men=Error al cargar el archivo correctamente");
				
			}
			}else
			{
				response.sendRedirect("Productos.jsp?men=Formato no permitido");
			}

		}

		if (request.getParameter("consultar")!=null) {
			int buscar_cod_producto, iva_compra, nitproveedor, precio_compra, precio_venta;
			String nombre_producto;
			
			buscar_cod_producto=Integer.parseInt(request.getParameter("buscar_cod_producto"));
			ProductosDTO prodDto=prodDao.BuscarProducto(buscar_cod_producto);
			if(prodDto!=null) {
			buscar_cod_producto=prodDto.getCodigo_producto();
			iva_compra=prodDto.getIva_compra();
			nitproveedor=prodDto.getNitproveedor();
			precio_compra=prodDto.getPrecio_compra();
			precio_venta=prodDto.getPrecio_venta();
			nombre_producto=prodDto.getNombre_producto();
					
			response.sendRedirect("Productos.jsp?buscar_cod_producto="+buscar_cod_producto+"&&iva_compra="+iva_compra+
			"&&nitproveedor="+nitproveedor+"&&precio_compra="+precio_compra+"&&nombre_producto="+nombre_producto);
					
		}else {
			response.sendRedirect("Proveedores.jsp?men=No se ha encontrado al Proveedor.");
			}
		}
		
		if (request.getParameter("actualizar")!=null) {
			int codigo_producto, iva_compra, nitproveedor, precio_compra, precio_venta;
			String nombre_producto;
					
			codigo_producto=Integer.parseInt(request.getParameter("codigo_producto"));
			iva_compra=Integer.parseInt(request.getParameter("iva_compra"));
			nitproveedor=Integer.parseInt(request.getParameter("nitproveedor"));
			precio_compra=Integer.parseInt(request.getParameter("precio_compra"));
			precio_venta=Integer.parseInt(request.getParameter("precio_venta"));
			nombre_producto=request.getParameter("nombre_producto");

			ProductosDTO prodDto=new ProductosDTO(codigo_producto, iva_compra, nitproveedor, nombre_producto, precio_venta, precio_compra);
			if(prodDao.ActualizarProducto(prodDto)) {
				JOptionPane.showMessageDialog(null,"Se han actualizado los datos del Producto.");
				response.sendRedirect("Proveedores.jsp?men=Se han actualizado los datos del Proveedor.");
			}else {
				JOptionPane.showMessageDialog(null,"No se pudo modificar los datos del Producto.");
				response.sendRedirect("Proveedores.jsp?men=No se pudo modificar los datos del Proveedor.");
					}
				}
		
		
	}	
}