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

public class algo {

	public static void main(String[] args) {
		Date fecha = new Date("2020/02/03");
		long f = 1580698800000L;
		Date fecha2 = new Date(f);
		
		System.out.println("fecha: "+ fecha.getTime());
		System.out.println("fecha2: "+ Funciones.cambiarFormato( fecha2));
		
	}

}
