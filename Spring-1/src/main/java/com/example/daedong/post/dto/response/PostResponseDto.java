package com.example.daedong.post.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public class PostResponseDto {

    private Long Id;
    private String title;
    private String content;
    private String author;

}
