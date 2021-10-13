package modelo;

public class ProductosDTO {
	private int codigo_producto, iva_compra, nitproveedor, precio_compra, precio_venta;
	private String nombre_producto;
	public ProductosDTO(int codigo_producto, int iva_compra, int nitproveedor, String nombre_producto, 
			int precio_compra, int precio_venta) {
		super();
		this.nitproveedor = nitproveedor;
		this.codigo_producto = codigo_producto;
		this.iva_compra = iva_compra;
		this.precio_compra = precio_compra;
		this.precio_venta = precio_venta;
	}
	
	public int getCodigo_producto() {
		return codigo_producto;
	}
	public void setCodigo_producto(int codigo_producto) {
		this.codigo_producto = codigo_producto;
	}
	public int getIva_compra() {
		return iva_compra;
	}
	public void setIva_compra(int iva_compra) {
		this.iva_compra = iva_compra;
	}
	public int getNitproveedor() {
		return nitproveedor;
	}
	public void setNitproveedor(int nitproveedor) {
		this.nitproveedor = nitproveedor;
	}
	public int getPrecio_compra() {
		return precio_compra;
	}
	public void setPrecio_compra(int precio_compra) {
		this.precio_compra = precio_compra;
	}
	public int getPrecio_venta() {
		return precio_venta;
	}
	public void setPrecio_venta(int precio_venta) {
		this.precio_venta = precio_venta;
	}
	public String getNombre_producto() {
		return nombre_producto;
	}
	public void setNombre_producto(String nombre_producto) {
		this.nombre_producto = nombre_producto;
	}
}