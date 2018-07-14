package mx.gob.ivrea.cajero.security;

import java.io.IOException;
 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import mx.gob.ivrea.api.model.Modelo;
import mx.gob.ivrea.api.security.CustomAuthenticationToken;
import mx.gob.ivrea.api.constants.ParametrosConstants;
import mx.gob.ivrea.logger.TipoLogger;



@Component
public class AutenticadorSuccessHandler implements AuthenticationSuccessHandler{

    protected Logger logger = LoggerFactory.getLogger(TipoLogger.VISTA.toString());

    @Override
	public void onAuthenticationSuccess(HttpServletRequest request,
			HttpServletResponse response, Authentication auth)
			throws IOException, ServletException {
                logger.info("La autenticacion fue un exito, redirigiendo");
                logger.info("Se redirige a menu");
                response.sendRedirect(ParametrosConstants.VISTA_MENU+"/");
    }
}