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

import model.Producto;

public class ProductoDAO {
		// Objeto Gson para conversión de tipos
		Gson gson = new Gson();
		
		//conexión a la base de datos.
		//bd
		Mongo mongo = new Mongo ("localhost", 27017);
		DB db = mongo.getDB("mongoDB4");
		//colección
		DBCollection col = db.getCollection("productos");
		
		public Producto traer(String codigo) {
			Producto retorno = null;
			BasicDBObject query = new BasicDBObject();
			query.put("codNumerico",codigo);
			DBObject dbo = col.findOne(query);
			retorno = gson.fromJson(dbo.toString(), Producto.class);
			return retorno;
		}
		
		public List<Producto> traerProductos() {
			List<Producto> retorno = new ArrayList();
			DBCursor cursor = col.find();
			while(cursor.hasNext()) {
				DBObject dbo = cursor.next();
				Producto p= gson.fromJson(dbo.toString(), Producto.class);
				retorno.add(p);
			}
			return retorno;
			}
		
		public boolean agregar(Producto p) {
			String osJson = gson.toJson(p);
			DBObject dbObject = (DBObject) JSON.parse(osJson);
			col.insert(dbObject);
			return true;
		}
}
