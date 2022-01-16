package com.example.mybook.service;

import com.example.mybook.model.Post;

import java.util.List;

public interface PostServices {

    void addPost(Post post);

    void deletePost(Post post);

    Post getPostById(Long id);

    List<Post> getPosts();
}
