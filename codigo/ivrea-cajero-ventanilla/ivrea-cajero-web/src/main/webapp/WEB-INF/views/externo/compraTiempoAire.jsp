<%@ include file="../taglib.jsp" %>
<div id="areaCompraTiempo">
	<form name="formCompraTiempo" action="operComprarTiempoAire">
		<div class="form-group">
			<label for="campoTelefono"><spring:message code="etiqueta.telefono"/></label>
			<input type="number" id="campoTelefono" name="campoTelefono" class="form-control"/>
		</div>
		<div class="form-group">
			<label for="campoProveedor"><spring:message code="etiqueta.proveedor"/></label>
			<select name="campoProveedor" id="campoProveedor" class="form-control">
				<c:forEach items="${proveedores}" var="proveedor">
					<option value="${proveedor}">${proveedor}</option>
				</c:forEach>
			</select>
		</div>
		<div class="form-group">
			<label for="campoCantidad"><spring:message code="etiqueta.cantidadDepositar"/></label>
			<input type="number" class="form-control" name="campoCantidad" id="campoCantidad" />
		</div>
		<spring:message code="etiqueta.btnRegresar" var="regresar"/>
		<spring:message code="etiqueta.btnAceptar" var="aceptar"/>
		<input type="submit" name="btnRegresar" value="${regresar}" class="btn btn-default">
		<input type="submit" name="aceptarCompraTiempo" value="${aceptar}" class="btn btn-primary" style="margin:10px" />
	</form>
</div>