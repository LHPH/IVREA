<%@ include file="../taglib.jsp" %>
<div id="areaDepositarSaldo">
	<form name="formDepositarSaldo" action="operDepositarSaldo" id="formDepositarSaldo">
		<div class="form-group">
			<label for="campoCantidad"><spring:message code="etiqueta.cantidadDepositar" /></label>
			<input type="number" min="0" id="campoCantidad" name="campoCantidad" class="form-control" />
		</div>
		<div class="form-group">
			<label for="campoCuenta"><spring:message code="etiqueta.cuenta" /></label>
			<input type="number" min="0" id="campoCuenta" readonly="true" value="${cuenta}" name="campoCuenta" class="form-control" />
		</div>
		<div class="form-group">
			<label for="campoSaldo"><spring:message code="etiqueta.saldo" /></label>
			<fmt:formatNumber type = "number" pattern = "###.##" value = "${saldo}" var="saldoText" />
			<input type="text" id="campoSaldo" readonly="true" value="${saldoText}" name="campoSaldo" class="form-control" />
		</div>
		<c:choose>
			<c:when test="${tipoOperacion==2}">
				<div class="form-group">
					<label for="campoCuentaTercera"><spring:message code="etiqueta.cuentaTercera" /></label>
			        <input type="text" id="campoCuentaTercera" name="campoCuentaTercera" class="form-control" />		
				</div>
			</c:when>
		</c:choose>
		<br />
		<spring:message code="etiqueta.btnRegresar" var="regresar"/>
		<spring:message code="etiqueta.btnAceptar" var="aceptar"/>
		<input type="submit" name="btnRegresar" value="${regresar}" class="btn btn-default">
		<c:choose>
			<c:when test="${tipoOperacion==2}">
				<input type="submit" name="aceptarDepositoTransferencia" value="${aceptar}" class="btn btn-primary" style="margin:10px" onclick="cambiarMetodoEnvio('formDepositarSaldo');" />
			</c:when>
			<c:otherwise>
				<input type="submit" name="aceptarDeposito" value="${aceptar}" class="btn btn-primary" style="margin:10px" onclick="cambiarMetodoEnvio('formDepositarSaldo');" />
			</c:otherwise>
		</c:choose>
	</form>
</div>