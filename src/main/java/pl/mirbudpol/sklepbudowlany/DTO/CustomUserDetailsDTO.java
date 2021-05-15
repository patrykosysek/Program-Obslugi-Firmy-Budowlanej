package pl.mirbudpol.sklepbudowlany.DTO;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import pl.mirbudpol.sklepbudowlany.entities.RegisteredUser;

import java.util.Collection;

public class CustomUserDetailsDTO implements UserDetails {

    RegisteredUser registeredUser;

    public CustomUserDetailsDTO(RegisteredUser registeredUser) {
        this.registeredUser = registeredUser;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return registeredUser.getHaslo();
    }

    @Override
    public String getUsername() {
        return registeredUser.getLogin();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
