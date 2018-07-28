function actualizarBarra(){
        $(".pagination li").each(function(num){
            $(this).children().addClass("page-link");
        });
    }

function cambiarMetodoEnvio(form){
    $("#"+form).attr("method", "post");
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
    if(cuenta.length===10){
        if(!isNaN(parseInt(cuenta))){
            return true;
        }
    }
    return false;
}