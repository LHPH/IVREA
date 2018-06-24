<%@ include file="taglib.jsp" %>
<div id="areaUsuario">
  <strong><spring:message code="etiqueta.usuario" />${nombreUsuario}</strong>
  <br />
  <a href="#"><spring:message code="etiqueta.cerrarSesion" /></a>
</div>
<br />
<div class="row" style="margin-top: 2%;margin-bottom: 2%;">
  <div class="col-sm-6 col-md-3">
    <div class="card" style="width: 12rem;">
      <img class="card-img-top" src="${context}/resources/img/descarga.png" alt="Consultar Saldo">
      <div class="card-body">
        <h5 class="card-title"><spring:message code="etiqueta.consultaSaldo" /></h5>
        <p class="card-text"><spring:message code="etiqueta.descConsultaSaldo" /></p>
        <a href="consultarSaldo" class="btn btn-primary"><spring:message code="etiqueta.btnConsultar" /></a>
      </div>
    </div>
  </div>
  <div class="col-sm-6 col-md-3">
    <div class="card" style="width: 12rem;">
      <img class="card-img-top" src="${context}/resources/img/descarga.png" alt="Retirar Saldo">
      <div class="card-body">
        <h5 class="card-title"><spring:message code="etiqueta.retirarSaldo" /></h5>
        <p class="card-text"><spring:message code="etiqueta.descRetirarSaldo" /></p>
        <a href="retirarSaldo" class="btn btn-primary"><spring:message code="etiqueta.btnRetirar" /></a>
      </div>
    </div>
  </div>
  <div class="col-sm-6 col-md-3">
    <div class="card" style="width: 12rem;">
      <img class="card-img-top" src="${context}/resources/img/descarga.png" alt="Depositar Saldo">
      <div class="card-body">
        <h5 class="card-title"><spring:message code="etiqueta.depositarSaldo" /></h5>
        <p class="card-text"><spring:message code="etiqueta.descDepositarSaldo" /></p>
        <a href="depositarSaldo" class="btn btn-primary"><spring:message code="etiqueta.btnDepositar" /></a>
      </div>
    </div>
  </div>
   <div class="col-sm-6 col-md-3">
    <div class="card" style="width: 12rem;">
      <img class="card-img-top" src="${context}/resources/img/descarga.png" alt="Transferencia">
      <div class="card-body">
        <h5 class="card-title"><spring:message code="etiqueta.transferencia" /></h5>
        <p class="card-text"><spring:message code="etiqueta.descTransferencia" /></p>
        <a href="transferencia" class="btn btn-primary"><spring:message code="etiqueta.btnTransferir" /></a>
      </div>
    </div>
  </div>
</div>
<div class="row" style="margin-top: 2%;margin-bottom: 2%;">
  <div class="col-sm-6 col-md-3">
    <div class="card" style="width: 12rem;">
      <img class="card-img-top" src="${context}/resources/img/descarga.png" alt="Consultar Movimientos">
      <div class="card-body">
        <h5 class="card-title"><spring:message code="etiqueta.movimientos" /></h5>
        <p class="card-text"><spring:message code="etiqueta.descMovimientos" /></p>
        <a href="consultarMovimientos" class="btn btn-primary"><spring:message code="etiqueta.btnConsultar" /></a>
      </div>
    </div>
  </div>
  <div class="col-sm-6 col-md-3">
    <div class="card" style="width: 12rem;">
      <img class="card-img-top" src="${context}/resources/img/descarga.png" alt="Pago de Servicios">
      <div class="card-body">
        <h5 class="card-title"><spring:message code="etiqueta.pagoServicios" /></h5>
        <p class="card-text"><spring:message code="etiqueta.descPagoServicios" /></p>
        <a href="pagarServicios" class="btn btn-primary"><spring:message code="etiqueta.btnPagar" /></a>
      </div>
    </div>
  </div>
  <div class="col-sm-6 col-md-3">
    <div class="card" style="width: 12rem;">
      <img class="card-img-top" src="${context}/resources/img/descarga.png" alt="Compra Tiempo Aire">
      <div class="card-body">
        <h5 class="card-title"><spring:message code="etiqueta.compraTiempoAire" /></h5>
        <p class="card-text"><spring:message code="etiqueta.descCompraTiempoAire" /></p>
        <a href="comprarTiempoAire" class="btn btn-primary"><spring:message code="etiqueta.btnComprar" /></a>
      </div>
    </div>
  </div>
</div>
<br />
<br />