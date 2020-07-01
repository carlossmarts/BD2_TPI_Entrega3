package model;

import java.util.ArrayList;
import java.time.LocalDate;
import java.util.List;

public class Venta {
	private String fecha;
	private String nroTicket;
	private FormaPago formaPago;
	private double totalVenta;
	private Usuario vendedor;
	private Usuario cobrador;
	private Usuario cliente;
	private Sucursal sucursal;
	private List<ItemVenta> items;

	public Venta(String fecha, String nroTicket, FormaPago formaPago, Usuario vendedor, Usuario cobrador,
			Usuario cliente, Sucursal sucursal) {
		this.fecha = fecha;
		this.nroTicket = nroTicket;
		this.formaPago = formaPago;
		this.totalVenta = 0;
		this.vendedor = vendedor;
		this.cobrador = cobrador;
		this.cliente = cliente;
		this.sucursal = sucursal;
		this.items = new ArrayList<ItemVenta>();
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getNroTicket() {
		return nroTicket;
	}

	public void setNroTicket(String nroTicket) {
		this.nroTicket = nroTicket;
	}

	public FormaPago getFormaPago() {
		return formaPago;
	}

	public void setFormaPago(FormaPago formaPago) {
		this.formaPago = formaPago;
	}

	public double getTotalVenta() {
		return totalVenta;
	}
	

	public void calcularTotalVenta() {
		double total = 0;
		for(ItemVenta item : items) {
			total += item.getPrecioUnitario()*item.getCantidad();
		}
		this.totalVenta = total;
	}

	public Usuario getVendedor() {
		return vendedor;
	}

	public void setVendedor(Usuario vendedor) {
		this.vendedor = vendedor;
	}

	public Usuario getCobrador() {
		return cobrador;
	}

	public void setCobrador(Usuario cobrador) {
		this.cobrador = cobrador;
	}

	public Usuario getCliente() {
		return cliente;
	}

	public void setCliente(Usuario cliente) {
		this.cliente = cliente;
	}

	public Sucursal getSucursal() {
		return sucursal;
	}

	public void setSucursal(Sucursal sucursal) {
		this.sucursal = sucursal;
	}
	
	public boolean agregarItemVenta(ItemVenta item) {
		return items.add(item);
	}

	public String toString() {
		return "Venta [fecha=" + fecha + ", nroTicket=" + nroTicket + ", formaPago=" + formaPago + ", totalVenta="
				+ totalVenta + ", vendedor=" + vendedor + ", cobrador=" + cobrador + ", cliente=" 
				+ cliente + ", sucursal=" + sucursal + "]";
	}

}
