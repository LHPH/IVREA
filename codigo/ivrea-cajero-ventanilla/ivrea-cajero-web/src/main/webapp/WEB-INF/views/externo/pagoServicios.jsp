<%@ include file="../taglib.jsp" %>
<div id="areaPagoServicios">
	<form name="formPagoServicios" action="operPagarServicios">
		<div class="form-group">
			<label for="campoCantidad"><spring:message code="etiqueta.cantidadDepositar"/></label>
			<input type="number" id="campoCantidad" name="campoCantidad" class="form-control"/>
		</div>
		<div class="form-group">
			<label for="campoConcepto"><spring:message code="etiqueta.concepto"/></label>
			<select name="campoConcepto" id="campoConcepto" class="form-control">
				<c:forEach items="${servicios}" var="servicio">
					<option value="${servicio}">${servicio}</option>
				</c:forEach>
			</select>
		</div>
		<div class="form-group">
			<label for="campoReferencia"><spring:message code="etiqueta.referencia"/></label>
			<input type="text" class="form-control" name="campoReferencia" id="campoReferencia" />
		</div>
		<spring:message code="etiqueta.btnRegresar" var="regresar"/>
		<spring:message code="etiqueta.btnAceptar" var="aceptar"/>
		<input type="submit" name="btnRegresar" value="${regresar}" class="btn btn-default">
		<input type="submit" name="aceptarPagoServicio" value="${aceptar}" class="btn btn-primary" style="margin:10px" />
	</form>
</div>