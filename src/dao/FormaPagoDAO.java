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

import model.FormaPago;
import model.ObraSocial;

public class FormaPagoDAO {
	// Objeto Gson para conversión de tipos
		Gson gson = new Gson();
		
		//conexión a la base de datos.
		//bd
		Mongo mongo = new Mongo ("localhost", 27017);
		DB db = mongo.getDB("mongoDB4");
		//colección
		DBCollection col = db.getCollection("formasPago");
		
		public FormaPago traer(String formaPago) {
			FormaPago retorno = null;
			BasicDBObject query = new BasicDBObject();
			query.put("formaPago",formaPago);
			DBObject os = col.findOne(query);
			retorno = gson.fromJson(os.toString(), FormaPago.class);
			return retorno;
		}
		
		public List<FormaPago> traerFormasPago() {
			List<FormaPago> retorno = new ArrayList();
			DBCursor cursor = col.find();
			while(cursor.hasNext()) {
				DBObject dbo = cursor.next();
				FormaPago fp= gson.fromJson(dbo.toString(), FormaPago.class);
				retorno.add(fp);
			}
			return retorno;
			}
		
		public boolean agregar(FormaPago fp) {
			String osJson = gson.toJson(fp);
			DBObject dbObject = (DBObject) JSON.parse(osJson);
			col.insert(dbObject);
			return true;
		}
		
}
