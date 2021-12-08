package com.example.week7task.service;

import com.example.week7task.model.Post;

import java.util.List;

public interface PostServices {

    void addPost(Post post);

    void deletePost(Post post);

    Post getPostById(Long id);

    List<Post> getPosts();
}
