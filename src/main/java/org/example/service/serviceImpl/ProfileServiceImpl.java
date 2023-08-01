package org.example.service.serviceImpl;

import org.example.entity.Profile;
import org.example.repo.ProfileRepo;
import org.example.repo.repoImpl.ProfileRepoImpl;
import org.example.service.ProfileService;

public class ProfileServiceImpl implements ProfileService {
    ProfileRepo profileRepo= new ProfileRepoImpl();
    @Override
    public String saveProfile(Long userId, Profile profile) {
        return profileRepo.saveProfile(userId,profile);
    }

    @Override
    public Profile findProfilrByUserId(Long userId) {
        return profileRepo.findProfilrByUserId(userId);
    }

    @Override
    public String deleteProfileByUserId(Long userId) {
        return profileRepo.deleteProfileByUserId(userId);
    }
}
