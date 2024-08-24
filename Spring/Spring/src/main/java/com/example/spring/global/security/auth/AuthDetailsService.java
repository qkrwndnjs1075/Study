package com.example.spring.global.security.auth;

import com.example.spring.domain.user.dao.UserRepository;
import com.example.spring.domain.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AuthDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByAccountId(String accountId){

        User user =userRepository.findByAccountId(accountId)
                .orElseThrow(()-> new UsernameNotFoundException("User Not Found"));

        return new AuthDetails(user);
    }


}
