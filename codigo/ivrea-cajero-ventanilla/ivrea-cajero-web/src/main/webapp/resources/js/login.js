function validarLogin(){
	var numTarjeta = $("#campoTarjeta").val();
	var nip = $("#campoNip").val();
	if(numTarjeta===null || numTarjeta==='' || !validarNumeroTarjeta(numTarjeta)){
		$("#campoTarjeta").addClass("is-invalid");
		return false;
    }
    $("#campoTarjeta").removeClass("is-invalid").addClass("is-valid");
	if(nip===null || nip==='' || !validarNip(nip)){
		$("#campoNip").addClass("is-invalid");
		return false;
    }
    $("#campoNip").removeClass("is-invalid").addClass("is-valid");
	return true;
}

function validarNumeroTarjeta(tarjeta){
    if(tarjeta.length!=10){
        return false;
    }
    var trozos = tarjeta.split("-");
    if(trozos.length===3){
        if(validarLongitudNumero(trozos[0],3) && validarLongitudNumero(trozos[1],3) && validarLongitudNumero(trozos[2],2)){
            return true;
        }
        return false;
    }
    return false;

}

function validarLongitudNumero(trozo,longitud){
    if(trozo.length===longitud){
        if(!isNaN(trozo)){
            return true;
        }
        return false;
    }
    return false;
}

function validarNip(nip){
    if(isNaN(nip)){
        return false;
    }
    if(nip.length!==4){
        return false;
    }
    return true;
}

function formatoTarjeta(event){
	var val=$("#campoTarjeta").val();
        if(val.length===3 || val.length===7){
        	if(event.which!==8){
            	$("#campoTarjeta").val(val+"-");
            }
            else{
            	$("#campoTarjeta").val(val.substr(0,val.length-1));
            }
        }
}

$(document ).ready(function() {
    $("#formLogin").submit(function(event){
    	if(validarLogin()===false){
    		event.preventDefault();
    	}
    });
    $("#campoTarjeta").keyup(formatoTarjeta);
});