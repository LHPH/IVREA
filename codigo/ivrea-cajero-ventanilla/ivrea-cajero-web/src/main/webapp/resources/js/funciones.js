function validarFormRetiro(){
    var saldo=$("#campoSaldo").val();
    var retiro=$("#campoCantidad").val();
    if(retiro-saldo<0){
        return false;
    }
    return true;
}

function actualizarBarra(){
        $(".pagination li").each(function(num){
            $(this).children().addClass("page-link");
        });
    }

function cambiarMetodoEnvio(form){
    $("#"+form).attr("method", "post");
}

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