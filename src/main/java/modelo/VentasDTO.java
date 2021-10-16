package modelo;

public class VentasDTO {
	private int codigo_venta, cedula_cliente, cedula_usuario, codigo_producto;
	private String nombre_cliente, nombre_producto;
	private double ivaventa, total_venta, valor_venta;
	
	//==========================================================================
	
	public int getCodigo_venta() {
		return codigo_venta;
	}
	public VentasDTO(int cedula_cliente, int cedula_usuario, int codigo_producto, double valor_venta) {
		
		this.cedula_cliente = cedula_cliente;
		this.cedula_usuario = cedula_usuario;
		this.codigo_producto = codigo_producto;
		this.valor_venta = valor_venta;
	//==========================================================================		
	}
	public void setCodigo_venta(int codigo_venta) {
		this.codigo_venta = codigo_venta;
	}
	public int getCedula_cliente() {
		return cedula_cliente;
	}
	public void setCedula_cliente(int cedula_cliente) {
		this.cedula_cliente = cedula_cliente;
	}
	public int getCedula_usuario() {
		return cedula_usuario;
	}
	public void setCedula_usuario(int cedula_usuario) {
		this.cedula_usuario = cedula_usuario;
	}
	public int getCodigo_producto() {
		return codigo_producto;
	}
	public void setCodigo_producto(int codigo_producto) {
		this.codigo_producto = codigo_producto;
	}
	public String getNombre_cliente() {
		return nombre_cliente;
	}
	public void setNombre_cliente(String nombre_cliente) {
		this.nombre_cliente = nombre_cliente;
	}
	public String getNombre_producto() {
		return nombre_producto;
	}
	public void setNombre_producto(String nombre_producto) {
		this.nombre_producto = nombre_producto;
	}
	public double getIvaventa() {
		return ivaventa;
	}
	public void setIvaventa(double ivaventa) {
		this.ivaventa = ivaventa;
	}
	public double getTotal_venta() {
		return total_venta;
	}
	public void setTotal_venta(double total_venta) {
		this.total_venta = total_venta;
	}
	public double getValor_venta() {
		return valor_venta;
	}
	public void setValor_venta(double valor_venta) {
		this.valor_venta = valor_venta;
	}
	//==========================================================================
}
