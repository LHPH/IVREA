<%@ include file="../taglib.jsp" %>
<div id="areaDepositarSaldo">
	<form name="formDepositarSaldo" action="operDepositarSaldo" id="formDepositarSaldo" novalidate>

		<c:choose>
			<c:when test="${not empty error}">
				<c:set var = "clase"  value="form-control is-invalid"/>
			</c:when>
			<c:otherwise>
				<c:set var = "clase" value="form-control"/>
			</c:otherwise>
		</c:choose>

		<div class="form-group">
			<label for="campoCantidad"><spring:message code="etiqueta.cantidadDepositar" /></label>
			<input type="number" min="0" id="campoCantidad" name="campoCantidad" class="${clase}" />
			<div class="invalid-feedback">
        		<spring:message code="etiqueta.cantidad.incorrecto" htmlEscape="false" />
      		</div>
		</div>
		<div class="form-group">
			<label for="campoCuenta"><spring:message code="etiqueta.cuenta" /></label>
			<input type="number" min="0" id="campoCuenta" readonly="true" value="${cuenta}" name="campoCuenta" class="${clase}" />
			<div class="invalid-feedback">
        		<spring:message code="etiqueta.numeroCuenta.incorrecto" htmlEscape="false" />
      		</div>
		</div>
		<div class="form-group">
			<label for="campoSaldo"><spring:message code="etiqueta.saldo" /></label>
			<fmt:formatNumber type = "number" pattern = "###.##" value = "${saldo}" var="saldoText" />
			<input type="text" id="campoSaldo" readonly="true" value="${saldoText}" name="campoSaldo" class="${clase}" />
			<div class="invalid-feedback">
        		<spring:message code="etiqueta.generico.incorrecto" htmlEscape="false" />
      		</div>
		</div>
		<c:choose>
			<c:when test="${tipoOperacion==2}">
				<div class="form-group">
					<label for="campoCuentaTercera"><spring:message code="etiqueta.cuentaTercera" /></label>
					<input type="text" id="campoCuentaTercera" name="campoCuentaTercera" class="${clase}" />
					<div class="invalid-feedback">
						<spring:message code="etiqueta.numeroCuenta.incorrecto" htmlEscape="false" />
					</div>		
				</div>
			</c:when>
		</c:choose>
		<c:if test="${not empty error}">
			<div class="alert alert-danger" role="alert" style="width: 390px;height: 90px;font-size:14px">
				No se pudo realizar la operacion debido a un error en los datos.
				Verifique que sus datos esten correctos. En caso de que esten bien
				reporte al numero xxx-xxx-xx
			</div>
		</c:if>
		<br />
		<spring:message code="etiqueta.btnRegresar" var="regresar"/>
		<spring:message code="etiqueta.btnAceptar" var="aceptar"/>
		<input type="submit" name="btnRegresar" value="${regresar}" class="btn btn-default">
		<c:choose>
			<c:when test="${tipoOperacion==2}">
				<input type="submit" name="aceptarDepositoTransferencia" value="${aceptar}" class="btn btn-primary" style="margin:10px" onclick="return validarVistaDepositarSaldo('formDepositarSaldo');" />
			</c:when>
			<c:otherwise>
				<input type="submit" name="aceptarDeposito" value="${aceptar}" class="btn btn-primary" style="margin:10px" onclick="return validarVistaDepositarSaldo('formDepositarSaldo');" />
			</c:otherwise>
		</c:choose>
	</form>
</div>
<script src="${context}/resources/js/depositarSaldo.js" type="text/javascript"></script>