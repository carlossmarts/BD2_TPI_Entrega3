//Ranking de clientes por compras, total de la cadena y por sucursal, entre fechas, por cantidad vendida.
var db = connect("localhost:27017/mongoDB4");

var fechaInicio = new Date ("2020/02/02");
var fechaFin = new Date ("2020/02/03");
var tsi = "" + fechaInicio.getTime();
var tsf = "" + fechaFin.getTime();

var rankingClientesCad = db.ventas.aggregate([
    {$match:
        {
            fecha: {$gte: tsi, $lte: tsf}
        }
    },
    {$unwind: "$items"    
    },
    {$project:
        {
            cliente: {nombre: "$cliente.nombre", apellido: "$cliente.apellido"},
            subtotal: "$totalVenta",
            cantItems: "$items.cantidad"
        }
    },
    {$group:
        {
            _id: {cliente: "$cliente"},      //group by
            total: {$sum: "$cantItems"}
        }
    },
    {$sort: {"total": -1}}                        //order by
]);

var rankingClientesSuc = db.ventas.aggregate([
    {$match:
        {
            fecha: {$gte: tsi, $lte: tsf}
        }
    },
    {$unwind: "$items"    
    },
    {$project:
        {
            cliente: {nombre: "$cliente.nombre", apellido: "$cliente.apellido"},
            subtotal: "$totalVenta",
            cantItems: "$items.cantidad",
            sucursal: "$sucursal.ptoVenta"
        }
    },
    {$group:
        {
            _id: {sucursal: "$sucursal", cliente: "$cliente"},      //group by
            total: {$sum: "$cantItems"}
        }
    },
    {$sort: {"_id.sucursal": 1, "total": -1}}                        //order by
]);


print(`\nRanking de clientes por cantidad de articulos entre fechas:\nInicial: ${fechaInicio}\nFinal: ${fechaFin}\n`);
print(`\n Ranking en toda la cadena`);
rankingClientesCad.forEach(doc => print(`Cliente: ${doc._id.cliente.nombre} ${doc._id.cliente.apellido}, articulos comprados: ${doc.total}`));

print(`\nranking por sucursal`);
rankingClientesSuc.forEach(doc => print(`Sucursal: ${doc._id.sucursal}, Cliente: ${doc._id.cliente.nombre} ${doc._id.cliente.apellido}, articulos comprados: ${doc.total}`));