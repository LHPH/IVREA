package mx.gob.ivrea.api.security;

import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class CustomAuthenticationToken extends UsernamePasswordAuthenticationToken{

    private static final long serialVersionUID = 335490342304892L; 

    private String token;

    public CustomAuthenticationToken(Object principal,String credentials){
        super(principal,credentials);
    }

    public CustomAuthenticationToken(Object principal,String credentials,String token){
        super(principal,credentials);
        this.token=token;
    }

    public CustomAuthenticationToken(Object principal,String credentials, 
            Collection<? extends GrantedAuthority> authorities,String token){
        super(principal,credentials,authorities);
        this.token=token;
    }


    public void setToken(String token){
        this.token=token;
    }

    public String getToken(){
        return this.token;
    }

}