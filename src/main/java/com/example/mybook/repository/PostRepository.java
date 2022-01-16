package com.example.mybook.repository;

import com.example.mybook.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
        Post findPostById(Long id);
}
