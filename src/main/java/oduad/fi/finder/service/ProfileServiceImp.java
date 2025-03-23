package oduad.fi.finder.service;

import oduad.fi.finder.dto.PreferenceDTO;
import oduad.fi.finder.entity.Preference;
import oduad.fi.finder.entity.Profile;
import oduad.fi.finder.entity.User;
import oduad.fi.finder.repository.ProfileRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
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
                    "This profile name is already in use.");
        }
        return profileRepository.save(profile);
    }

    @Override
    public Profile updateProfile(Long id, Profile updateProfile) {
        Profile existingProfile = profileRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Profile not found with ID: " + id));
            existingProfile.setBirthDate(updateProfile.getBirthDate());
            existingProfile.setHeight(updateProfile.getHeight());
            existingProfile.setGender(updateProfile.getGender());
            existingProfile.setNationallity(updateProfile.getNationallity());
            existingProfile.setSchool(updateProfile.getSchool());
            existingProfile.setCareer(updateProfile.getCareer());
            existingProfile.setProfilePictureUrl(updateProfile.getProfilePictureUrl());
            existingProfile.setBio(updateProfile.getBio());
            existingProfile.setPreferences(updateProfile.getPreferences());
        return profileRepository.save(existingProfile);
    }

    @Override
    public void removeProfile(Long id){
        profileRepository.deleteById(id);
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

    public Profile updatePreferences(Long profileId, PreferenceDTO preferenceDTO) {
        Profile profile = profileRepository.findById(profileId)
                .orElseThrow(() -> new RuntimeException("Profile not found"));

        Preference preference = new Preference();
        preference.setProfile(profile);
        preference.setMinAge(preferenceDTO.getMinAge());
        preference.setMaxAge(preferenceDTO.getMaxAge());
        preference.setMaxDistance(preferenceDTO.getMaxDistance());
        preference.setMinHeight(preferenceDTO.getMinHeight());
        preference.setMaxHeight(preferenceDTO.getMaxHeight());
        preference.setPreferredGender(preferenceDTO.getPreferredGender());
        preference.setProfilePicture(preferenceDTO.isProfilePicture());
        profile.setPreferences(List.of(preference));
        return profileRepository.save(profile);
        }
    }
