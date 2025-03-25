package oduad.fi.finder.service;

import oduad.fi.finder.entity.Preference;
import oduad.fi.finder.entity.User;
import oduad.fi.finder.repository.PreferenceRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class PreferenceServiceImp implements PreferenceService {

    private final PreferenceRepository preferenceRepository;

    public PreferenceServiceImp(PreferenceRepository preferenceRepository) {
        this.preferenceRepository = preferenceRepository;
    }

    @Override
    public List<User> findUsersByPreferences(Long userId, int minAge, int maxAge,
        double maxDistance, String preferredGender, int minHeight, int maxHeight) {
        LocalDate today = LocalDate.now();
        LocalDate minBirthDate = today.minusYears(maxAge); // Older in range
        LocalDate maxBirthDate = today.minusYears(minAge); // Younger in range

        return preferenceRepository.findUsersByPreferences(userId, minBirthDate, maxBirthDate,
                maxDistance, preferredGender, minHeight, maxHeight);
    }

}
