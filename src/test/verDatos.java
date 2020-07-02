package test;

import java.util.Date;

import dao.*;
import model.*;

public class verDatos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ObraSocialDAO OSdao = new ObraSocialDAO();
		FormaPagoDAO FPdao = new FormaPagoDAO();
		TipoProductoDAO TPdao = new TipoProductoDAO();
		LaboratorioDAO Ldao = new LaboratorioDAO();
		ClienteDAO Cdao = new ClienteDAO();
		EmpleadoDAO Edao = new EmpleadoDAO();
		ProductoDAO Pdao = new ProductoDAO();
		SucursalDAO Sdao = new SucursalDAO();
		VentaDAO Vdao = new VentaDAO();
		
		/*
		System.out.println("\nOBRAS SOCIALES");
		for (ObraSocial os : OSdao.traerOSs()) {
			System.out.println(os);
		}
		
		System.out.println("\nFORMAS DE PAGO");
		for (FormaPago fp : FPdao.traerFormasPago()) {
			System.out.println(fp);
		}
		
		System.out.println("\nTIPOS DE PRODUCTO");
		for(TipoProducto tp : TPdao.traerTiposProducto()) {
			System.out.println(tp);
		}
		
		System.out.println("\nLABORATORIOS");
		for(Laboratorio l : Ldao.traerLaboratorios()) {
			System.out.println(l);
		}
		
		System.out.println("\nCLIENTES");
		for(Cliente c : Cdao.traerClientes()) {
			System.out.println(c);
		}
		
		System.out.println("\nEMPLEADOS");
		for(Empleado e : Edao.traerEmpleados()) {
			System.out.println(e);
		}
		
		System.out.println("\nPRODUCTOS");
		for(Producto p : Pdao.traerProductos()) {
			System.out.println(p);
		}
		
		System.out.println("\nSUCURSALES");
		for(Sucursal s : Sdao.traerSucursales()) {
			System.out.println(s);
		}
		
		
		
		
		System.out.println("\nVentas");
		for(Venta v : Vdao.traerVentas()) {
			System.out.println(v);
		}
		*/
		
		System.out.println("\nVentas");
		for(Venta v : Vdao.traerVentasEntreFechas(new Date("2020/02/01"), new Date("2020/02/06"))) {
			System.out.println(v);
		}
		
	}

}
