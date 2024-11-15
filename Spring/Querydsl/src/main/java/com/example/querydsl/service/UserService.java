package com.example.querydsl.service;

import com.example.querydsl.dsl.UserRepositoryCustom;
import com.example.querydsl.dto.UsersDto;
import com.example.querydsl.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {

    private final UserRepositoryCustom userRepositoryCustom;

    public List<UsersDto> findByUserIdAndName(String userId, String userName){

        return userRepositoryCustom.findByUserIdAndName(userId, userName);

    }
}
