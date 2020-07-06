var db = connect("localhost:27017/mongoDB4");

//Detalle y totales de ventas de productos, total de la cadena y por sucursal, entre fechas, diferenciados
//entre farmacia y perfumería.

var fechaInicio = new Date ("2020/02/02");
var fechaFin = new Date ("2020/02/03");
var tsi = "" + fechaInicio.getTime();
var tsf = "" + fechaFin.getTime();



var totalCad = db.ventas.aggregate([
    
    //Buscar ventas entre fechas indicadas
    {$match: 
        {fecha: 
            { $gte : tsi , $lte : tsf}      
        }
    },
    //Desglosar todos los item de las ventas encontradas
    {$unwind: "$items"},
    //seleccionar solo los elementos de interes
    {$project: {
        sucursal: "$sucursal.ptoVenta",
        item:"$items.producto.tipoProducto.tipo",
        subtotal: {
            $multiply: ["$items.cantidad", "$items.precioUnitario"]
        }
        }
    },
    {$group:{
            _id: {tipoProducto: "$item"},
            total: {$sum: "$subtotal"}
        }
    }
]);

var totalSuc = db.ventas.aggregate([
    //Buscar ventas entre fechas indicadas
    {$match: 
        {fecha: 
            { $gte : tsi , $lte : tsf}      
        }
    },
    {$unwind: "$items"},
    {$project: {
        sucursal: "$sucursal.ptoVenta",
        item:"$items.producto.tipoProducto.tipo",
        subtotal: {
            $multiply: ["$items.cantidad", "$items.precioUnitario"]
        }
        }
    },
    {$group:{
            _id: {tipoProd: "$item", sucursal:"$sucursal"},
            total: {$sum: "$subtotal"}
        }
    },
    {$sort: {"_id.sucursal":1}
    }
]);


print (`\nReporte de ventas según tipo de producto entre fechas \nInicial: ${fechaInicio}\nfinal ${fechaFin}`);
print(`\nVentas en toda la cadena`);
totalCad.forEach(doc => printjson(doc));

print (`\nReporte de ventas según tipo de producto entre fechas \nInicial: ${fechaInicio}\nfinal ${fechaFin}`);
print(`\nVentas por sucursal`);
totalSuc.forEach(doc => printjson(doc));
