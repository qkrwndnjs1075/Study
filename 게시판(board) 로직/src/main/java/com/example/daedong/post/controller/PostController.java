package com.example.daedong.post.controller;

import com.example.daedong.post.dto.request.PostRequestDto;
import com.example.daedong.post.dto.response.PostResponseDto;
import com.example.daedong.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/post")
public class PostController {

    private final PostService postService;

    @PostMapping()
    public void createPost(@RequestBody PostRequestDto postRequestDto) {
        postService.createPost(postRequestDto);
    }

    @GetMapping("/{id}")
    public PostResponseDto getPost(@PathVariable Long id) {
        return postService.getPost(id);
    }

    @PatchMapping("/{id}")
    public void updatePost(@PathVariable Long id, @RequestBody PostRequestDto postRequestDto) {
        postService.updatePost(id, postRequestDto);

    }

    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable Long id) {
        postService.deletePost(id);

    }
}
