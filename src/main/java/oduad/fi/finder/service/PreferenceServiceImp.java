package oduad.fi.finder.service;

import oduad.fi.finder.entity.Preference;
import oduad.fi.finder.entity.User;
import oduad.fi.finder.repository.PreferenceRepository;
import oduad.fi.finder.repository.UserRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PreferenceServiceImp implements PreferenceService {

    private final PreferenceRepository preferenceRepository;
    private Preference preference;

    public PreferenceServiceImp(PreferenceRepository preferenceRepository) {
        this.preferenceRepository = preferenceRepository;
    }

    @Override
    public List<User> findUsersByPreferences(Long userId, int minAge, int maxAge, double maxDistance, String preferredGender, int minHeight, int maxHeight) {
        return preferenceRepository.findUsersByPreferences(userId, minAge, maxAge,
                maxDistance, preferredGender, minHeight, maxHeight);
    }

    /*@Override
    public void setPreferences(int minAge, int maxAge, int maxDistance, String preferredGender, float minHeight, float maxHeight) {
        preference.setMinAge(minAge);
        preference.setMaxAge(maxAge);
        preference.setMaxDistance(maxDistance);
        preference.setPreferredGender(preferredGender);
        preference.setMinHeight(minHeight);
        preference.setMaxHeight(maxHeight);
        preferenceRepository.save(preference);
    }*/

}
