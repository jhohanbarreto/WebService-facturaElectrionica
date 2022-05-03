package rest.entity;

public class Factura_detalle {
	
	private Integer id_factura_detalle;
	private Integer id_clienteFactura;
	private Integer id_producto;
	private Double cantidad;
	private Double precio;
	
	public Integer getId_factura_detalle() {
		return id_factura_detalle;
	}
	public void setId_factura_detalle(Integer id_factura_detalle) {
		this.id_factura_detalle = id_factura_detalle;
	}
	public Integer getId_clienteFactura() {
		return id_clienteFactura;
	}
	public void setId_clienteFactura(Integer id_clienteFactura) {
		this.id_clienteFactura = id_clienteFactura;
	}
	public Integer getId_producto() {
		return id_producto;
	}
	public void setId_producto(Integer id_producto) {
		this.id_producto = id_producto;
	}
	public Double getCantidad() {
		return cantidad;
	}
	public void setCantidad(Double cantidad) {
		this.cantidad = cantidad;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	
	

}
