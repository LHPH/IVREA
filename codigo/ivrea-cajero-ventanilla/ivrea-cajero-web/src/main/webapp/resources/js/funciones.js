function actualizarBarra(){
        $(".pagination li").each(function(num){
            $(this).children().addClass("page-link");
        });
    }

function cambiarMetodoEnvio(form,metodo){
    $("#"+form).attr("method",metodo);
}

function validarCantidad(cantidad){
    if(!isNaN(cantidad)){
        if(isFinite(cantidad)){
            if(cantidad>0){
                return true;
            }
        }
    }
    return false;
}

function validarNumeroCuenta(cuenta){
    if(cuenta.length===6){
        if(!isNaN(parseInt(cuenta))){
            return true;
        }
    }
    return false;
}