$(document ).ready(function() {
   
});



function validarVistaDepositarSaldo(form){
	var saldo=$("#campoSaldo").val();
	var deposito=$("#campoCantidad").val();
	var cuenta = $("#campoCuenta").val();
	var cont=0;
	if(!validarCantidad(saldo)){
		$("#campoSaldo").addClass("is-invalid");
		cont++;
	}
	else{
		$("#campoSaldo").removeClass("is-invalid").addClass("is-valid");
	}
	if(!validarCantidad(deposito)){
		$("#campoCantidad").addClass("is-invalid");
		cont++;
	}
	else{
		$("#campoCantidad").removeClass("is-invalid").addClass("is-valid");
	}
	if(!validarNumeroCuenta(cuenta)){
		$("#campoCuenta").addClass("is-invalid");
		cont++;
	}
	else{
		$("#campoCuenta").removeClass("is-invalid").addClass("is-valid");
	}
	console.log("Dep "+cont);
	if(cont===0){
		cambiarMetodoEnvio(form,'POST');
		return true; //Cambiar a true
	}
	return false;
}