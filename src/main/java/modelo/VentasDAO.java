package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import controlador.conexion;

public class VentasDAO {

	conexion cnn = new conexion();
	Connection con=cnn.Conecta();
	PreparedStatement ps=null;
	ResultSet res=null;
//==============================================================================
			//REGISTRAR VENTA
//==============================================================================
	public boolean RegistrarVenta(VentasDTO venta) {
		boolean res=false;
		try {
			String sql="insert into ventas values (?,?,?,?,?,?)";
			ps=con.prepareStatement(sql);
			ps.setInt(1,venta.getCodigo_venta());
			ps.setInt(2,venta.getCedula_cliente());
			ps.setInt(3,venta.getCedula_usuario());
			ps.setDouble(4,venta.getIvaventa());
			ps.setDouble(5,venta.getTotal_venta());
			ps.setDouble(6,venta.getValor_venta());
			res=ps.executeUpdate()>0;
						
		}catch(SQLException ex){
			//JOptionPane.showMessageDialog(null, "No se pudo registrar la venta"+ex);
		}
		return res;
	}
//==============================================================================
			//DETALLES VENTA
//==============================================================================
	public boolean DetalleVentas(DetalleVentasDTO detalleventa) {
		boolean res=false;
		try {
			String sql="insert into detalle_ventas values (?,?,?,?,?,?,?)";
			ps=con.prepareStatement(sql);
			ps.setInt(1,detalleventa.getCodigo_detalle_venta());
			ps.setInt(2,detalleventa.getCantidad_producto());
			ps.setInt(3,detalleventa.getCodigo_producto());
			ps.setInt(4,detalleventa.getCodigo_venta());
			ps.setDouble(5,detalleventa.getValor_total());
			ps.setDouble(6,detalleventa.getValor_venta());
			ps.setDouble(7,detalleventa.getValoriva());
			res=ps.executeUpdate()>0;
						
		}catch(SQLException ex){
			//JOptionPane.showMessageDialog(null, "No se pudo registrar los detalles de venta"+ex);
		}
		return res;
	}
//==========================================================================
// CREAR LISTADO VENTAS
//==========================================================================
		
		public ArrayList<VentasDTO> ListadoVentas(){
			
			VentasDTO venta=null;
			ArrayList<VentasDTO> listado = new ArrayList<>();
			try {
				String sql="select * from ventas";
				ps=con.prepareStatement(sql);
				res=ps.executeQuery();
				while(res.next()) {
					venta=new VentasDTO(res.getInt(1),res.getInt(2),res.getInt(3),res.getDouble(4),res.getDouble(5),res.getDouble(6));
					listado.add(venta);
				}
			}catch(SQLException ex) {
				//JOptionPane.showMessageDialog(null, "Error al cargar la lista"+ex);
			}
			return listado;
		}
//==============================================================================
}
