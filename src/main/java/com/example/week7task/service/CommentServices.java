package com.example.week7task.service;

import com.example.week7task.model.Comment;

import java.util.List;

public interface CommentServices {
    void addComment(Comment comment);
    Comment getComment(Long id);
    void deleteComment(Comment comment);
    List<Comment> getComments();
}
