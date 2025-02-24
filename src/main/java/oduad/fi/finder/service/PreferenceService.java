package oduad.fi.finder.service;

import oduad.fi.finder.entity.User;
import java.util.List;
public interface PreferenceService {
    List<User> findUsersByPreferences(Long userId, int minAge, int maxAge,
                                      double maxDistance, String preferredGender,
                                      int minHeight, int maxHeight);

    //void setPreferences(int minAge, int maxAge, int maxDistance,
                        //String preferredGender, float minHeight, float maxHeight);

}
