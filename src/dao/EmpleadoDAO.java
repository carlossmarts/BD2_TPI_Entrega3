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

import model.Empleado;

public class EmpleadoDAO {
	// Objeto Gson para conversión de tipos
				Gson gson = new Gson();
				
				//conexión a la base de datos.
				//bd
				Mongo mongo = new Mongo ("localhost", 27017);
				DB db = mongo.getDB("mongoDB4");
				//colección
				DBCollection col = db.getCollection("empleados");
				
				public Empleado traer(String dni) {
					Empleado retorno = null;
					BasicDBObject query = new BasicDBObject();
					query.put("dni",dni);
					DBObject dbo = col.findOne(query);
					retorno = gson.fromJson(dbo.toString(), Empleado.class);
					return retorno;
				}
				
				public List<Empleado> traerEmpleados() {
					List<Empleado> retorno = new ArrayList();
					DBCursor cursor = col.find();
					while(cursor.hasNext()) {
						DBObject dbo = cursor.next();
						Empleado e= gson.fromJson(dbo.toString(), Empleado.class);
						retorno.add(e);
					}
					return retorno;
					}
				
				public boolean agregar(Empleado e) {
					String osJson = gson.toJson(e);
					DBObject dbo = (DBObject) JSON.parse(osJson);
					col.insert(dbo);
					return true;
				}
}
