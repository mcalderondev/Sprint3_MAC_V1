package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import controlador.conexion;

public class ProveedoresDAO {
	
	conexion cnn = new conexion();
	Connection con=cnn.Conecta();
	PreparedStatement ps=null;
	ResultSet res=null;
	//==========================================================================
	// METODO INSERTAR PROVEEDOR
	//==========================================================================
	public boolean InsertarProveedor(ProveedoresDTO prov) {
		boolean res=false;
		try {
			String sql="insert into proveedores values (?,?,?,?,?)";
			ps=con.prepareStatement(sql);
			ps.setInt(1,prov.getNitproveedor());
			ps.setString(2,prov.getCiudad_proveedor());
			ps.setString(3,prov.getDireccion_proveedor());
			ps.setString(4,prov.getNombre_proveedor());
			ps.setString(5,prov.getTelefono_proveedor());
			res=ps.executeUpdate()>0;
		}catch(SQLException ex){
			JOptionPane.showMessageDialog(null, "No se pudo agregar al proveedor"+ex);
		}
		return res;
	}
	//==========================================================================
	// METODO CONSULTAR PROVEEDOR
	//==========================================================================
	public ProveedoresDTO BuscarProveedor(int buscar_nit) {	//
		ProveedoresDTO prov=null;
		try {
			String sql="select * from proveedores where nitproveedor=?";
			ps=con.prepareStatement(sql);
			ps.setInt(1,buscar_nit);	//
			res=ps.executeQuery();
			while(res.next()) {
				prov=new ProveedoresDTO(res.getInt(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5));
			}
		}catch(SQLException ex){
			JOptionPane.showMessageDialog(null, "No se pudo consultar el proveedor"+ex);
		}
		return prov;
	}
	//==========================================================================
	// METODO ACTUALIZAR PROVEEDOR
	//==========================================================================
	public boolean ActualizarProveedor(ProveedoresDTO prov) {
		boolean result=false;
		try {
			String sql="update proveedores set ciudad_proveedor=?,direccion_proveedor=?,nombre_proveedor=?,telefono_proveedor=? where nitproveedor=?";
			ps=con.prepareStatement(sql);
			ps.setString(1, prov.getCiudad_proveedor());
			ps.setString(2, prov.getDireccion_proveedor());
			ps.setString(3, prov.getNombre_proveedor());
			ps.setString(4, prov.getTelefono_proveedor());
			ps.setInt(5, prov.getNitproveedor());
			result=ps.executeUpdate()>0;
		}catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error al actualizar"+ex);
			
		}
		return result;
	}
	//==========================================================================
	// METODO ELIMINAR PROVEEDOR
	//==========================================================================
	public boolean EliminarProveedor(int nitproveedor) {
		boolean result=false;
		try {
			String sql="delete from proveedores where nitproveedor=?";
			ps=con.prepareStatement(sql);
			ps.setInt(1,nitproveedor);
			result=ps.executeUpdate()>0;
		}catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error al eliminar"+ex);
		}
		return result;
	}
}
