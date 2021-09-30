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
		
		if (request.getParameter("cargar")!=null) {
			Part archivo=request.getPart("archivo");
			String Url= "Macintosh HD/Users/mcalderon/Documents/MINTIC/CICLO 3/equipo04_grupo08-main/Tienda Generica v1/src/main/webapp/Documentos\\";
		
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
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al cargar el archivo correctamente"+e);
		}
		
	}

}
}	
