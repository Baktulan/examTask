package org.example.service.serviceImpl;

import org.example.entity.Comment;
import org.example.repo.CommentRepo;
import org.example.repo.repoImpl.CommentRepoImpl;
import org.example.service.CommentService;

import java.util.List;

public class CommentServiceImpl implements CommentService {
    CommentRepo commentRepo = new CommentRepoImpl();
    @Override
    public String saveComment(Long postId, Long userId, Comment comment) {
        return commentRepo.saveComment(postId, userId, comment);
    }

    @Override
    public List<Comment>findCommentByPostId(Long postId) {
        return commentRepo.findCommentByPostId(postId);
    }

    @Override
    public String updateComment(Long id, String newText) {
        return commentRepo.updateComment(id,newText);
    }

    @Override
    public String deleteComment(Comment comment) {
        return commentRepo.deleteComment(comment);
    }
}
