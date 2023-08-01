package org.example.repo.repoImpl;

import jakarta.persistence.EntityManager;
import org.example.config.HibernateDataBase;
import org.example.entity.Comment;
import org.example.entity.Post;
import org.example.entity.User;
import org.example.repo.CommentRepo;

import java.util.ArrayList;
import java.util.List;

public class CommentRepoImpl implements CommentRepo {
    private final EntityManager entityManager = HibernateDataBase.getEntityManager();
    @Override
    public String saveComment(Long postId, Long userId, Comment comment) {
        List<Comment> commentList= new ArrayList<>();
        entityManager.getTransaction().begin();
        User user = entityManager.createQuery("select u from User u where u.id=:userId", User.class).setParameter("userId", userId).getSingleResult();
        List<Post> posts = entityManager.createQuery("select p from Post p where p.id=:postId", Post.class).setParameter("postId", postId).getResultList();
        comment.setUser(user);
        comment.setPosts(posts);
        entityManager.getTransaction().commit();
        entityManager.close();
        return "Successfully saved";
    }

    @Override
    public List<Comment> findCommentByPostId(Long postId) {
        entityManager.getTransaction().begin();
        List<Comment> comments = entityManager.createQuery("select c from Comment  c inner join Post p where p.id=:postId", Comment.class).setParameter("postId", postId).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return comments;
    }

    @Override
    public String updateComment(Long id, String newText) {
        entityManager.getTransaction().begin();
        Comment comment = entityManager.createQuery("select c from Comment c where c.id=:id", Comment.class).setParameter("id", id).getSingleResult();
        comment.setText(newText);
        entityManager.getTransaction().commit();
        entityManager.close();
        return "Successfully updated";
    }

    @Override
    public String deleteComment(Comment comment) {
        entityManager.getTransaction().begin();
        Comment comment1 = entityManager.createQuery("select c from Comment c where c=:comment", Comment.class).setParameter("comment", comment).getSingleResult();
        entityManager.remove(comment1);
        entityManager.getTransaction().commit();
        entityManager.close();
        return "Successfully deleted";
    }
}
