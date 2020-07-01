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

import model.Sucursal;

public class SucursalDAO {
	// Objeto Gson para conversión de tipos
			Gson gson = new Gson();
			
			//conexión a la base de datos.
			//bd
			Mongo mongo = new Mongo ("localhost", 27017);
			DB db = mongo.getDB("mongoDB4");
			//colección
			DBCollection col = db.getCollection("sucursales");
			
			public Sucursal traer(String sucursal) {
				Sucursal retorno = null;
				BasicDBObject query = new BasicDBObject();
				query.put("sucursal",sucursal);
				DBObject dbo = col.findOne(query);
				retorno = gson.fromJson(dbo.toString(), Sucursal.class);
				return retorno;
			}
			
			public List<Sucursal> traerSucursales() {
				List<Sucursal> retorno = new ArrayList();
				DBCursor cursor = col.find();
				while(cursor.hasNext()) {
					DBObject dbo = cursor.next();
					Sucursal s= gson.fromJson(dbo.toString(), Sucursal.class);
					retorno.add(s);
				}
				return retorno;
				}
			
			public boolean agregar(Sucursal s) {
				String osJson = gson.toJson(s);
				DBObject dbObject = (DBObject) JSON.parse(osJson);
				col.insert(dbObject);
				return true;
			}

}
