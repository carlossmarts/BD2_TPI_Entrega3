var db = connect("localhost:27017/mongoDB4");


var fechaInicio = new Date ("2020/02/02");
var fechaFin = new Date ("2020/02/02");
var tsi = "" + fechaInicio.getTime();
var tsf = "" + fechaFin.getTime();



var totalCad = db.ventas.aggregate([
    {$match: 
        {fecha: 
            { $gte : tsi , $lte : tsf}
        }
    },
    {$group: {
            _id: {},
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
            _id: {
                sucursal: "$sucursal.ptoVenta" , //group by
                },
            total: {$sum: "$totalVenta"}        //operacion de acumulador
        }
    },
    {
        $sort: {"_id.sucursal":1}               //Ordenar arreglo
    }
]);

print(`\nReporte de ventas por entre fechas\n inicial: ${fechaInicio} \n final: ${fechaFin}`);
print("\npara toda la cadena");
totalCad.forEach(element => printjson(element));
print("\n por sucursal");
totalSuc.forEach(element => printjson(element));



