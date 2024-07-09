package com.example.daedong.post.service;


import com.example.daedong.post.dto.request.PostRequestDto;
import com.example.daedong.post.dto.response.PostResponseDto;
import com.example.daedong.post.entity.Post;
import com.example.daedong.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
    public class PostService {

    private final PostRepository postRepository;

    public void createPost(PostRequestDto postRequestDto) {
        postRepository.save(
                Post.builder()
                        .title(postRequestDto.getTitle())
                        .content(postRequestDto.getContent())
                        .author(postRequestDto.getAuthor())
                        .build());
    }



        public PostResponseDto getPost(Long id) {
            Post post = postRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("not found"));


            return new PostResponseDto(post.getId(), post.getTitle(), post.getContent(), post.getAuthor());

        }

        @Transactional
        public void updatePost(Long id, PostRequestDto postRequestDto) {
            Post post = postRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("not found"));

            post.update(postRequestDto);
        }


        public void deletePost(Long id) {
            if (!postRepository.existsById(id)) {
                throw new RuntimeException("not found");
            }
            postRepository.deleteById(id);
        }
    }


