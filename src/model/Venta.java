package model;

import java.util.ArrayList;
import java.util.Date;
import java.time.LocalDate;
import java.util.List;

import funciones.Funciones;

public class Venta {
	private Date fecha;
	private String nroTicket;
	private FormaPago formaPago;
	private double totalVenta;
	private Empleado vendedor;
	private Empleado cobrador;
	private Cliente cliente;
	private Sucursal sucursal;
	private List<ItemVenta> items;

	public Venta(Date fecha, String nroTicket, FormaPago formaPago, Empleado vendedor, Empleado cobrador,
			Cliente cliente, Sucursal sucursal) {
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

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
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

	public Empleado getVendedor() {
		return vendedor;
	}

	public void setVendedor(Empleado vendedor) {
		this.vendedor = vendedor;
	}

	public Empleado getCobrador() {
		return cobrador;
	}

	public void setCobrador(Empleado cobrador) {
		this.cobrador = cobrador;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
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
	
	public List<ItemVenta> getItems() {
		return items;
	}

	public String toString() {
		return "Venta [fecha=" + Funciones.cambiarFormato(fecha) + ", nroTicket=" + nroTicket + ", formaPago=" + formaPago + ", totalVenta="
				+ totalVenta + ", vendedor=" + vendedor + ", cobrador=" + cobrador + ", cliente=" 
				+ cliente + ", sucursal=" + sucursal + "]";
	}

}
