package org.example.service;

import org.example.entity.Post;

import java.util.List;

public interface PostService {
    String savePost(Long userId, Post post);
    List<Post> getPostsByUserId(Long userId);
    Post searchPost(Long id);
    String deletePostById(Long id);
}
