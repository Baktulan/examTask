package org.example.service.serviceImpl;

import org.example.entity.Profile;
import org.example.entity.User;
import org.example.repo.UserRepo;
import org.example.repo.repoImpl.UserRepoImpl;
import org.example.service.UserService;

public class UserServiceImpl implements UserService {
    UserRepo userRepo = new UserRepoImpl();
    @Override
    public String saveUser(User user) {
        return userRepo.saveUser(user);
    }

    @Override
    public User findUserById(Long id) {
        return userRepo.findUserById(id);
    }

    @Override
    public String deleteUser(Long id) {
        return userRepo.deleteUser(id);
    }

    @Override
    public String updateUserProfile(Long userId, Profile profile) {
        return userRepo.updateUserProfile(userId,profile);
    }
}
