package com.example.mybook.service.serviceImplementation;

import com.example.mybook.model.Comment;
import com.example.mybook.model.Post;
import com.example.mybook.repository.PostRepository;
import com.example.mybook.service.PostServices;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.Collections;
import java.util.List;

@Service
public class PostServiceImpl implements PostServices {
    final PostRepository postRepository;
    final CommentServiceImpl commentService;


    public PostServiceImpl(PostRepository postRepository, CommentServiceImpl commentService) {
        this.postRepository = postRepository;
        this.commentService = commentService;
    }


    @Override
    public void addPost(Post post) {
        postRepository.save(post);
    }

    @Override
    public void deletePost(Post post) {
        postRepository.delete(post);
    }

    @Override
    public Post getPostById(Long id) {
        return postRepository.findPostById(id);
    }

    @Override
    public List<Post> getPosts() {
        return postRepository.findAll();
    }

    public void viewDashboard(Model model){
        Post post = new Post();
        Comment comment = new Comment();
        List<Post> posts = this.getPosts();
        List<Comment> comments = commentService.getComments();
        Collections.reverse(posts);
        /* add posts to the model */
        model.addAttribute("posts", posts);
        model.addAttribute("post", post);
        model.addAttribute("comments", comments);
        model.addAttribute("comment", comment);
    }


}
