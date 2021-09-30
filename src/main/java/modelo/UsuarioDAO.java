package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import controlador.conexion;

public class UsuarioDAO {
	
	conexion cnn = new conexion();
	Connection con=cnn.Conecta();
	PreparedStatement ps=null;
	ResultSet res=null;
	//==========================================================================
	// METODO INSERTAR USUARIO OK
	//==========================================================================
	public boolean InsertarUsuario(UsuarioDTO user) {
		boolean res=false;
		try {
			String sql="insert into usuarios values (?,?,?,?,?)";
			ps=con.prepareStatement(sql);
			ps.setInt(1,user.getCedula_usuario());
			ps.setString(2,user.getEmail_usuario());
			ps.setString(3,user.getNombre_usuario());
			ps.setString(4,user.getPassword());
			ps.setString(5,user.getUsuario());
			res=ps.executeUpdate()>0;
		}catch(SQLException ex){
			JOptionPane.showMessageDialog(null, "No se pudo agregar el usuario"+ex);
		}
		return res;
	}
	//==========================================================================
	// METODO CONSULTAR USUARIO		OK
	//==========================================================================
	public UsuarioDTO BuscarUsuario(int buscar_cedula) {	//
		UsuarioDTO user=null;
		try {
			String sql="select * from usuarios where cedula_usuario=?";
			ps=con.prepareStatement(sql);
			ps.setInt(1,buscar_cedula);	//
			res=ps.executeQuery();
			while(res.next()) {
				user=new UsuarioDTO(res.getInt(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5));
			}
		}catch(SQLException ex){
			JOptionPane.showMessageDialog(null, "No se pudo consultar el usuario"+ex);
		}
		return user;
	}
	//==========================================================================
	// METODO ACTUALIZAR USUARIO	OK
	//==========================================================================
	public boolean ActualizarUsuario(UsuarioDTO user) {
		boolean result=false;
		try {
			String sql="update usuarios set email_usuario=?,nombre_usuario=?,password=?,usuario=? where cedula_usuario=?";
			ps=con.prepareStatement(sql);
			//ps.setInt(1, user.getCedula_usuario());	//borrar
			ps.setString(1, user.getEmail_usuario());
			ps.setString(2, user.getNombre_usuario());
			ps.setString(3, user.getPassword());
			ps.setString(4, user.getUsuario());
			ps.setInt(5, user.getCedula_usuario());
			result=ps.executeUpdate()>0;
		}catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error al actualizar"+ex);
			
		}
		return result;
	}
	//==========================================================================
	// METODO ELIMINAR USUARIO	OK 
	//==========================================================================
	public boolean EliminarUsuario(int cedula_usuario) {
		boolean result=false;
		try {
			String sql="delete from usuarios where cedula_usuario=?";
			ps=con.prepareStatement(sql);
			ps.setInt(1,cedula_usuario);
			result=ps.executeUpdate()>0;
		}catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error al eliminar"+ex);
		}
		return result;
	}
	
}
