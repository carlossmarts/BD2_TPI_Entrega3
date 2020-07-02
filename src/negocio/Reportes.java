package negocio;

import java.util.Date;
import dao.VentaDAO;
import funciones.Funciones;
import model.ItemVenta;
import model.Venta;

public class Reportes {
	
	private static VentaDAO Vdao = new VentaDAO();
	
	public static void reporte1(Date f1, Date f2) {
		double totalCadena = 0;
		double totalSuc1= 0;
		double totalSuc2= 0;
		double totalSuc3= 0;
		for(Venta v : Vdao.traerVentasEntreFechas(f1, f2)) {
			//System.out.println(v.getSucursal().getPtoVenta());
			totalCadena += v.getTotalVenta();
			if (v.getSucursal().getPtoVenta() == 1) {
				totalSuc1 += v.getTotalVenta();
			}
			if (v.getSucursal().getPtoVenta() == 2) {
				totalSuc2 += v.getTotalVenta();
			}
			if (v.getSucursal().getPtoVenta() == 3) {
				totalSuc3 += v.getTotalVenta();
			}
		}
		
		System.out.println("Detalle y totales de ventas para la cadena completa y por sucursal, entre "  
							+ Funciones.cambiarFormato(f1)+" y " + Funciones.cambiarFormato(f2) );
		
		System.out.println("\nTotal de ventas de la cadena : $"+ totalCadena);

		System.out.println("\nTotal de ventas de la sucursal 1  : $"+ totalSuc1);

		System.out.println("\nTotal de ventas de la sucursal 2 : $"+ totalSuc2);

		System.out.println("\nTotal de ventas de la sucursal 3 : $"+ totalSuc3);
	}
	
	public static void reporte2 (Date f1, Date f2) {
		double totalCadenaPr = 0;
		double totalCadenaOs = 0;
		double totalSuc1Pr= 0;
		double totalSuc2Pr= 0;
		double totalSuc3Pr= 0;
		double totalSuc1Os= 0;
		double totalSuc2Os= 0;
		double totalSuc3Os= 0;
		
		for(Venta v : Vdao.traerVentasEntreFechas(f1, f2)) {
			//System.out.println(v.getSucursal().getPtoVenta());
				if (v.getCliente().isTieneOS()) {
					totalCadenaOs += v.getTotalVenta();
					if (v.getSucursal().getPtoVenta() == 1) {
						totalSuc1Os += v.getTotalVenta();
					}
					if (v.getSucursal().getPtoVenta() == 2) {
						totalSuc2Os += v.getTotalVenta();
					}
					if (v.getSucursal().getPtoVenta() == 3) {
						totalSuc3Os += v.getTotalVenta();
					}
				}else {
					totalCadenaPr += v.getTotalVenta();
					if (v.getSucursal().getPtoVenta() == 1) {
						totalSuc1Pr += v.getTotalVenta();
					}
					if (v.getSucursal().getPtoVenta() == 2) {
						totalSuc2Pr += v.getTotalVenta();
					}
					if (v.getSucursal().getPtoVenta() == 3) {
						totalSuc3Pr += v.getTotalVenta();
				}
				
			}
		}
		
		System.out.println( "Detalle y totales de ventas para la cadena completa y por sucursal,"
				+ " por obra social o privados entre " + Funciones.cambiarFormato(f1)+" y " + Funciones.cambiarFormato(f2) );
		
		System.out.println("\nVentas a privados");
		System.out.println("\n Total en la cadena : $" + totalCadenaPr);
		System.out.println("\n Total en la sucursal 1 : $" + totalSuc1Pr);
		System.out.println("\n Total en la sucursal 2 : $" + totalSuc2Pr);
		System.out.println("\n Total en la sucursal 3 : $" + totalSuc3Pr);
		
		System.out.println("\nVentas a obra social");
		System.out.println("\n Total en la cadena : $" + totalCadenaOs);
		System.out.println("\n Total en la sucursal 1 : $" + totalSuc1Os);
		System.out.println("\n Total en la sucursal 2 : $" + totalSuc2Os);
		System.out.println("\n Total en la sucursal 3 : $" + totalSuc3Os);
		
	}

