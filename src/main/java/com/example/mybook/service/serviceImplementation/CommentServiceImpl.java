package com.example.mybook.service.serviceImplementation;

import com.example.mybook.model.Comment;
import com.example.mybook.repository.CommentRepository;
import com.example.mybook.service.CommentServices;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentServices {

    final CommentRepository commentRepository;

    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public void addComment(Comment comment) {
        commentRepository.save(comment);
    }

    @Override
    public Comment getComment(Long id) {
        return commentRepository.findCommentById(id);
    }

    @Override
    public void deleteComment(Comment comment) {
        commentRepository.delete(comment);
    }

    @Override
    public List<Comment> getComments() {
        return commentRepository.findAll();
    }
}
