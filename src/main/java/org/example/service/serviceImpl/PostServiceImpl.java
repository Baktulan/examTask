package org.example.service.serviceImpl;

import org.example.entity.Post;
import org.example.repo.PostRepo;
import org.example.repo.repoImpl.PostRepoImpl;
import org.example.service.PostService;

import java.util.List;

public class PostServiceImpl implements PostService {
    PostRepo postRepo = new PostRepoImpl();
    @Override
    public String savePost(Long userId, Post post) {
        return postRepo.savePost(userId,post);
    }

    @Override
    public List<Post> getPostsByUserId(Long userId) {
        return postRepo.getPostsByUserId(userId);
    }

    @Override
    public Post searchPost(Long id) {
        return postRepo.searchPost(id);
    }

    @Override
    public String deletePostById(Long id) {
        return postRepo.deletePostById(id);
    }
}
