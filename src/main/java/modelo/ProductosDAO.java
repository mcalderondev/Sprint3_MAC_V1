package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import controlador.conexion;

public class ProductosDAO {

	conexion cnn = new conexion();
	Connection con=cnn.Conecta();
	PreparedStatement ps=null;
	ResultSet res=null;
	
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
