package mx.gob.ivrea.cajero.security;

import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import mx.gob.ivrea.api.security.CustomAuthenticationToken;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

public class CustomAuthenticationFilter extends UsernamePasswordAuthenticationFilter{


    @Override
    public Authentication attemptAuthentication(HttpServletRequest req,HttpServletResponse resp) throws AuthenticationException{

        String numeroTarjeta = super.obtainUsername(req);
        String nip = super.obtainPassword(req);

        CustomAuthenticationToken token = new CustomAuthenticationToken(numeroTarjeta,nip);
        super.setDetails(req, token);

        return this.getAuthenticationManager().authenticate(token);
    }

}