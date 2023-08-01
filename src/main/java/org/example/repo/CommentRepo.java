package org.example.repo;

import org.example.entity.Comment;

import java.util.List;

public interface CommentRepo {

    String saveComment(Long postId,Long userId, Comment comment);
    List<Comment>findCommentByPostId(Long postId);
    String updateComment(Long id , String newText);
    String deleteComment(Comment comment);
}
