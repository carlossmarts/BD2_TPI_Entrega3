var db = connect("localhost:27017/mongoDB4");

//Detalle y totales de ventas para la cadena completa y por sucursal, por obra social o privados entre fechas.

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
            _id: {
                os: "$cliente.tieneOS", //group by
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
            _id: {
                sucursal: "$sucursal.ptoVenta" ,    //group by
                os: "$cliente.tieneOS",             //group by
            },
            total: {$sum: "$totalVenta"}        //operacion de acumulador
        }
    },
    {
        $sort: {"_id.sucursal":1}               //Ordenar arreglo
    }
]);

print(`\n\nReporte de ventas de la diferenciando entre privado y obra social entre fechas: 
        \nInicial: ${fechaInicio} 
        \nFinal: ${fechaFin}`);

print("\n ventas para toda la cadena")
while (totalCad.hasNext()){
    var doc = totalCad.next();
    var tieneOs = doc._id.os;
    var osp = "";
    if (tieneOs){
        osp = "obra social";
    }
    else{
        osp = "privado"
    } 
    print(`Ventas a ${osp}: $: ${doc.total} `);
}

print("\n ventas por sucursal")
while (totalSuc.hasNext()){
    var doc = totalSuc.next();
    var tieneOs = doc._id.os;
    var osp = "";
    if (tieneOs){
        osp = "obra social";
    }
    else{
        osp = "privado"
    } 
    print(`Ventas a ${osp} para la sucursal ${doc._id.sucursal} :$ ${doc.total} `)
}
