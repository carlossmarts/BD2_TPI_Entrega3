package dao;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.util.JSON;

import model.Venta;

public class VentaDAO {
	// Objeto Gson para conversión de tipos
			Gson gson = new Gson();
			
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
			
			public List<Venta> traerVentas() {
				List<Venta> retorno = new ArrayList();
				DBCursor cursor = col.find();
				while(cursor.hasNext()) {
					DBObject dbo = cursor.next();
					Venta v= gson.fromJson(dbo.toString(), Venta.class);
					retorno.add(v);
				}
				return retorno;
				}
			
			public boolean agregar(Venta v) {
				String osJson = gson.toJson(v);
				DBObject dbObject = (DBObject) JSON.parse(osJson);
				col.insert(dbObject);
				return true;
			}

}
