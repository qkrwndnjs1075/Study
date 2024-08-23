package com.example.daedong.post.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PostRequestDto {

    private String title;
    private String content;
    private String author;
}
