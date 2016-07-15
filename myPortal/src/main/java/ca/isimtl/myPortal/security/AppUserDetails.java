package ca.isimtl.myPortal.security;

import java.util.Collection;
import java.util.HashSet;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author Amine
 */
public class AppUserDetails implements UserDetails {

    private Collection<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
    private final String password;
    private final String username;
    private final boolean enabled;

    public AppUserDetails(String username, String password, boolean enabled, Collection<GrantedAuthority> authorities) {
        this.password = password;
        this.username = username;
        this.enabled = enabled;
        this.authorities = authorities;
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    public String getPassword() {
        return this.password;
    }

    public String getUsername() {
        return this.username;
    }

    public boolean isAccountNonExpired() {
        return true;
    }

    public boolean isAccountNonLocked() {
        return true;
    }

    public boolean isCredentialsNonExpired() {
        return true;
    }

    public boolean isEnabled() {
        return this.enabled;
    }

}
