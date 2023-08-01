package org.example.repo.repoImpl;

import jakarta.persistence.EntityManager;
import org.example.config.HibernateDataBase;
import org.example.entity.Post;
import org.example.entity.User;
import org.example.repo.PostRepo;

import java.util.ArrayList;
import java.util.List;

public class PostRepoImpl implements PostRepo {
    private final EntityManager entityManager= HibernateDataBase.getEntityManager();
    @Override
    public String savePost(Long userId, Post post) {
        entityManager.getTransaction().begin();
        User userId1 = entityManager.createQuery("select u from User u  where u.id=:userId", User.class).setParameter("userId", userId).getSingleResult();
        post.setUser(userId1);
        entityManager.persist(post);
        entityManager.getTransaction().commit();
        entityManager.close();
        return "Successfully saved";
    }

    @Override
    public List<Post> getPostsByUserId(Long userId) {
        entityManager.getTransaction().begin();
        List<Post> posts = entityManager.createQuery("select p from Post p inner join User u on p.user.id=u.id where u.id=:userId", Post.class).setParameter("userId", userId).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return posts;
    }

    @Override
    public Post searchPost(Long id ) {
        entityManager.getTransaction().begin();
        Post post = entityManager.createQuery("select p from Post p where p.id=:id", Post.class).setParameter("id", id).getSingleResult();
        entityManager.getTransaction().commit();
        entityManager.close();
        return post;
    }

    @Override
    public String deletePostById(Long id) {
        entityManager.getTransaction().begin();
        Post post = entityManager.createQuery("select p from Post p where p.id=:id", Post.class).setParameter("id", id).getSingleResult();
        entityManager.remove(post);
        entityManager.getTransaction().commit();
        entityManager.close();
        return "Successfully deleted";
    }
}
