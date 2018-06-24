<%@ include file="../taglib.jsp" %>
<div id="areaConsultaSaldo">
	<form name="formConsultaSaldo" action="operConsultaSaldo">
		<table id="tablaSaldo" class="table table-stripped">
			<tr>
				<td><strong><spring:message code="etiqueta.fecha" /></strong></td>
				<td><fmt:formatDate pattern = "dd/MM/yyyy" value="${fecha}" /></td>
			</tr>
			<tr>
				<td><strong><spring:message code="etiqueta.cuenta" /></strong></td>
				<td>${cuenta}</td>
			</tr>
			<tr>
				<td><strong><spring:message code="etiqueta.tarjeta" /></strong></td>
				<td>${tarjeta}</td>
			</tr>
			<tr>
				<td><strong><spring:message code="etiqueta.saldo" /></strong></td>
				<td><fmt:formatNumber value ="${saldo}" pattern = "$###.##"/></td>
			</tr>
		</table>
		<spring:message code="etiqueta.btnRegresar" var="regresar"/>
		<spring:message code="etiqueta.btnEnviarComprobante" var="enviarComprobante"/>
		<input type="submit" name="btnRegresar" value="${regresar}" class="btn btn-default">
		<input type="submit" name="enviarComprobante" value="${enviarComprobante}" class="btn btn-primary" style="margin:10px" />
	</form>
</div>