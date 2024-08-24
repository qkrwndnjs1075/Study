package com.example.spring.global.security.auth;

import com.example.spring.domain.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;


public record AuthDetails(User user) implements UserDetails {

    @Override


}
