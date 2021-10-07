package modelo;

import java.sql.SQLException;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import controlador.conexion;

/**
 * Servlet implementation class PRODUCTOSDAO
 */
@WebServlet("/PRODUCTOSDAO")
public class ProductosDAO extends HttpServlet {
	
	conexion cnn = new conexion();
	Connection con=cnn.Conecta();
	PreparedStatement ps=null;
	ResultSet res=null;
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductosDAO() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	
	public boolean Cargar_Productos(String URL) {
	
		boolean resul=false;
		try {
			
		String sql="load data infile '"+URL+"' into table productos fields terminated by ',' lines terminated by '\r\n'";	
		ps = con.prepareStatement(sql);
		resul=ps.executeUpdate()>0;
		
		}catch (SQLException ex) {
			JOptionPane.showMessageDialog(null,"Error al registrar productos"+ ex);
		}
		
		return resul;
	
	}
		
}

