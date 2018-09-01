<%@ include file="../taglib.jsp" %>
<div id="areaRetirarSaldo">
	<form name="formRetirarSaldo" id="formRetirarSaldo" action="operRetirarSaldo" novalidate>
		<c:choose>
			<c:when test="${not empty error}">
				<c:set var = "clase"  value="form-control is-invalid"/>
			</c:when>
			<c:otherwise>
				<c:set var = "clase" value="form-control"/>
			</c:otherwise>
		</c:choose>

		<div class="form-group">
			<label for="campoSaldo"><spring:message code="etiqueta.saldo" /></label>
			<fmt:formatNumber type = "number" pattern = "###.##" value = "${saldo}" var="saldoText" />
			<input type="text" name="campoSaldo" id="campoSaldo" readonly="true" value="${saldoText}" class="${clase}" />
			<div class="invalid-feedback">
        		<spring:message code="etiqueta.generico.incorrecto" htmlEscape="false" />
      		</div>
		</div>
		<div class="form-group">
			<label for="campoCantidad"><spring:message code="etiqueta.cantidadRetirar" /></label>
			<input type="number" min="0" name="campoCantidad" id="campoCantidad" class="${clase}" />
			<div class="invalid-feedback">
        		<spring:message code="etiqueta.cantidad.incorrecto" htmlEscape="false" />
      		</div>
		</div>
		<c:if test="${not empty error}">
			<div class="alert alert-danger" role="alert" style="width: 390px;height: 90px;font-size:14px">
				<spring:message code="msg.vista.datos.error" htmlEscape="false" />
			</div>
		</c:if>
		<spring:message code="etiqueta.btnRegresar" var="regresar"/>
		<spring:message code="etiqueta.btnAceptar" var="aceptar"/>
		<input type="submit" name="btnRegresar" value="${regresar}" class="btn btn-default" />
		<input type="submit" name="aceptarRetiro" value="${aceptar}" class="btn btn-primary" style="margin:10px" onclick="return validarVistaRetirarSaldo('formRetirarSaldo');"/>
	</form>
</div>
<script src="${context}/resources/js/retirarSaldo.js" type="text/javascript"></script>