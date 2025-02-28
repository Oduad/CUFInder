package oduad.fi.finder.controller;

import oduad.fi.finder.dto.PreferenceDTO;
import oduad.fi.finder.entity.Profile;
import oduad.fi.finder.entity.User;
import oduad.fi.finder.repository.ProfileRepository;
import oduad.fi.finder.service.ProfileService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class ProfileControllerImp implements ProfileController{

    private final ProfileRepository profilerepository;
    private final ProfileService profileService;

    public ProfileControllerImp(ProfileRepository profilerepository, ProfileService profileService){
        this.profilerepository = profilerepository;
        this.profileService = profileService;
    }

    @Override
    @PostMapping("/profile")
    public ResponseEntity<?> createProfile(@RequestBody Profile profile) {
        try {
            Profile createdProfile = profileService.createProfile(profile);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdProfile);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }

    @Override
    @PutMapping("/profile/{id}")
    public ResponseEntity<Profile> updateProfile(@PathVariable Long id,
                                 @RequestBody Profile updatedProfile) {
        updatedProfile.setId(id);
        profileService.updateProfile(id, updatedProfile);
        return ResponseEntity.ok(updatedProfile);
    }

    @Override
    @DeleteMapping("/user/{id}")
    public void removeProfile(@PathVariable Long id) {
         profileService.removeProfile(id);
    }

    @Override
    @GetMapping("/profile/{id}")
    public Profile getProfile(@PathVariable Long id) {
        return profileService.getProfile(id);
    }

    @Override
    @GetMapping("/user")
    public ResponseEntity<List<Profile>> getAllProfiles() {
            ResponseEntity<List<Profile>>profiles = profileService.getAllProfiles();
            return profiles;
    }

    @Override
    public Profile updatePreferences(Long profileId,
                                     PreferenceDTO preferenceDTO) {
        return null;
    }
}
