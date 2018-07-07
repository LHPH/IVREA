<%@ include file="taglib.jsp" %>
<div id="loginForm2">
	<form name="formLogin" id="formLogin" class="needs-validation" action="autenticar" method="POST"  novalidate>
		<div class="form-group">
			<label for="campoTarjeta"><spring:message code="etiqueta.tarjeta" /></label>
			<input type="text" class="form-control" id="campoTarjeta" name="campoTarjeta" maxlength="10" placeholder="Numero de tarjeta" required>
			<div class="invalid-feedback">
        		El valor ingresado no es correcto.
      		</div>
		</div>
		<div class="form-group">
			<label for="campoNip"><spring:message code="etiqueta.nip" /></label>
			<input type="password" class="form-control" id="campoNip" name="campoNip" maxlength="4" placeholder="NIP" required>
		</div>
		<!-- <sec:csrfInput /> -->
		<button type="submit" id="btnLoginEnviar" class="btn btn-primary"><spring:message code="etiqueta.btnIngresar" /></button>
	</form>
	<br />
	<c:if test="${not empty mensaje}">
		<div id="errorLogin" class="alert alert-warning" role="alert">
			<spring:message code="${mensaje}" htmlEscape="false" />
		</div>
	</c:if>
</div>