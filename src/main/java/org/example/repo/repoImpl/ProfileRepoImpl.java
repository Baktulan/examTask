package org.example.repo.repoImpl;

import jakarta.persistence.EntityManager;
import org.example.config.HibernateDataBase;
import org.example.entity.Profile;
import org.example.entity.User;
import org.example.repo.ProfileRepo;

public class ProfileRepoImpl implements ProfileRepo {
    private final EntityManager entityManager= HibernateDataBase.getEntityManager();
    @Override
    public String saveProfile(Long userId, Profile profile) {
        entityManager.getTransaction().begin();
        User userId1 = entityManager.createQuery("select u from User  u where u.id=:userId", User.class).setParameter("userId", userId).getSingleResult();
        entityManager.persist(profile);
        userId1.setProfile(profile);
        entityManager.getTransaction().commit();
        entityManager.close();
        return profile+" successfully saved";
    }

    @Override
    public Profile findProfilrByUserId(Long userId) {
        entityManager.getTransaction().begin();
        Profile profile = entityManager.createQuery("select p from Profile p inner join User u on p.user.id=u.id where  u.id=:userId", Profile.class).setParameter("userId", userId).getSingleResult();
        entityManager.getTransaction().commit();
        entityManager.close();
        return profile;
    }

    @Override
    public String deleteProfileByUserId(Long userId) {
        entityManager.getTransaction().begin();
        Profile profile = entityManager.createQuery("select p from Profile p inner join User u on p.user.id=u.id where u.id=:userId", Profile.class).setParameter("userId", userId).getSingleResult();
        entityManager.remove(profile);
        entityManager.getTransaction().commit();
        entityManager.close();
        return "Successfully deleted";
    }
}
