package com.springboot.blog.springbootrestapiblog.repository;

import com.springboot.blog.springbootrestapiblog.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByPostId(Long postId);
}
