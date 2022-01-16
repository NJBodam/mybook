package com.example.mybook.service;

import com.example.mybook.model.Comment;

import java.util.List;

public interface CommentServices {
    void addComment(Comment comment);
    Comment getComment(Long id);
    void deleteComment(Comment comment);
    List<Comment> getComments();
}
