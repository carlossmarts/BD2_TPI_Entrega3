package model;

import java.util.ArrayList;
import java.util.List;

public class Sucursal {
	private String sucursal;
	private int ptoVenta;
	private List<Empleado> empleados;
	private Empleado encargado;
	private String direccion;

	public Sucursal(String sucursal, int ptoVenta, Empleado encargado, String direccion) {
		this.sucursal = sucursal;
		this.ptoVenta = ptoVenta;
		this.empleados = new ArrayList<Empleado>();
		this.encargado = encargado;
		this.direccion = direccion;
	}

	public String getSucursal() {
		return sucursal;
	}

	public void setSucursal(String sucursal) {
		this.sucursal = sucursal;
	}

	public int getPtoVenta() {
		return ptoVenta;
	}

	public void setPtoVenta(int ptoVenta) {
		this.ptoVenta = ptoVenta;
	}

	public List<Empleado> getEmpleados() {
		return empleados;
	}

	public void setEmpleados(List<Empleado> empleados) {
		this.empleados = empleados;
	}

	public Empleado getEncargado() {
		return encargado;
	}

	public void setEncargado(Empleado encargado) {
		this.encargado = encargado;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String toString() {
		return "Sucursal [sucursal=" + sucursal + ", ptoVenta=" + ptoVenta + ", empleados=" + empleados + ", encargado="
				+ encargado + ", direccion=" + direccion + "]";
	}
	
	public boolean agregarEmpleado(Empleado e) {
		return empleados.add(e);
	}

}
