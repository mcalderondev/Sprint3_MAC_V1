package controlador;

import javax.swing.JOptionPane;
import java.sql.*;

public class conexion {
	private String db="tienda_generica";
	private String url="jdbc:mysql://localhost:3306/"+db;
	private String user="root";
	private String pass="";
	Connection con=null;
	
	public Connection Conecta() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url,user,pass);
			JOptionPane.showMessageDialog(null,"Conexion OK");
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null,"Error al conectar la base de datos"+e);
		}
		return con;
	}
	Connection prueba =Conecta();
}
