var db = connect("localhost:27017/mongoDB4");

//Ranking de ventas de productos, total de la cadena y por sucursal, entre fechas, por monto.

//Fechas
var fechaInicio = new Date ("2020/02/02");
var fechaFin = new Date ("2020/02/03");
var tsi = "" + fechaInicio.getTime();
var tsf = "" + fechaFin.getTime();

//Consulta
var rankingCad = db.ventas.aggregate([
    //filtrar entre fechas
    {$match: 
        {
            fecha: {$gte: tsi, $lte: tsf}
        }
    },
    //Desglosar items venta
    {$unwind: "$items"},
    //Seleccoinar item, cantidad y precio
    {$project:
        {
            item: "$items.producto.descripcion",
            cantidad: "$items.cantidad",
            precio: "$items.precioUnitario",
            subtotal: {$multiply: ["$items.cantidad", "$items.precioUnitario"]}
        }
    },
    //Agrupar por item
    {$group: 
        {
            _id: {
                item: "$item"   //group by
            },
            total: {$sum: "$subtotal"}
        }
    },
    //Ordenar por total de ventas
    {$sort: {"total": -1}
    }
]);


var rankingSuc = db.ventas.aggregate([
    {$match:
        {
            fecha: {$gte: tsi, $lte: tsf}
        }
    },
    {$unwind: "$items"},
    //seleccionar sucursal, item, cantidad y precio
    {$project:
        {
            sucursal: "$sucursal.ptoVenta",
            producto: "$items.producto.descripcion",
            precio: "$items.precioUnitario",
            cantidad: "$items.cantidad",
            subtotal: {$multiply: ["$items.cantidad", "$items.precioUnitario"]}
        }
    },
    //agrupar por sucursal y por item, sumar subtotal
    {$group:
        {   //group by
            _id: {
                sucursal: "$sucursal",
                producto: "$producto"
            },
            total: {$sum: "$subtotal"}
        }
    },
    {$sort: {"_id.sucursal": 1, "total": (-1)}}


]);
print(`\nRanking de productos entre fechas: \nInicial: ${fechaInicio}\nFinal: ${fechaFin}` );
print(`\nRanking de ventas en la cadena:`)
rankingCad.forEach(doc => print(`Producto: ${doc._id.item},         Total de ventas: ${doc.total}`));

print(`\nRanking de ventas por sucursal`)
rankingSuc.forEach(doc => print(`Sucursal: ${doc._id.sucursal}, producto: ${doc._id.producto},      total de ventas: ${doc.total}`));