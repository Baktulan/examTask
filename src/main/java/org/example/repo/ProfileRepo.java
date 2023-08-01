package org.example.repo;

import org.example.entity.Profile;

public interface ProfileRepo {
    String saveProfile(Long userId ,Profile profile);
    Profile findProfilrByUserId(Long userId);
    String deleteProfileByUserId(Long userId);



}
