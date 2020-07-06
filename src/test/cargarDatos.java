package test;

import java.util.Date;

import dao.ClienteDAO;
import dao.EmpleadoDAO;
import dao.FormaPagoDAO;
import dao.LaboratorioDAO;
import dao.ObraSocialDAO;
import dao.ProductoDAO;
import dao.SucursalDAO;
import dao.TipoProductoDAO;
import dao.VentaDAO;
import model.*;

public class cargarDatos {

	public static void main(String[] args) {
		
		/*
		 * IMPORTANTE: ANTES DE DE EJECUTAR ESTA CLASE ES NECESARIO EJECUTAR DESDE LA CONSOLA DE 
		 * MONGODB EL ARCHIVO "./js/database.js" PARA VACIAR LA BASE DE DATOS, YA QUE AL USAR DIRECTAMENTE 
		 * LA CAPA DE DAO NO IMPLEMENTAMOS NINGUNA EXCEPCIÓN, Y LA INFORMACIÓN SE PUEDE REPETIR SIN 
		 * NINGÚN PROBLEMA.
		 */
		
		ObraSocialDAO OSdao = new ObraSocialDAO();
		FormaPagoDAO FPdao = new FormaPagoDAO();
		TipoProductoDAO TPdao = new TipoProductoDAO();
		LaboratorioDAO Ldao = new LaboratorioDAO();
		ClienteDAO Cdao = new ClienteDAO();
		EmpleadoDAO Edao = new EmpleadoDAO();
		ProductoDAO Pdao = new ProductoDAO();
		SucursalDAO Sdao = new SucursalDAO();
		VentaDAO Vdao = new VentaDAO();
		
		//Obra social
		ObraSocial amffa = new ObraSocial("AMFFA");		OSdao.agregar(amffa);
		ObraSocial osde = new ObraSocial("OSDE");		OSdao.agregar(osde);
		ObraSocial osecac = new ObraSocial("OSECAC");	OSdao.agregar(osecac);
		ObraSocial pami = new ObraSocial("PAMI");		OSdao.agregar(pami);
		ObraSocial ioma = new ObraSocial("IOMA");		OSdao.agregar(ioma);
		
		//usuarios
		Cliente c1 = new Cliente("45678883", "Luis", "Style", "Princes Park 345", null, false); 				Cdao.agregar(c1);
		Cliente c2 = new Cliente("10236446", "Enrique", "Windsor", "Coronel Rosales 456", osde, true); 			Cdao.agregar(c2);	
		Cliente c3 = new Cliente("23456987", "Irene", "Modesto", "Lituania 4533", osecac, true); 				Cdao.agregar(c3);
		Cliente c4 = new Cliente("16578346", "Catalina", "Gales", "Spano 4567", osecac, true); 					Cdao.agregar(c4);
		Cliente c5 = new Cliente("14567832", "Felipe", "Primo", "Grecia 1929", ioma, true);						Cdao.agregar(c5);
		Cliente c6 = new Cliente("12567432", "Ariana", "Grande", "Boca Raton 3567", null, false); 				Cdao.agregar(c6);
		Cliente c7 = new Cliente("16727486", "Diana", "Spencer", "Gran Alma 1997", amffa, true); 				Cdao.agregar(c7);
		Cliente c8 = new Cliente("14678289", "Estefanía", "Rinaldi", "Manuel Castro 542", pami, true); 			Cdao.agregar(c8);
		Cliente c9 = new Cliente("15789654", "Thiago", "Bedoya", "Agüero 2345", ioma, true); 					Cdao.agregar(c9);
		Cliente c10 = new Cliente("17653476", "Federico", "Fritzenwalden", "Gral Navarro 5677", osde, true); 	Cdao.agregar(c10);
		Cliente c11 = new Cliente("34568217", "Delfina", "Derrico", "yrigoyen 1567", osecac, true); 			Cdao.agregar(c11);
		
		
		Empleado e1 = new Empleado("40893284", "Homero", "Simpson", "Siempreviva 123", amffa,"23-40893284-2"); 			Edao.agregar(e1);
		Empleado e2 = new Empleado("123456784", "Lisa", "Mansilla", "Cornelia Street 1313", osde, "27-37896347-7"); 	Edao.agregar(e2);
		Empleado e3 = new Empleado("27895325", "Rosa", "Campo", "Salvador 3455", osecac,"23-33895689-6"); 				Edao.agregar(e3);
		Empleado e4 = new Empleado("37896347", "Jessica", "Martínez", "Yrigoyen 1767", pami, "23-45678883-4"); 			Edao.agregar(e4);
		Empleado e5 = new Empleado ("32795463", "Derek", "Shepherd", "Seattle 456", ioma, "27-34568217-2"); 			Edao.agregar(e5);
		Empleado e6 = new Empleado("30897654", "Patricio", "Ponce", "Lituania 4563", osde, "23-15789654-8"); 			Edao.agregar(e6);
		Empleado e7 = new Empleado("32098753", "Lexie", "Sloan", "Airplane 822", amffa, "23-30897654-9"); 				Edao.agregar(e7);
		Empleado e8 = new Empleado("33895689", "Andrés", "Rodriguez", "Hernandarias 2456", pami, "27-23456987-5");		Edao.agregar(e8);
		Empleado e9 = new Empleado("20985432", "Daniel", "Mussimessi", "Baigorria 5321", amffa, "23-15789654-8");		Edao.agregar(e9);
		
		//Sucursales
		Sucursal s1 = new Sucursal("Farmacia Pompeo", 1, e1, "Yrigoyen 2627");
		s1.agregarEmpleado(e1); s1.agregarEmpleado(e2); s1.agregarEmpleado(e3);
		Sdao.agregar(s1);
		
	
		Sucursal s2 = new Sucursal("Farmacia Pasteur", 2, e4, "Condarco 675");
		s2.agregarEmpleado(e4); s2.agregarEmpleado(e5); s2.agregarEmpleado(e6);
		Sdao.agregar(s2);
		
		Sucursal s3 = new Sucursal("Farmacia Prado", 3, e7, "Laprida 2356");
		s3.agregarEmpleado(e7); s3.agregarEmpleado(e8); s3.agregarEmpleado(e9);
		Sdao.agregar(s3);
		
		
		//Productos 
		TipoProducto med = new TipoProducto("medicamento");		TPdao.agregar(med);
		TipoProducto per = new TipoProducto("perfumeria");		TPdao.agregar(per);
		
		Laboratorio bay = new Laboratorio("Bayer");				Ldao.agregar(bay);
		Laboratorio mop = new Laboratorio("Montpellier");		Ldao.agregar(mop);
		Laboratorio roe = new Laboratorio("Roemmers");			Ldao.agregar(roe);
		Laboratorio raf = new Laboratorio("Raffo");				Ldao.agregar(raf);
		
		Producto p1 = new Producto("1245BAY", 180.5, "bayaspirina 30 com", med, bay); 			Pdao.agregar(p1);	
		Producto p2 = new Producto("3465MOP", 578.8, "Dbi 500Mg 60 Com", med, mop);				Pdao.agregar(p2);		
		Producto p3 = new Producto("3475MOP", 2716.55, "Dbi Ap 850mg 60 Com", med, mop);		Pdao.agregar(p3);		
		Producto p4 = new Producto("1234ROE", 415.65, "Amoxidal 500mg 20Com", med, roe);		Pdao.agregar(p4);	
		Producto p5 = new Producto("1222ROE", 453.4, "Amoxidal Duo Jarabe", med, roe);			Pdao.agregar(p5);	
		Producto p6 = new Producto("2727RAF", 224.75, "Aerotina 10 mg 10Com", med, raf);		Pdao.agregar(p6);	
		Producto p7 = new Producto("4098RAF", 468.99, "Flexidol Relax 10 Com", med, raf);		Pdao.agregar(p7);
		Producto p8 = new Producto("1452BAY", 256.75, "Bayaspirina 50 com", med, bay);			Pdao.agregar(p8);
		Producto p9 = new Producto("1456ABH", 156, "Her Secret 80 ml", per, null);				Pdao.agregar(p9);
		Producto p10 = new Producto("1477AXX", 134.1, "Axe Marine x 150 ml", per, null);		Pdao.agregar(p10);
		Producto p11 = new Producto("1356DOV", 156,  "Dove Invisible Care 150 ml", per, null); 	Pdao.agregar(p11);
		
		
		//Forma de pago
		FormaPago ef = new FormaPago("Efectivo");		FPdao.agregar(ef);
		FormaPago deb = new FormaPago("Débito");		FPdao.agregar(deb);
		FormaPago cre = new FormaPago("Crédito");		FPdao.agregar(cre);
		
		Date feb2 = new Date("2020/02/02");
		Date feb3 = new Date("2020/02/03");
		Date feb4 = new Date("2020/02/04");
		Date feb5 = new Date("2020/02/05");
		
		
		//ventas
		Venta v1 = new Venta(feb2, "0001-0001", ef, e2, e1, c1, s1);
		v1.agregarItemVenta(new ItemVenta(p1, 1));
		v1.agregarItemVenta(new ItemVenta(p2, 1));
		v1.agregarItemVenta(new ItemVenta(p3, 3));
		v1.calcularTotalVenta();
		Vdao.agregar(v1);
	
		
		
		Venta v2 = new Venta(feb2, "0002-0002", ef, e5, e4, c2, s2);
		v2.agregarItemVenta(new ItemVenta(p4, 1));
		v2.agregarItemVenta(new ItemVenta(p5, 1));
		v2.calcularTotalVenta();
		Vdao.agregar(v2);
		
		
		Venta v3 = new Venta(feb2, "0002-0003", ef, e6, e4, c3, s2);
		v3.agregarItemVenta(new ItemVenta(p7, 1));
		v3.calcularTotalVenta();
		Vdao.agregar(v3);
		
		Venta v4 = new Venta(feb2, "0003-0004", deb, e8, e7, c4, s3);
		v4.agregarItemVenta(new ItemVenta(p8, 1));
		v4.calcularTotalVenta();
		Vdao.agregar(v4);
		
		Venta v5 = new Venta(feb2, "0001-0005", deb, e3, e1, c5, s1);
		v5.agregarItemVenta(new ItemVenta(p9, 4));
		v5.agregarItemVenta(new ItemVenta(p10, 1));
		v5.agregarItemVenta(new ItemVenta(p11, 3));
		v5.calcularTotalVenta();
		Vdao.agregar(v5);
		
		
		Venta v6 = new Venta(feb3, "0001-0006", deb, e2, e1, c6, s1);
		v6.agregarItemVenta(new ItemVenta(p1, 1));
		v6.agregarItemVenta(new ItemVenta(p2, 1));
		v6.calcularTotalVenta();
		Vdao.agregar(v6);
		
		
		Venta v7 = new Venta(feb3, "0001-0007", deb, e3, e1, c7, s1);
		v7.agregarItemVenta(new ItemVenta(p3, 2));
		v7.calcularTotalVenta();
		Vdao.agregar(v7);
	
		
		Venta v8 = new Venta(feb3, "0001-0008", deb, e2, e1, c8, s1);
		v8.agregarItemVenta(new ItemVenta(p4, 1));
		v8.agregarItemVenta(new ItemVenta(p5, 1));
		v8.calcularTotalVenta();
		Vdao.agregar(v8);
		
		
		Venta v9 = new Venta(feb3, "0002-0009", deb, e5, e4, c9, s2);
		v9.agregarItemVenta(new ItemVenta(p6, 1));
		v9.agregarItemVenta(new ItemVenta(p7, 1));
		v9.calcularTotalVenta();
		Vdao.agregar(v9);
		
		
		Venta v10 = new Venta(feb3, "0003-0010", cre, e8, e7, c10, s3);
		v10.agregarItemVenta(new ItemVenta(p8, 1));
		v10.agregarItemVenta(new ItemVenta(p9, 4));
		v10.calcularTotalVenta();
		Vdao.agregar(v10);
		
		
		Venta v11 = new Venta(feb3, "0003-0011", cre, e9, e7, c11, s3);
		v11.agregarItemVenta(new ItemVenta(p10, 1));
		v11.agregarItemVenta(new ItemVenta(p11, 1));
		v11.calcularTotalVenta();
		Vdao.agregar(v11);
		
		
		Venta v12 = new Venta(feb4, "0001-0012", ef, e2, e1, c1, s1);
		v12.agregarItemVenta(new ItemVenta(p1, 1));
		v12.calcularTotalVenta();
		Vdao.agregar(v12);
		
		Venta v13 = new Venta(feb4, "0001-0013", ef, e3, e1, c2, s1);
		v13.agregarItemVenta(new ItemVenta(p2, 1));
		v13.agregarItemVenta(new ItemVenta(p3, 1));
		v13.agregarItemVenta(new ItemVenta(p4, 2));
		v13.agregarItemVenta(new ItemVenta(p5, 1));
		v13.calcularTotalVenta();
		Vdao.agregar(v13);
		
		
		Venta v14 = new Venta(feb4, "0003-0014", ef, e8, e7, c3, s3);
		v14.agregarItemVenta(new ItemVenta(p6, 1));
		v14.agregarItemVenta(new ItemVenta(p7, 1));
		v14.calcularTotalVenta();
		Vdao.agregar(v14);
		
		Venta v15 = new Venta(feb4, "0002-0015", deb, e5, e4, c4, s2);
		v15.agregarItemVenta(new ItemVenta(p8, 5));
		v15.agregarItemVenta(new ItemVenta(p9, 1));
		v15.calcularTotalVenta();
		Vdao.agregar(v15);
		
		
		Venta v16 = new Venta(feb4, "0002-0016", deb, e6, e4, c5, s2);
		v16.agregarItemVenta(new ItemVenta(p10, 1));
		v16.agregarItemVenta(new ItemVenta(p11, 1));
		v16.calcularTotalVenta();
		Vdao.agregar(v16);
		
		
		Venta v17= new Venta(feb5, "0003-0017", deb, e8, e7, c6, s3);
		v17.agregarItemVenta(new ItemVenta(p1, 1));
		v17.calcularTotalVenta();
		Vdao.agregar(v17);
		
		
		Venta v18= new Venta(feb5, "0003-0018", deb, e9, e7, c7, s3);
		v18.agregarItemVenta(new ItemVenta(p2, 4));
		v18.calcularTotalVenta();
		Vdao.agregar(v18);
		
		Venta v19= new Venta(feb5, "0003-0019", deb, e8, e7, c8, s3);
		v19.agregarItemVenta(new ItemVenta(p3, 1));
		v19.calcularTotalVenta();
		Vdao.agregar(v19);
		
		
		Venta v20= new Venta(feb5, "0002-0020", cre, e5, e4, c9, s2);
		v20.agregarItemVenta(new ItemVenta(p4, 1));
		v20.agregarItemVenta(new ItemVenta(p5, 12));
		v20.calcularTotalVenta();
		Vdao.agregar(v20);
		
		
		
	}
	

}
