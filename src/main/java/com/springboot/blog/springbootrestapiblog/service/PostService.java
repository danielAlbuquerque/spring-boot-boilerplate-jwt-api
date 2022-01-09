package com.springboot.blog.springbootrestapiblog.service;

import com.springboot.blog.springbootrestapiblog.payload.PostDto;
import com.springboot.blog.springbootrestapiblog.payload.PostResponse;

import java.util.List;

public interface PostService {
    PostDto createPost(PostDto postDto);
    PostResponse getAllPosts(int pageNo, int pageSize, String sortBy, String sortDir);
    PostDto getPostById(Long id);
    PostDto updatePost(PostDto postDto, Long id);
    void deletePostById(Long id);
}
