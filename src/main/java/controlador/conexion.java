package controlador;

import javax.swing.JOptionPane;
import java.sql.*;

public class conexion {
	private String bd="Grupo8_Equipo_4";
	private String url="jdbc:mariadb://prestamosvf.czo3ixoe3xoe.us-east-1.rds.amazonaws.com/"+bd;
	private String login="admin";
	private String password="Ciclo3_admi123";
	Connection con=null;
	
	public Connection Conecta() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url,login,password);
			JOptionPane.showMessageDialog(null,"Conexion OK");
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null,"Error al conectar la base de datos"+e);
		}
		return con;
	}
	Connection prueba =Conecta();
}
