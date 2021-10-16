package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import controlador.conexion;

public class ClientesDAO {
	
	conexion cnn = new conexion();
	Connection con=cnn.Conecta();
	PreparedStatement ps=null;
	ResultSet res=null;
	//==========================================================================
	// METODO INSERTAR CLIENTE
	//==========================================================================
	public boolean InsertarCliente(ClientesDTO cliente) {
		boolean res=false;
		try {
			String sql="insert into clientes values (?,?,?,?,?)";
			ps=con.prepareStatement(sql);
			ps.setInt(1,cliente.getCedula_cliente());
			ps.setString(2,cliente.getDireccion_cliente());
			ps.setString(3,cliente.getEmail_cliente());
			ps.setString(4,cliente.getNombre_cliente());
			ps.setString(5,cliente.getTelefono_cliente());
			res=ps.executeUpdate()>0;
		}catch(SQLException ex){
			JOptionPane.showMessageDialog(null, "No se pudo agregar al cliente"+ex);
		}
		return res;
	}
	//==========================================================================
	// METODO CONSULTAR CLIENTE		OK
	//==========================================================================
	public ClientesDTO BuscarCiente(int buscar_cedula) {	//
		ClientesDTO cliente=null;
		try {
			String sql="select * from clientes where cedula_cliente=?";
			ps=con.prepareStatement(sql);
			ps.setInt(1,buscar_cedula);	//
			res=ps.executeQuery();
			while(res.next()) {
				cliente=new ClientesDTO(res.getInt(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5));
			}
		}catch(SQLException ex){
			JOptionPane.showMessageDialog(null, "No se pudo consultar el cliente"+ex);
		}
		return cliente;
	}
	//==========================================================================
	// METODO ACTUALIZAR CLIENTE	OK
	//==========================================================================
	public boolean ActualizarCliente(ClientesDTO cliente) {
		boolean result=false;
		try {
			String sql="update clientes set direccion_cliente=?,email_cliente=?,nombre_cliente=?,telefono_cliente=? where cedula_cliente=?";
			ps=con.prepareStatement(sql);
			ps.setString(1, cliente.getDireccion_cliente());
			ps.setString(2, cliente.getEmail_cliente());
			ps.setString(3, cliente.getNombre_cliente());
			ps.setString(4, cliente.getTelefono_cliente());
			ps.setInt(5, cliente.getCedula_cliente());
			result=ps.executeUpdate()>0;
		}catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error al actualizar"+ex);
			
		}
		return result;
	}
	//==========================================================================
	// METODO ELIMINAR CLIENTE	OK 
	//==========================================================================
	public boolean EliminarCliente(int cedula_cliente) {
		boolean result=false;
		try {
			String sql="delete from clientes where cedula_cliente=?";
			ps=con.prepareStatement(sql);
			ps.setInt(1,cedula_cliente);
			result=ps.executeUpdate()>0;
		}catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error al eliminar"+ex);
		}
		return result;
	}

}
