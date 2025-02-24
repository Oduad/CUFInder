package oduad.fi.finder.service;

import oduad.fi.finder.entity.Profile;
import oduad.fi.finder.entity.User;
import oduad.fi.finder.repository.ProfileRepository;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public class ProfileServiceImp implements ProfileService{

    private final ProfileRepository profileRepository;

    public ProfileServiceImp(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @Override
    public Profile createProfile(Profile profile) {
        if(profileRepository.findByUserName(profile.getUsername()).isPresent())
        {
            throw new IllegalArgumentException(
                    "El nombre de perfil ya está en uso.");
        }
        return profileRepository.save(profile);
    }

    @Override
    public Profile updateProfile(Long id, Profile updateProfile) {
        updateProfile.setId(id);
        return profileRepository.save(updateProfile);
    }

    @Override
    public void removeProfile(String username) {
        profileRepository.deleteByName(username);
    }

    @Override
    public Profile getProfile(Long id) {
        Optional<Profile> profile = profileRepository.findById(id);
        if(profile.isPresent()){
            return profile.get();
        }else{
            return null;
        }
    }

    @Override
    public ResponseEntity<List<Profile>> getAllProfiles() {
        List<Profile>profiles = profileRepository.findAll();
        return ResponseEntity.ok(profiles);
    }
}
