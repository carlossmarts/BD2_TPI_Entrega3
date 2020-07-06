var db = connect("localhost:27017/mongoDB4");

var proy = db.ventas.aggregate(
    [
        { $project: {
            _id: 0,
            sucursal: "$sucursal.ptoVenta",
            total: "$totalVenta"
        }

        }
    ]
);

proy.forEach(doc => printjson(doc));

