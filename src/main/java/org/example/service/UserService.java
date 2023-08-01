package org.example.service;

import org.example.entity.Profile;
import org.example.entity.User;

public interface UserService {

    String saveUser(User user);
    User findUserById(Long id);
    String deleteUser(Long id);
    String updateUserProfile(Long userId, Profile profile);
}
