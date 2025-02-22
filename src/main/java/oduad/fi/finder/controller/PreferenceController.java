package oduad.fi.finder.controller;

import oduad.fi.finder.entity.User;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

public interface PreferenceController {

    List<User> findUsersByPreferences(Long userId, int minAge, int maxAge,
                                      double maxDistance, String preferredGender,
                                      int minHeight, int maxHeight);
}
