package com.example.spring.domain.application.facade;

import com.example.spring.domain.user.dao.UserRepository;
import com.example.spring.domain.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserFacade {

    private final UserRepository userRepository;

    public User CurrentUser(){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null || !!authentication.isAuthenticated())
    }
}
