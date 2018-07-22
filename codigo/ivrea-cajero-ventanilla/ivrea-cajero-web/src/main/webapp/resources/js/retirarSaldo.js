$(document ).ready(function() {
    $("#formRetirarSaldo").submit(function(event){
    	if(validarLogin()===false){
    		event.preventDefault();
    	}
    });
});

function validarVistaRetirarSaldo(){
    return true;
}