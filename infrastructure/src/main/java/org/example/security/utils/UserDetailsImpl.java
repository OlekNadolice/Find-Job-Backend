package org.example.security.utils;

import org.example.entities.user.CustomUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class UserDetailsImpl implements UserDetails {

    private final CustomUser customUser;


    public UserDetailsImpl(CustomUser customUser) {
        this.customUser = customUser;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
     return   customUser.getRoles().stream().map(e -> new SimpleGrantedAuthority(e.toString())).toList();

    }

    @Override
    public String getPassword() {
       return customUser.getPassword();
    }

    @Override
    public String getUsername() {
        return customUser.getEmailAddress();
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
