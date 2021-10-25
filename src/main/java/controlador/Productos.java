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

import modelo.ProductosDAO;
import modelo.ProductosDTO;


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
		
//==============================================================================
		//cargar archivo
//==============================================================================		
		if (request.getParameter("cargar")!=null) {
			
			//JOptionPane.showMessageDialog(null, "PRUEBA");
			ProductosDAO prodDAO= new ProductosDAO();
			Part archivo=request.getPart("archivo");
			String Url= "/Users/mcalderon/Documents/MINTIC/CICLO 3/equipo04_grupo08-main/Tienda Generica v1/src/main/webapp/Documentos/";
		
		//if(archivo.getContentType().equals("application/vnd.ms-excel"))	//USAR ESTA LINEA EN WINDOWS{
			if(archivo.getContentType().equals("text/csv")) { // USAR ESTA LINEA EN MAC
			//JOptionPane.showMessageDialog(null, archivo.getContentType());
			//JOptionPane.showMessageDialog(null, "PRUEBA 2");	
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
			//JOptionPane.showMessageDialog(null, "Se cargo el archivo correctamente");
			if (prodDAO.Cargar_Productos(Url+"prueba08.csv")) {
				response.sendRedirect("Productos.jsp?men=Se registraron los productos correctamente");
			}else
			{
				response.sendRedirect("Productos.jsp?men=No se registraron los productos");
			}
			}catch (Exception e) {
				//JOptionPane.showMessageDialog(null, "Error al cargar el archivo correctamente"+e);
				response.sendRedirect("Productos.jsp?men=Error al cargar el archivo correctamente");
				
			}
			}else
			{
				response.sendRedirect("Productos.jsp?men=Formato no permitido");
			}

		}
//==============================================================================
    	// CONSULTAR PRODUCTO
//==============================================================================    	
		if (request.getParameter("consultar_codigo")!=null){
			int codigo_producto=Integer.parseInt(request.getParameter("codigo_producto"));
			
			prodDao.BuscarProducto(codigo_producto);
			ProductosDTO producto = prodDao.BuscarProducto(codigo_producto);
			if(producto!=null) {
				
				codigo_producto=producto.getCodigo_producto();
				double ivacompra=producto.getIvacompra();
				int nitproveedor=producto.getNitproveedor();
				String nombre_producto=producto.getNombre_producto();
				double precio_compra=producto.getPrecio_compra();
				double precio_venta=producto.getPrecio_venta();
				
				response.sendRedirect("Productos.jsp?codigo_producto="+codigo_producto+"&&ivacompra="+ivacompra+
						"&&nitproveedor="+nitproveedor+"&&nombre_producto="+nombre_producto+"&&precio_compra="+precio_compra+
						"&&precio_venta="+precio_venta);
			}else {
				response.sendRedirect("Productos.jsp?men=No se encontro el producto");
			}
		}
//==============================================================================
	}	
}