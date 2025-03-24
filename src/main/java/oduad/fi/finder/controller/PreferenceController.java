package oduad.fi.finder.controller;

import oduad.fi.finder.entity.User;
import org.springframework.http.ResponseEntity;
import java.util.List;

public interface PreferenceController {

    ResponseEntity<List<User>> findUsersByPreferences(Long userId, int minAge, int maxAge,
                                                       double maxDistance, String preferredGender,
                                                       int minHeight, int maxHeight);
}
