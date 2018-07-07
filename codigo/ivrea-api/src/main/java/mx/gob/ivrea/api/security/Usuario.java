package mx.gob.ivrea.api.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class Usuario implements UserDetails{

    private static final long serialVersionUID = 335490092304892L;

    private String username;
    private String password;
    private String nombre;
    private Collection<? extends GrantedAuthority> authorities;
    private boolean enabled;
    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private boolean credentialsNonExpired;

    public String getNombre(){
        return this.nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public void setAuthorities(Collection<? extends GrantedAuthority> auths){
        this.authorities = auths;
    }

	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.authorities;
    }
    
    public void setPassword(String pass){
        this.password = pass;
    }

	public String getPassword() {
		return this.password;
    }
    
    public void setUsername(String user){
        this.username = user;
    }

	public String getUsername() {
		return this.username;
    }
    
    public void setAccountNonExpired(boolean val){
        this.accountNonExpired = val;
    }

	public boolean isAccountNonExpired() {
		return this.accountNonExpired;
    }
    
    public void setAccountNonLocked(boolean val){
        this.accountNonLocked = val;
    }

	public boolean isAccountNonLocked() {
		return this.accountNonLocked;
    }
    
    public void setCredentialsNonExpired(boolean val){
        this.credentialsNonExpired=val;
    }

	public boolean isCredentialsNonExpired() {
		return this.credentialsNonExpired;
    }
    
    public void setEnabled(boolean val){
        this.enabled = val;
    }

	public boolean isEnabled() {
		return this.enabled;
	}

}