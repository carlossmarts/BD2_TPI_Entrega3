package funciones;

import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Funciones {
	public static String cambiarFormato(Date fecha) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return sdf.format(fecha);
	}
}
