var db = connect("localhost:27017/mongoDB4");

//Detalle y totales de cobranza para la cadena completa y por sucursal, por medio de pago y entre fechas.

var fechaInicio = new Date ("2020/02/02");
var fechaFin = new Date ("2020/02/03");
var tsi = "" + fechaInicio.getTime();
var tsf = "" + fechaFin.getTime();



var totalCad = db.ventas.aggregate([
    {$match: 
        {fecha: 
            { $gte : tsi , $lte : tsf}
        }
    },
    {$group: {
            _id: {
                formaPago: "$formaPago.formaPago" //group by
                } , 
            total: {$sum: "$totalVenta"}
            }
    }
]);

var totalSuc = db.ventas.aggregate([
    {$match: 
        {fecha: 
            { $gte : tsi , $lte : tsf} //Filtrar por fechas
        }
    },
    {$group: 
        {
            _id: {sucursal: "$sucursal.ptoVenta" ,fp: "$formaPago.formaPago"},//group by
            total: {$sum: "$totalVenta"}        //operacion de acumulador
        }
    },
    {
        $sort: {"_id.sucursal":1}               //Ordenar arreglo
    }
]);

print(`\n\nReporte de ventas de la diferenciando entre por medio de pago entre fechas: 
        \nInicial: ${fechaInicio} 
        \nFinal: ${fechaFin}`);

print("\nVentas en toda la cadena");
totalCad.forEach(doc => printjson(doc));
print("\nVentas por sucursal");
totalSuc.forEach(doc => printjson(doc));