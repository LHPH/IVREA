package mx.gob.ivrea.cajero.security;

import java.util.List;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import mx.gob.ivrea.api.model.Cliente;
import mx.gob.ivrea.api.model.Modelo;
import mx.gob.ivrea.cajero.interfaces.ClienteRemote;

import mx.gob.ivrea.logger.TipoLogger;

@Component
public class AutenticadorProveedor implements AuthenticationProvider{

        protected Logger logger = LoggerFactory.getLogger(TipoLogger.VISTA.toString());

        @Autowired
        ClienteRemote clienteBusiness;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {

                String numeroTarjeta = authentication.getName().trim();
                String nip = authentication.getCredentials().toString().trim();
                logger.info("Autenticando al usuario");

                Modelo modelo = new Modelo();
                modelo.setCampo1(numeroTarjeta);
                modelo.setCampo2(nip);
                Cliente cliente = clienteBusiness.obtenerCliente(modelo);
                if (cliente != null) {
                        this.logger.info("Existe el cliente");
                        List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
                        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_USER"));

                        modelo.setCampo1(cliente.getNombre());
                        modelo.setCampo2(numeroTarjeta);
                        Authentication auth = new
                                UsernamePasswordAuthenticationToken(modelo,nip, grantedAuthorities);
                        logger.info("Se ha autenticado al usuario");
                        return auth;

                } else {
                        this.logger.info("No existe el cliente");
                        return null;
                }
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
	}
}