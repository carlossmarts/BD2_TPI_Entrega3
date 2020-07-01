package test;

import com.google.gson.Gson;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.util.JSON;

import dao.ClienteDAO;
import dao.EmpleadoDAO;
import dao.FormaPagoDAO;
import dao.LaboratorioDAO;
import dao.ObraSocialDAO;
import dao.ProductoDAO;
import dao.SucursalDAO;
import dao.TipoProductoDAO;
import dao.VentaDAO;
import model.Cliente;
import model.Empleado;
import model.FormaPago;
import model.Laboratorio;
import model.ObraSocial;
import model.Producto;
import model.Sucursal;
import model.TipoProducto;

public class TestDAO {

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
		
		/* Obra social dao
		//Traer uno
		System.out.println(OSdao.traer("OSDE").toString());
		
		//Traer todos
		for (ObraSocial os : OSdao.traerOSs()) {
			System.out.println(os);
		}
		
		//Agregar
		OSdao.agregar(new ObraSocial("OSDE"));
		*/
		
		/* forma de pago dao
		
		//Traer uno
		System.out.println(FPdao.traer("Efectivo").toString());
		
		//Traer todos
		for (FormaPago fp : FPdao.traerFormasPago()) {
			System.out.println(fp);
		}
		//Agregar
		FPdao.agregar(new FormaPago("Efectivo"));
		*/
		
	/* tipo de producto dao
		
		//Traer uno
		System.out.println(TPdao.traer("Medicamento").toString());
		
		//Traer todos
		for (TipoProducto tp : TPdao.traerTiposProducto()) {
			System.out.println(tp);
		}
		//Agregar
		TPdao.agregar(new TipoProducto("Medicamento"));
		*/
		
		/* laboratorio dao
		
		//Traer uno
		System.out.println(Ldao.traer("Bayer").toString());
		
		//Traer todos
		for (Laboratorio l : Ldao.traerTiposProducto()) {
			System.out.println(l);
		}
		//Agregar
		Ldao.agregar(new Laboratorio("Bayer"));
		*/
		
		/* Cliente dao
		
		//Traer uno
		System.out.println(Cdao.traer("45678883").toString());
		
		
		//Agregar
		Cdao.agregar(new Cliente("45678883", "Luis", "Style", "Princes Park 345", null, false));
		
		//Traer todos
		for (Cliente c : Cdao.traerClientes()) {
			System.out.println(c);
		}
		*/
		
 		/*empleado dao
		
		//Traer uno
		System.out.println(Edao.traer("123456784").toString());
		
		Edao.agregar(new Empleado("123456784", "Lisa", "Mansilla", "Cornelia Street 1313", OSdao.traer("OSDE"), "27-37896347-7"));
				
	
		//Traer todos
		for (Empleado e : Edao.traerEmpleados()) {
			System.out.println(e);
		*/
		
		/*
		//producto dao
		Laboratorio bay = Ldao.traer("Bayer");
		TipoProducto med = TPdao.traer("Medicamento");
		
		//Pdao.agregar(new Producto("1245BAY", 180.5, "bayaspirina 30 com", med, bay));
		
		System.out.println(Pdao.traer("1245BAY").toString());
				
		for (Producto p : Pdao.traerProductos()) {
			System.out.println(p);
		}
		*/
		
		/*
		//producto dao
		ObraSocial osde = OSdao.traer("OSDE");
		
		Edao.agregar(new Empleado("30897654", "Patricio", "Ponce", "Lituania 4563", osde, "23-15789654-8"));
		Empleado e1 = Edao.traer("123456784");
		Empleado e2 = Edao.traer("30897654");
		
		Sucursal s1 = new Sucursal("Farmacia Pompeo", 1, e1, "Yrigoyen 2627");
		s1.agregarEmpleado(e1);
		s1.agregarEmpleado(e2);
		
		Sdao.agregar(s1);
		
		System.out.println(Sdao.traer("Farmacia Pompeo"));
				
		for (Sucursal s : Sdao.traerSucursales()) {
			System.out.println(s);
		}
		*/
		
		
			
		
	}
}
