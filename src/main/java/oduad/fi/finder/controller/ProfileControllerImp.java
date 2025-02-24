package oduad.fi.finder.controller;

import oduad.fi.finder.dto.PreferenceDTO;
import oduad.fi.finder.entity.Profile;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class ProfileControllerImp implements ProfileController{
    @Override
    public Profile createProfile(Profile profile) {
        return null;
    }

    @Override
    public Profile updateProfile(Long id, Profile profile) {
        return null;
    }

    @Override
    public void removeProfile(String username) {

    }

    @Override
    public Profile getProfile(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<List<Profile>> getAllProfiles() {
        return null;
    }

    @Override
    public Profile updatePreferences(Long profileId, PreferenceDTO preferenceDTO) {
        return null;
    }
}
