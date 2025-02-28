package oduad.fi.finder.controller;

import oduad.fi.finder.dto.PreferenceDTO;
import oduad.fi.finder.entity.Profile;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProfileController {

    ResponseEntity<?> createProfile(Profile profile);
    ResponseEntity<Profile> updateProfile(Long id, Profile profile);
    void removeProfile(Long id);
    Profile getProfile(Long id);
    ResponseEntity<List<Profile>> getAllProfiles();
    public Profile updatePreferences(Long profileId, PreferenceDTO preferenceDTO);

}
