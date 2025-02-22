package oduad.fi.finder.service;

import oduad.fi.finder.entity.User;
import oduad.fi.finder.repository.PreferenceRepository;
import oduad.fi.finder.repository.UserRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PreferenceServiceImp implements PreferenceService {

    private final PreferenceRepository preferenceRepository;

    public PreferenceServiceImp(PreferenceRepository preferenceRepository) {
        this.preferenceRepository = preferenceRepository;
    }

    @Override
    public List<User> findUsersByPreferences(Long userId, int minAge, int maxAge, double maxDistance, String preferredGender, int minHeight, int maxHeight) {
        return preferenceRepository.findUsersByPreferences(userId, minAge, maxAge,
                maxDistance, preferredGender, minHeight, maxHeight);
    }
}
