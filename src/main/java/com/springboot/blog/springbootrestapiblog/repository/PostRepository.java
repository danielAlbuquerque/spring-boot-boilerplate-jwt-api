package com.springboot.blog.springbootrestapiblog.repository;

import com.springboot.blog.springbootrestapiblog.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {

}
