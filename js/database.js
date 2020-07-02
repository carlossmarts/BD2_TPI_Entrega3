//conexión a la base de datos


db.dropDatabase();

db.obraSociales.insert({"nombre": "" });

db.empleados.insert ({"dni": "",
                    "nombre": "",
                    "apellido": "",
                    "direccion": "",
                    "obraSocial": {"nombre":""},
                    "cuil":""
                    });

db.clientes.insert ({"dni": "",
                    "nombre": "",
                    "apellido": "",
                    "direccion": "",
                    "obraSocial": {"nombre":""},
                    "tieneOS":""
                    });

db.formasPago.insert({ "formaPago":""});

db.tiposProducto.insert({"tipo": ""});

db.laboratorios.insert({"nombre": ""});

db.productos.insert({
                        "codNumerico": "",
                        "precio": 0,
                        "descripcion": "",
                        "tipoProducto": {"tipo": ""},
                        "laboratorio": {"nombre": ""}
                        });
db.sucursales.insert({
					"sucursal": "",
					"ptoVenta": 0,
					"empleados": [],
					"encargado": {},
					"direccion": ""
					});

db.ventas.insert({	"fecha": "0",
				    "nroTicket": "",
				    "formaPago": {},
				    "totalVenta": 0,
				    "vendedor": {},
				    "cobrador": {},
				    "cliente": {},
				    "sucursal": {},
				    "items": []
				  }
					
				);


print("\ndb: " + db.name);
print ("\nobras sociales");
db.obraSociales.find().forEach( doc => printjson(doc)
);
print ("\nempleados");
db.empleados.find().forEach( doc => printjson(doc)
);
print ("\nclientes");
db.clientes.find().forEach( doc => printjson(doc)
);
print ("\nformasPago");
db.formasPago.find().forEach( doc => printjson(doc)
);
print ("\ntiposProducto");
db.tiposProducto.find().forEach( doc => printjson(doc)
);
print ("\nlaboratorios");
db.laboratorios.find().forEach( doc => printjson(doc)
);
print ("\nproductos");
db.productos.find().forEach( doc => printjson(doc)
);
print ("\nsucursales");
db.sucursales.find().forEach( doc => printjson(doc)
);
print ("\nventas");
db.ventas.find().forEach( doc => printjson(doc)
);






