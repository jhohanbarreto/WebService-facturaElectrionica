package rest.entity;

public class Cliente_factura {
	
	private Integer id_clienteFactura;
	private Integer id_cliente;
	private Integer num_factura;
	private String fecha;
	private String num_pago;
	
	
	public Integer getId_clienteFactura() {
		return id_clienteFactura;
	}
	public void setId_clienteFactura(Integer id_clienteFactura) {
		this.id_clienteFactura = id_clienteFactura;
	}
	public Integer getId_cliente() {
		return id_cliente;
	}
	public void setId_cliente(Integer id_cliente) {
		this.id_cliente = id_cliente;
	}
	public Integer getNum_factura() {
		return num_factura;
	}
	public void setNum_factura(Integer num_factura) {
		this.num_factura = num_factura;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getNum_pago() {
		return num_pago;
	}
	public void setNum_pago(String num_pago) {
		this.num_pago = num_pago;
	}
	
	

}
