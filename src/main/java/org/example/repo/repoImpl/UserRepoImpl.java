package org.example.repo.repoImpl;

import jakarta.persistence.EntityManager;
import org.example.config.HibernateDataBase;
import org.example.entity.Profile;
import org.example.entity.User;
import org.example.repo.UserRepo;

public class UserRepoImpl implements UserRepo {
    private final EntityManager entityManager= HibernateDataBase.getEntityManager();
    @Override
    public String saveUser(User user) {
        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();
        entityManager.close();
        return  user+" successfully saved";
    }

    @Override
    public User findUserById(Long id) {
        entityManager.getTransaction().begin();
        User user = entityManager.find(User.class, id);
        entityManager.getTransaction().commit();
        entityManager.close();
        return user;
    }

    @Override
    public String deleteUser(Long id) {
        entityManager.getTransaction().begin();
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
        entityManager.getTransaction().commit();
        entityManager.close();
        return "Successfully deleted";
    }

    @Override
    public String updateUserProfile(Long userId, Profile profile) {
        entityManager.getTransaction().begin();
        User userID = entityManager.createQuery("select u from User u where u.id=:userId", User.class).setParameter("userId", userId).getSingleResult();
        entityManager.persist(profile);
        userID.setProfile(profile);
        entityManager.getTransaction().commit();
        entityManager.close();
        return "Successfully updated";
    }
}
