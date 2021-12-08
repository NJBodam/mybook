package com.example.week7task.repository;

import com.example.week7task.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
        Post findPostById(Long id);
}
