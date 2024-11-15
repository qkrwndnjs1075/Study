package com.example.querydsl.dsl;

import com.example.querydsl.dto.UsersDto;import com.example.querydsl.dto.QUsersDto;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static org.springframework.util.StringUtils.hasText;

@Repository
@RequiredArgsConstructor
public class UserRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    public List<QUsersDto> findByUserIdAndName(String userId, String userName) {
        return queryFactory
                .select(new QUsersDto(
                        users.userNo,
                        users.userId,
                        users.userName
                ))
                .from(user)
                .innerJoin(board).on(users.userNo.eq(board.user.userNo))
                .where(
                        usernameId(userId),
                        usernameEq(userName)
                )
                .fetch();
    }

    private BooleanExpression usernameId(String userId) {
        return hasText(userId) ? users.userId.eq(userId) : null;
    }

    private BooleanExpression usernameEq(String userName) {
        return hasText(userName) ? users.userName.eq(userName) : null;
    }
}
