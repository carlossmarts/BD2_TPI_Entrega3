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

import model.ObraSocial;
import model.ObraSocial;

public class ObraSocialDAO {
	// Objeto Gson para conversión de tipos
	Gson gson = new Gson();
	
	//conexión a la base de datos.
	//bd
	Mongo mongo = new Mongo ("localhost", 27017);
	DB db = mongo.getDB("mongoDB4");
	//colección
	DBCollection col = db.getCollection("obraSociales");
	
	public ObraSocial traer(String nombre) {
		ObraSocial retorno = null;
		BasicDBObject query = new BasicDBObject();
		query.put("nombre",nombre);
		DBObject os = col.findOne(query);
		retorno = gson.fromJson(os.toString(), ObraSocial.class);
		return retorno;
	}
	
	public List<ObraSocial> traerOSs() {
		List<ObraSocial> retorno = new ArrayList();
		DBCursor cursor = col.find();
		while(cursor.hasNext()) {
			DBObject dbo = cursor.next();
			ObraSocial os= gson.fromJson(dbo.toString(), ObraSocial.class);
			retorno.add(os);
		}
		return retorno;
		}
	
	public boolean agregar(ObraSocial os) {
		String osJson = gson.toJson(os);
		DBObject dbObject = (DBObject) JSON.parse(osJson);
		col.insert(dbObject);
		return true;
	}
	

}
