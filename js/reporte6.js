var db = connect("localhost:27017/mongoDB4");

//Ranking de ventas de productos, total de la cadena y por sucursal, entre fechas, por cantidad vendida..

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
            cantidad: "$items.cantidad"
        }
    },
    //Agrupar por item
    {$group: 
        {
            _id: {
                item: "$item"   //group by
            },
            cantidad: {$sum: "$cantidad"}
        }
    },
    //Ordenar por total de ventas
    {$sort: {"cantidad": -1}
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
            cantidad: "$items.cantidad"
        }
    },
    //agrupar por sucursal y por item, sumar subtotal
    {$group:
        {   //group by
            _id: {
                sucursal: "$sucursal",
                producto: "$producto"
            },
            cantidad: {$sum: "$cantidad"}
        }
    },
    {$sort: {"_id.sucursal": 1, "cantidad": (-1)}}


]);
print(`\nRanking de productos entre fechas: \nInicial: ${fechaInicio}\nFinal: ${fechaFin}` );
print(`\nRanking de ventas en la cadena:`)
rankingCad.forEach(doc => print(`Producto: ${doc._id.item},         Total de ventas: ${doc.cantidad}`));

print(`\nRanking de ventas por sucursal`)
rankingSuc.forEach(doc => print(`Sucursal: ${doc._id.sucursal}, producto: ${doc._id.producto},      total de ventas: ${doc.cantidad}`));