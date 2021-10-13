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

	public ProductosDTO BuscarProducto(int buscar_cod_producto) {	//
		ProductosDTO prod=null;
		try {
			String sql="select * from productos where codigo_producto=?";
			ps=con.prepareStatement(sql);
			ps.setInt(1,buscar_cod_producto);	//
			res=ps.executeQuery();
			while(res.next()) {
				prod=new ProductosDTO(res.getInt(1),res.getInt(2),res.getInt(3),res.getString(4),res.getInt(5),res.getInt(6));

			}
		}catch(SQLException ex){
			JOptionPane.showMessageDialog(null, "No se pudo consultar el producto"+ex);
		}
		return prod;
	}
	
	public boolean ActualizarProducto(ProductosDTO prod) {
		boolean result=false;
		try {
			String sql="update proveedores set ciudad_proveedor=?,direccion_proveedor=?,nombre_proveedor=?,telefono_proveedor=? where nitproveedor=?";
			ps=con.prepareStatement(sql);
			ps.setInt(1, prod.getCodigo_producto());
			ps.setInt(2, prod.getIva_compra());
			ps.setInt(3, prod.getNitproveedor());
			ps.setString(4, prod.getNombre_producto());
			ps.setInt(5, prod.getPrecio_compra());
			ps.setInt(6, prod.getPrecio_venta());

			result=ps.executeUpdate()>0;
		}catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error al actualizar"+ex);
			
		}
		return result;
	}
	
	
}
