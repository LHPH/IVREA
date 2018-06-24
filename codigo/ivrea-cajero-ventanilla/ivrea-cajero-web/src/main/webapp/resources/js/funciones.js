function validarLogin(){
	var numTarjeta = $("#campoTarjeta").val();
	var nip = $("#campoNip").val();
	if(numTarjeta===null || numTarjeta===''){
		$("#campoTarjeta").addClass("is-invalid");
		return false;
	}
	if(nip===null || nip===''){
		$("#campoNip").addClass("is-invalid");
		return false;
	}
	return true;
}


function validarFormRetiro(){
    var saldo=$("#campoSaldo").val();
    var retiro=$("#campoCantidad").val();
    if(retiro-saldo<0){
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

function actualizarBarra(){
        $(".pagination li").each(function(num){
            $(this).children().addClass("page-link");
        });
    }

function cambiarMetodoEnvio(form){
    $("#"+form).attr("method", "post");
}


$(document ).ready(function() {
    $("#formLogin").submit(function(event){
    	if(validarLogin()===false){
    		event.preventDefault();
    	}
    	$("#formLogin").addClass("was-validated");
    });

    $("#campoTarjeta").keyup(formatoTarjeta);
});

function cargarForm(){
    $("#formRetirarSaldo").submit(function(event){
        if(validarFormRetiro()===false){
            event.preventDefault();
            $("#campoSaldo").addClass("form-control is-invalid");
            $("#campoCantidadMensaje").addClass("invalid-feedback")
            $("#campoCantidad").addClass("form-control is-invalid");
        }
        $("#formRetirarSaldo").addClass("was-validated");
    });
}