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

import model.TipoProducto;

public class TipoProductoDAO {
	// Objeto Gson para conversión de tipos
			Gson gson = new Gson();
			
			//conexión a la base de datos.
			//bd
			Mongo mongo = new Mongo ("localhost", 27017);
			DB db = mongo.getDB("mongoDB4");
			//colección
			DBCollection col = db.getCollection("tiposProducto");
			
			public TipoProducto traer(String tipo) {
				TipoProducto retorno = null;
				BasicDBObject query = new BasicDBObject();
				query.put("tipo",tipo);
				DBObject os = col.findOne(query);
				retorno = gson.fromJson(os.toString(), TipoProducto.class);
				return retorno;
			}
			
			public List<TipoProducto> traerTiposProducto() {
				List<TipoProducto> retorno = new ArrayList();
				DBCursor cursor = col.find();
				while(cursor.hasNext()) {
					DBObject dbo = cursor.next();
					TipoProducto tp= gson.fromJson(dbo.toString(), TipoProducto.class);
					retorno.add(tp);
				}
				return retorno;
				}
			
			public boolean agregar(TipoProducto tp) {
				String osJson = gson.toJson(tp);
				DBObject dbObject = (DBObject) JSON.parse(osJson);
				col.insert(dbObject);
				return true;
			}
}
