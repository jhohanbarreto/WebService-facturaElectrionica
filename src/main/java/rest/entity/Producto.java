package rest.entity;

public class Producto {
	
	private Integer id_producto;
	private Integer id_categoria;
	private String 	nombreProducto;
	private Double precioProducto;
	private Double stockProducto;
	
	
	public Integer getId_producto() {
		return id_producto;
	}
	public void setId_producto(Integer id_producto) {
		this.id_producto = id_producto;
	}
	public Integer getId_categoria() {
		return id_categoria;
	}
	public void setId_categoria(Integer id_categoria) {
		this.id_categoria = id_categoria;
	}
	public String getNombreProducto() {
		return nombreProducto;
	}
	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}
	public Double getPrecioProducto() {
		return precioProducto;
	}
	public void setPrecioProducto(Double precioProducto) {
		this.precioProducto = precioProducto;
	}
	public Double getStockProducto() {
		return stockProducto;
	}
	public void setStockProducto(Double stockProducto) {
		this.stockProducto = stockProducto;
	}
	

}
