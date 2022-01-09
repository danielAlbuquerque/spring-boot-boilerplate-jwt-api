package com.springboot.blog.springbootrestapiblog.controller;

import com.springboot.blog.springbootrestapiblog.payload.CommentDto;
import com.springboot.blog.springbootrestapiblog.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/")
public class CommentsController {
    private CommentService commentService;

    public CommentsController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/posts/{postId}/comments")
    public ResponseEntity<CommentDto> createComment(
            @PathVariable(value = "postId") long postId,
            @Valid @RequestBody CommentDto commentDto
    ) {
        return new ResponseEntity<>(commentService.createComment(postId, commentDto), HttpStatus.CREATED);
    }

    @GetMapping("/posts/{postId}/comments")
    public List<CommentDto> getCommentsByPostId(@PathVariable(name = "postId") Long postId) {
        return commentService.getCommentsByPostId(postId);
    }

    @GetMapping("/posts/{postId}/comments/{commentId}")
    public ResponseEntity<CommentDto> getCommentById(
            @PathVariable(name = "postId") Long postId, @PathVariable(name = "commentId") Long commentId
    ) {
        CommentDto comment = commentService.getCommentById(postId, commentId);
        return new ResponseEntity<>(comment, HttpStatus.OK);
    }

    @PutMapping("/posts/{postId}/comments/{commentId}")
    public ResponseEntity<CommentDto> updateCommentById(
            @PathVariable(name = "postId") Long postId,
            @PathVariable(name = "commentId") Long commentId,
            @Valid @RequestBody CommentDto commentDto
    ) {
        CommentDto comment = commentService.updateComment(postId, commentId, commentDto);
        return new ResponseEntity<>(comment, HttpStatus.OK);
    }

    @DeleteMapping("/posts/{postId}/comments/{commentId}")
    public ResponseEntity<String> deleteComment(
            @PathVariable(name = "postId") Long postId, @PathVariable(name = "commentId") Long commentId
    ) {
        commentService.deleteComment(postId, commentId);
        return new ResponseEntity<>("Deleted sucessfully", HttpStatus.OK);
    }
}
