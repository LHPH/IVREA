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
			<div class="${empty error ? 'invalid-feedback':''}">
        		<spring:message code="etiqueta.generico.incorrecto" htmlEscape="false" />
      		</div>
		</div>
		<div class="form-group">
			<label for="campoCantidad"><spring:message code="etiqueta.cantidadRetirar" /></label>
			<input type="number" min="0" name="campoCantidad" id="campoCantidad" class="${clase}" />
			<div class="${empty error ? 'invalid-feedback':''}">
        		<spring:message code="etiqueta.cantidad.incorrecto" htmlEscape="false" />
      		</div>
		</div>
		<c:if test="${not empty error}">
			<div class="alert alert-danger" role="alert" style="width: 300px;height: 200px;">
				No se pudo realizar la operacion debido a un error en los datos.
				Verifique que sus datos esten correctos. En caso de que esten bien
				reporte al numero xxx-xxx-xx
			</div>
		</c:if>
		<spring:message code="etiqueta.btnRegresar" var="regresar"/>
		<spring:message code="etiqueta.btnAceptar" var="aceptar"/>
		<input type="submit" name="btnRegresar" value="${regresar}" class="btn btn-default">
		<input type="submit" name="aceptarRetiro" value="${aceptar}" class="btn btn-primary" style="margin:10px" onclick="cambiarMetodoEnvio('formRetirarSaldo');"/>
	</form>
</div>