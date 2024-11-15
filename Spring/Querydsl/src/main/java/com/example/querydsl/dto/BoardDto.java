package com.example.querydsl.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class BoardDto {
    private Long id;

    private String title;

    private String content;


    @QueryProjection
    public BoardDto(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }
}
