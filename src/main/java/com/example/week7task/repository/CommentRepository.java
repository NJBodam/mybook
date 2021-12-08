package com.example.week7task.repository;

import com.example.week7task.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    Comment findCommentById(Long id);
}
