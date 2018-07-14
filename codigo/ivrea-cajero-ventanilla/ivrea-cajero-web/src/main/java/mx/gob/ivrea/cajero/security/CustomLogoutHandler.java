package mx.gob.ivrea.cajero.security;

import java.io.IOException;
 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import mx.gob.ivrea.logger.TipoLogger;

@Component
public class CustomLogoutHandler implements LogoutSuccessHandler{

    protected Logger logger = LoggerFactory.getLogger(TipoLogger.VISTA.toString());

    @Override
	public void onLogoutSuccess(HttpServletRequest request,
			HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
                logger.info("Cerrando session del usuario");
                response.sendRedirect("/ivrea-cajero/login");
    }

}