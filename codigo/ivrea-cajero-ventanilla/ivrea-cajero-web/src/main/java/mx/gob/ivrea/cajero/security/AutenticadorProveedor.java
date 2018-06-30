package mx.gob.ivrea.cajero.security;

import java.util.List;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import mx.gob.ivrea.logger.TipoLogger;

public class AutenticadorProveedor implements AuthenticationProvider{

    protected Logger logger = LoggerFactory.getLogger(TipoLogger.VISTA.toString());

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String numeroTarjeta = authentication.getName().trim();
        String nip = authentication.getCredentials().toString().trim();
        logger.info("Autenticando al usuario");
        List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        Authentication auth = new
                UsernamePasswordAuthenticationToken(numeroTarjeta,nip, grantedAuthorities);
        logger.info("Se ha autenticado al usuario");
        return auth;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
	}
}