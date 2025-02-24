package oduad.fi.finder.service;

import oduad.fi.finder.entity.Profile;
import oduad.fi.finder.entity.User;
import org.springframework.http.ResponseEntity;
import java.util.List;

public interface ProfileService {

    Profile createProfile(Profile profile);
    Profile updateProfile(Long id, Profile profile);
    void removeProfile(String username);
    Profile getProfile(Long id);
    ResponseEntity<List<Profile>> getAllProfiles();

}
