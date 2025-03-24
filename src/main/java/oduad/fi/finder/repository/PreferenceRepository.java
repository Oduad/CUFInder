package oduad.fi.finder.repository;

import oduad.fi.finder.entity.Preference;
import oduad.fi.finder.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PreferenceRepository extends JpaRepository<Preference, Long> {

    @Query("SELECT u FROM User u JOIN u.profile p JOIN p.preferences pref " +
            "WHERE u.id != :userId " +
            "AND u.birthDate BETWEEN :minBirthDate AND :maxBirthDate " +
            "AND p.gender = :preferredGender " +
            "AND p.profilePictureUrl IS NOT NULL " +
            "AND p.height BETWEEN :minHeight AND :maxHeight")
    List<User> findUsersByPreferences(@Param("userId") Long userId,
                                      @Param("minBirthDate") LocalDate minBirthDate,
                                      @Param("maxBirthDate") LocalDate maxBirthDate,
                                      @Param("maxDistance") double maxDistance,
                                      @Param("preferredGender") String preferredGender,
                                      @Param("minHeight") float minHeight,
                                      @Param("maxHeight") float maxHeight);

}
