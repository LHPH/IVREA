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
			<div id="msgConsultaMov"></div>
			<div id="page-selection"></div>
			<spring:message code="etiqueta.btnRegresar" var="regresar"/>
			<input type="submit" name="btnRegresar" value="${regresar}" class="btn btn-default">
		</form>
	</div>
</div>
<script>
	$(document ).ready(function() {
   
    });

	function loadPaginationBar(totalPag){

		console.log('Total paginas ',totalPag);
		var maxVisible=3;
		if(totalPag<maxVisible){
			maxVisible = totalPag;
		}

		$('#page-selection').bootpag({
			total: totalPag,
			maxVisible: maxVisible,
			activeClass: 'page-item active',
			disabledClass: 'page-item disabled'
		}).on("page", function(event, /* page number here */ num){
			$.post("movimiento",{pag:num})
			.done(function(response){
				//$('#tablaMovimientos').find("tr:gt(0)").remove();
				$('#tablaMovimientos > tbody').empty();
				$('#tablaMovimientos > tbody').append(response);
				
			})
			.fail(function(response){
				console.log(response);
				$('#msgConsultaMov').append('<div class="alert alert-danger" role="alert" style="width: 390px;height: 90px;font-size:14px">Ocurrio un problema al cargar registros</div>');
			});
		});
	}

	loadPaginationBar("${totalPaginas}");
	actualizarBarra();
</script>