package org.example.service;

import org.example.entity.Profile;

public interface ProfileService {
    String saveProfile(Long userId , Profile profile);
    Profile findProfilrByUserId(Long userId);
    String deleteProfileByUserId(Long userId);
}
