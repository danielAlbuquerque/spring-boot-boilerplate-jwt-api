package com.springboot.blog.springbootrestapiblog.payload;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Data
public class PostDto {
    private Long id;

    @NotNull
    @Size(min = 2, message = "Title should have at least 2 characters")
    private String title;

    @NotNull
    @Size(min = 10, message = "Title should have at least 10 characters")
    private String description;

    @NotEmpty
    private String content;
    private Set<CommentDto> comments;
}
