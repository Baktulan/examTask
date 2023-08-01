package org.example.repo;

import org.example.entity.Profile;
import org.example.entity.User;

public interface UserRepo {
    String saveUser(User user);
    User findUserById(Long id);
    String deleteUser(Long id);
    String updateUserProfile(Long userId, Profile profile);



}
