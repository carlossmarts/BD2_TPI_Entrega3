package dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.util.JSON;

import funciones.Funciones;
import model.Venta;

public class VentaDAO {
			// Objeto Gson para conversión de tipos
			Gson gson = new Gson();
			//Gson para fecha con formato especifico
			Gson gson2 = new GsonBuilder().setDateFormat("dd/MM/yyyy").create();
			//conexión a la base de datos.
			//bd
			Mongo mongo = new Mongo ("localhost", 27017);
			DB db = mongo.getDB("mongoDB4");
			//colección
			DBCollection col = db.getCollection("ventas");
			
			public Venta traer(String nroTicket) {
				Venta retorno = null;
				BasicDBObject query = new BasicDBObject();
				query.put("nroTicket",nroTicket);
				DBObject dbo = col.findOne(query);
				retorno = gson.fromJson(dbo.toString(), Venta.class);
				return retorno;
			}
			
			
			/*
			public boolean agregar(Venta v) {
				String osJson = gson.toJson(v);
				DBObject dbObject = (DBObject) JSON.parse(osJson);
				col.insert(dbObject);
				return true;
			}
			*/
			public boolean agregar(Venta v) {
				String osJson = gson.toJson(v);
				DBObject dbObject = (DBObject) JSON.parse(osJson);
				//convertimos la fecha a formato timestamp
				dbObject.put("fecha","" + v.getFecha().getTime());
				col.insert(dbObject);
				return true;
			}
			
			public List<Venta> traerVentas() {
				List<Venta> retorno = new ArrayList();
				DBCursor cursor = col.find();
				while(cursor.hasNext()) {
					DBObject dbo = cursor.next();
					//Obtenemos la fecha en formato timestamp y lo convertimos a long
					long f = Long.parseLong(String.valueOf(dbo.get("fecha")));
					
					//convertimos a formato DD/MM/YYYY
					//en el caso del registro vacio la fecha sera 01/01/1970
					String fechaFormateada = Funciones.cambiarFormato(new Date(f));
					//Lo reinsertamos en el objeto
					dbo.put("fecha", fechaFormateada);
					Venta v= gson2.fromJson(dbo.toString(), Venta.class);
					retorno.add(v);
				}
				return retorno;
				}
			
			public List<Venta> traerVentasEntreFechas(Date menor, Date mayor) {
				BasicDBObject query = new BasicDBObject();
				BasicDBObject subquery = new BasicDBObject();
				
				String fmenor = "" + menor.getTime();
				String fmayor = "" + mayor.getTime();
				
				subquery.put("$gte", fmenor );
				subquery.put("$lt", fmayor );
				query.put("fecha", subquery);
				//System.out.println(subquery);
				//System.out.println(query);
				
				List<Venta> retorno = new ArrayList();
				DBCursor cursor = col.find(query);
				while(cursor.hasNext()) {
					DBObject dbo = cursor.next();
					//Obtenemos la fecha en formato timestamp y lo convertimos a long
					long f = Long.parseLong(String.valueOf(dbo.get("fecha")));
					//convertimos a formato DD/MM/YYYY
					String fechaFormateada = Funciones.cambiarFormato(new Date(f));
					//System.out.println(fechaFormateada);
					//Lo reinsertamos en el objeto
					dbo.put("fecha", fechaFormateada);
					Venta v= gson2.fromJson(dbo.toString(), Venta.class);
					retorno.add(v);
				}
				return retorno;
				}
			

}
