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
		
		boolean result=false;
		try {
			
		String sql="load data infile '"+URL+"' into table productos fields terminated by ',' lines terminated by '\r\n'";	
		ps = con.prepareStatement(sql);
		result=ps.executeUpdate()>0;
		
		}catch (SQLException ex) {
			JOptionPane.showMessageDialog(null,"Error al registrar productos"+ ex);
		}
		
		return result;
	
	}
//==============================================================================
//	CONSULTAR PRODUCTO		OK
//==============================================================================
public ProductosDTO BuscarProducto(int consultar_codigo) {
ProductosDTO producto=null;
try {
	String sql="select * from productos where codigo_producto=?";
	ps=con.prepareStatement(sql);
	ps.setInt(1,consultar_codigo);	
	res=ps.executeQuery();
	while(res.next()) {
		producto=new ProductosDTO(res.getInt(1),res.getDouble(2),res.getInt(3),res.getString(4),res.getDouble(5),res.getDouble(6));
	}
}catch(SQLException ex){
	JOptionPane.showMessageDialog(null, "No se pudo consultar el cliente"+ex);
}
return producto;
}
//==============================================================================	

	public boolean ActualizarProducto(ProductosDTO prod) {
		boolean result=false;
		try {
			String sql="update productos set ivacompra=?,nitproveedor=?,nombre_producto=?,precio_compra=?, precio_venta where codigo_producto=?";
			
			ps=con.prepareStatement(sql);
			ps.setDouble(1, prod.getIvacompra());
			ps.setInt(2, prod.getNitproveedor());
			ps.setString(3, prod.getNombre_producto());
			ps.setDouble(4, prod.getPrecio_compra());
			ps.setDouble(5, prod.getPrecio_venta());
			ps.setInt(6, prod.getCodigo_producto());

			result=ps.executeUpdate()>0;
		}catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error al actualizar"+ex);
			
		}
		return result;
	}
	//
}
