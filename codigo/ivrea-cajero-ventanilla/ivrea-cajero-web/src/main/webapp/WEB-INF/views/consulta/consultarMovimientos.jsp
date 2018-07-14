<%@ include file="../taglib.jsp" %>
<div id="areaConsultaMovimientos">
	<div id="content">
		<form name="formMovimientos" action="operConsultaMovimientos">
			<table id="tablaMovimientos" class="table table-stripped">
				<thead>
					<tr>
						<th><spring:message code="etiqueta.fechaHeader" /></th>
						<th><spring:message code="etiqueta.conceptoHeader" /></th>
						<th><spring:message code="etiqueta.cantidadHeader" /></th>
					</tr>
				</thead>
				<tbody>
					<c:choose>
						<c:when test="${tamanioPagina!=0}">
							<c:forEach items="${movimientos}" var="movimiento">
								<tr>
									<td>${movimiento.fecha}</td>
									<td>${movimiento.concepto}</td>
									<td>${movimiento.cantidad}</td>
								</tr>
							</c:forEach>
						</c:when>
						<c:otherwise>
							<tr><td colspan="3"><spring:message code="etiqueta.sinRegistros" /></td></tr>
						</c:otherwise>
					</c:choose>
				</tbody>
			</table>
			<div id="page-selection"></div>
			<spring:message code="etiqueta.btnRegresar" var="regresar"/>
			<input type="submit" name="btnRegresar" value="${regresar}" class="btn btn-default">
		</form>
	</div>
</div>
<script>
	$('#page-selection').bootpag({
		total: 10,
	    maxVisible:3,
	    activeClass: 'page-item active',
	    disabledClass: 'page-item disabled'
	}).on("page", function(event, /* page number here */ num){
		//$("#content").html("Insert content"); // some ajax content loading...
	});
	actualizarBarra();
</script>