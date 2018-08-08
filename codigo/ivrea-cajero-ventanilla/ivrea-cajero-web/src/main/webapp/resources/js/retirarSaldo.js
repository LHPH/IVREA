$(document ).ready(function() {
   
});

function validarFormRetiro(saldo,retiro){
    if(saldo-retiro<0){
        return false;
    }
    return true;
}

function validarVistaRetirarSaldo(form){
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
    console.log("Ret "+cont);
    if(cont===0){
        cambiarMetodoEnvio(form,'POST');
        return true; //Cambiar a true
    }
    return false;
}