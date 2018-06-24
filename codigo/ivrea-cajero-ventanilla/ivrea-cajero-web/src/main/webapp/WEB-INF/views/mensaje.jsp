<%@ include file="taglib.jsp" %>
<div id="areaMensaje">
	<form name="formMensaje" id="mensajeForm" action="${context}/${accion}">
		<div class="alert alert-${tipoMensaje}" role="alert">
			<c:choose>
				<c:when test="${not empty args}">
					<spring:message code="${mensaje}" arguments="${args}" htmlEscape="false" />
				</c:when>
				<c:otherwise>
					<spring:message code="${mensaje}" htmlEscape="false" />
				</c:otherwise>
			</c:choose>
		</div>
		<input type="submit" value="${nombreBoton}" class="btn btn-${tipoMensaje}" />
		<c:if test="${hayBotonImp==true}">
			<spring:message code="etiqueta.btnImprimirComprobante" var="imprimir"/>
			<input type="submit" name="btnImprimir" value="${imprimir}" class="btn btn-info" />
		</c:if>
	</form>
</div>