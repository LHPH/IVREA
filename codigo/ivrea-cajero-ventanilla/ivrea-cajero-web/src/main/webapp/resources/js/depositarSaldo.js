$(document ).ready(function() {
    $("#formDepositarSaldo").submit(function(event){
    	if(validarLogin()===false){
    		event.preventDefault();
    	}
    });
});

function validarVistaDepositarSaldo(){
    
}