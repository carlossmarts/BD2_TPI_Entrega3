package test;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.util.JSON;
import funciones.Funciones;
import negocio.Reportes;

public class testReportes {

	public static void main(String[] args) {
		//Reportes.reporte1(new Date("2020/02/02"), new Date("2020/02/02"));	
		
		//Reportes.reporte2(new Date("2020/02/02"), new Date("2020/02/05"));
		
		//Reportes.reporte3(new Date("2020/02/02"), new Date("2020/02/05"));
		
		Reportes.reporte4(new Date("2020/02/02"), new Date("2020/02/02"));
	}

}
