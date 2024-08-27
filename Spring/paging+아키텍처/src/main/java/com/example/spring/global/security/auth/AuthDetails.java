package com.example.spring.global.security.auth;

import com.example.spring.domain.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;


public record AuthDetails(User user) implements UserDetails {

    @Override
    public Collection<? extends GrantedAuthority> getAuthories() {
        return new ArrayList<>(Collections.singleton(new SimpleGrantedAuthority("ROLE"+user.getRole().toString())));
    }

    @Override
    public String getPassword(){
        return user.getPassword();
    }

    @Override
    public String getUsername(){
        return user.getAccountId();
    }

    @Override
    public boolean isAccountNonExpired(){
        return true;
    }

    @Override
    public boolean isAccountNonLocked(){
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired(){
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


}
