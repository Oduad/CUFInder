package oduad.fi.finder.repository;

import oduad.fi.finder.entity.Preference;
import oduad.fi.finder.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PreferenceRepository extends JpaRepository<Preference, Long> {

    @Query(value = "SELECT * FROM preference u " +
            "WHERE u.id != :userId " +
            "AND u.age BETWEEN :minAge AND :maxAge " +
            //"AND ST_Distance_Sphere(POINT(u.latitude, u.longitude), POINT(:userLat, :userLng)) BETWEEN :minDistance AND :maxDistance " +
            "AND u.gender = :preferredGender " +
            "AND u.profilePicture IS NOT NULL " +
            "AND u.height BETWEEN :minHeight AND :maxHeight",
            nativeQuery = true)
    List<User> findUsersByPreferences(@Param("userId") Long userId,
                                      @Param("minAge") int minAge,
                                      @Param("maxAge") int maxAge,
                                      @Param("maxDistance") double maxDistance,
                                      @Param("preferredGender") String preferredGender,
                                      @Param("minHeight") int minHeight,
                                      @Param("maxHeight") int maxHeight);
}
