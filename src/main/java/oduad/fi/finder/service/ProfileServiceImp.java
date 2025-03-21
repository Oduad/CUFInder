package oduad.fi.finder.service;

import oduad.fi.finder.dto.PreferenceDTO;
import oduad.fi.finder.entity.Preference;
import oduad.fi.finder.entity.Profile;
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
                .orElseThrow(() -> new RuntimeException("Perfil no encontrado"));

        Preference preference = new Preference();
        preference.setProfile(profile);
        preference.setMinAge(preferenceDTO.getMinAge());
        preference.setMaxAge(preferenceDTO.getMaxAge());
        preference.setMaxDistance(preferenceDTO.getMaxDistance());
        preference.setMinHeight(preferenceDTO.getMinHeight());
        //preference.setMaxHeight(preferenceDTO.getMaxHeight());
        preference.setPreferredGender(preferenceDTO.getPreferredGender());
        preference.setProfilePicture(preferenceDTO.isProfilePicture());
        profile.setPreferences(List.of(preference));
        return profileRepository.save(profile);
        }
    }
