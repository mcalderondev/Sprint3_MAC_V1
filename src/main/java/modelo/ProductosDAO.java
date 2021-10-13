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

	public boolean ActualizarProducto(ProductosDTO prod) {
		boolean result=false;
		try {
			String sql="update proveedores set ciudad_proveedor=?,direccion_proveedor=?,nombre_proveedor=?,telefono_proveedor=? where nitproveedor=?";
			ps=con.prepareStatement(sql);
			ps.setInt(1, prod.getCodigo_producto());
			ps.setInt(2, prod.getIva_compra());
			ps.setInt(3, prod.getPrecio_compra());
			ps.setInt(4, prod.getPrecio_venta());
			ps.setInt(5, prod.getNitproveedor());
			ps.setString(6, prod.getNombre_producto());
			result=ps.executeUpdate()>0;
		}catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error al actualizar"+ex);
			
		}
		return result;
	}
	
	
}
