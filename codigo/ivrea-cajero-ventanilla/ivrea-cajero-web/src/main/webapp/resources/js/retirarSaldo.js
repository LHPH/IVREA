$(document ).ready(function() {
    $("#formRetirarSaldo").submit(function(event){
    	if(validarVistaRetirarSaldo()===false){
    		event.preventDefault();
    	}
    });
});

function validarFormRetiro(saldo,retiro){
    if(retiro-saldo<0){
        return false;
    }
    return true;
}

function validarVistaRetirarSaldo(){
    var saldo=$("#campoSaldo").val();
    var retiro=$("#campoCantidad").val();
    var cont=0;
    if(!validarCantidad(saldo)){
        $("#campoSaldo").addClass("is-invalid");
		cont++;
    }
    else{
        $("#campoSaldo").removeClass("is-invalid").addClass("is-valid");
    }
    if(!validarCantidad(retiro)){
        $("#campoCantidad").addClass("is-invalid");
		cont++;
    }
    else{
        $("#campoCantidad").removeClass("is-invalid").addClass("is-valid");
    }
    if(!validarFormRetiro(saldo,retiro)){
        $("#campoCantidad").addClass("is-invalid");
		cont++;
    }
    else{
        $("#campoSaldo").removeClass("is-invalid").addClass("is-valid");
    }
    if(cont===0){
        return false; //Cambiar a true
    }
    return false;
}