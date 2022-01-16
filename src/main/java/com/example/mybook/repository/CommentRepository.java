package com.example.mybook.repository;

import com.example.mybook.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    Comment findCommentById(Long id);

}
