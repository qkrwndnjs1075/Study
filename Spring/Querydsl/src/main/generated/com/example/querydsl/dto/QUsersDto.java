package com.example.querydsl.dto;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.example.querydsl.dto.QUsersDto is a Querydsl Projection type for UsersDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QUsersDto extends ConstructorExpression<UsersDto> {

    private static final long serialVersionUID = -613657042L;

    public QUsersDto(com.querydsl.core.types.Expression<Long> userNo, com.querydsl.core.types.Expression<String> userId, com.querydsl.core.types.Expression<String> userName) {
        super(UsersDto.class, new Class<?>[]{long.class, String.class, String.class}, userNo, userId, userName);
    }

}

