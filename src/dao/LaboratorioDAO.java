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

import model.Laboratorio;

public class LaboratorioDAO {
	Gson gson = new Gson();
	
	//conexión a la base de datos.
	//bd
	Mongo mongo = new Mongo ("localhost", 27017);
	DB db = mongo.getDB("mongoDB4");
	//colección
	DBCollection col = db.getCollection("laboratorios");
	
	public Laboratorio traer(String nombre) {
		Laboratorio retorno = null;
		BasicDBObject query = new BasicDBObject();
		query.put("nombre",nombre);
		DBObject os = col.findOne(query);
		retorno = gson.fromJson(os.toString(), Laboratorio.class);
		return retorno;
	}
	
	public List<Laboratorio> traerLaboratorios() {
		List<Laboratorio> retorno = new ArrayList();
		DBCursor cursor = col.find();
		while(cursor.hasNext()) {
			DBObject dbo = cursor.next();
			Laboratorio lab= gson.fromJson(dbo.toString(), Laboratorio.class);
			retorno.add(lab);
		}
		return retorno;
		}
	
	public boolean agregar(Laboratorio lab) {
		String osJson = gson.toJson(lab);
		DBObject dbObject = (DBObject) JSON.parse(osJson);
		col.insert(dbObject);
		return true;
	}

}