	public static void reporte3 (Date f1, Date f2) {
		double totalCadenaEf = 0;
		double totalCadenaDe = 0;
		double totalCadenaCr = 0;
		double totalSuc1Ef= 0;
		double totalSuc2Ef= 0;
		double totalSuc3Ef= 0;
		double totalSuc1De= 0;
		double totalSuc2De= 0;
		double totalSuc3De= 0;
		double totalSuc1Cr= 0;
		double totalSuc2Cr= 0;
		double totalSuc3Cr= 0;
		
		for(Venta v : Vdao.traerVentasEntreFechas(f1, f2)) {
			//System.out.println(v.getFormaPago().getFormaPago());
				if (v.getFormaPago().getFormaPago().equals("Efectivo")) {
					totalCadenaEf += v.getTotalVenta();
					if (v.getSucursal().getPtoVenta() == 1) {
						totalSuc1Ef += v.getTotalVenta();
					}
					if (v.getSucursal().getPtoVenta() == 2) {
						totalSuc2Ef += v.getTotalVenta();
					}
					if (v.getSucursal().getPtoVenta() == 3) {
						totalSuc3Ef += v.getTotalVenta();
					}
				} 
				if (v.getFormaPago().getFormaPago().equals("Débito")) {
					totalCadenaDe += v.getTotalVenta();
					if (v.getSucursal().getPtoVenta() == 1) {
						totalSuc1De += v.getTotalVenta();
					}
					if (v.getSucursal().getPtoVenta() == 2) {
						totalSuc2De += v.getTotalVenta();
					}
					if (v.getSucursal().getPtoVenta() == 3) {
						totalSuc3De += v.getTotalVenta();
					} 
				}		
				if (v.getFormaPago().getFormaPago().equals("Crédito")){
					totalCadenaCr += v.getTotalVenta();
					if (v.getSucursal().getPtoVenta() == 1) {
						totalSuc1Cr += v.getTotalVenta();
						}
					if (v.getSucursal().getPtoVenta() == 2) {
						totalSuc2Cr += v.getTotalVenta();
						}
					if (v.getSucursal().getPtoVenta() == 3) {
						totalSuc3Cr += v.getTotalVenta();
						}
				}
				}
		
		System.out.println("Detalle y totales de cobranza para la cadena completa y por sucursal, por medio de pago "
							+ "y entre " + Funciones.cambiarFormato(f1)+" y " + Funciones.cambiarFormato(f2) );
		
		System.out.println("\nVentas en efectivo");
		System.out.println("\n Total en la cadena : $" + totalCadenaEf);
		System.out.println("\n Total en la sucursal 1 : $" + totalSuc1Ef);
		System.out.println("\n Total en la sucursal 2 : $" + totalSuc2Ef);
		System.out.println("\n Total en la sucursal 3 : $" + totalSuc3Ef);
		
		System.out.println("\nVentas por débito");
		System.out.println("\n Total en la cadena : $" + totalCadenaDe);
		System.out.println("\n Total en la sucursal 1 : $" + totalSuc1De);
		System.out.println("\n Total en la sucursal 2 : $" + totalSuc2De);
		System.out.println("\n Total en la sucursal 3 : $" + totalSuc3De);
		
		System.out.println("\nVentas por crédito");
		System.out.println("\n Total en la cadena : $" + totalCadenaCr);
		System.out.println("\n Total en la sucursal 1 : $" + totalSuc1Cr);
		System.out.println("\n Total en la sucursal 2 : $" + totalSuc2Cr);
		System.out.println("\n Total en la sucursal 3 : $" + totalSuc3Cr);
	
	}
	
	public static void reporte4 (Date f1, Date f2) {
		double totalCadenaPer = 0;
		double totalCadenaMed = 0;
		double totalSuc1Per= 0;
		double totalSuc2Per= 0;
		double totalSuc3Per= 0;
		double totalSuc1Med= 0;
		double totalSuc2Med= 0;
		double totalSuc3Med= 0;
		
		
		for(Venta v : Vdao.traerVentasEntreFechas(f1, f2)) {
			//System.out.println(v.getNroTicket());
			for (ItemVenta item : v.getItems()) {
				//System.out.println(item.getProducto().getTipoProducto().getTipo());
				String tipoProd = item.getProducto().getTipoProducto().getTipo();
				double valor = item.getCantidad() * item.getPrecioUnitario();
				
				if (tipoProd.equals("perfumeria")) {
					totalCadenaPer += valor;
					if(v.getSucursal().getPtoVenta()==1) {
						totalSuc1Per += valor;
					}
					if(v.getSucursal().getPtoVenta()==2) {
						totalSuc2Per += valor;
					}
					if(v.getSucursal().getPtoVenta()==3) {
						totalSuc3Per += valor;
					}
				}
				else {
					totalCadenaMed += valor;
					if(v.getSucursal().getPtoVenta()==1) {
						totalSuc1Med += valor;
					}
					if(v.getSucursal().getPtoVenta()==2) {
						totalSuc2Med += valor;
					}
					if(v.getSucursal().getPtoVenta()==3) {
						totalSuc3Med += valor;
					}
				}
			}
				
		}
		
		System.out.println(" Detalle y totales de ventas de productos, total de la cadena y por sucursal, diferenciados" + 
				" entre farmacia y perfumería, entre " + Funciones.cambiarFormato(f1)+" y " + Funciones.cambiarFormato(f2) );
		
		System.out.println("\n Ventas de medicamento");
		System.out.println("totales de la cadena: $" + totalCadenaMed);
		System.out.println("de la sucursal 1: $" + totalSuc1Med);
		System.out.println("de la sucursal 2: $" + totalSuc2Med);
		System.out.println("de la sucursal 3: $" + totalSuc3Med);
		
		System.out.println("\n Ventas de Perfumería");
		System.out.println("totales de la cadena: $" + totalCadenaPer);
		System.out.println("de la sucursal 1: $" + totalSuc1Per);
		System.out.println("de la sucursal 2: $" + totalSuc2Per);
		System.out.println("de la sucursal 3: $" + totalSuc3Per);
	}
	
}
