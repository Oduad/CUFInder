package oduad.fi.finder.repository;

import jakarta.transaction.Transactional;
import oduad.fi.finder.entity.Profile;
import oduad.fi.finder.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ProfileRepository extends JpaRepository<Profile, Long>  {

    @Modifying
    @Transactional
    @Query("DELETE FROM Profile c WHERE c.username = :username")
    public void deleteByName(@Param("username") String username);

    Optional<Profile> findByUserName(String username);
    //Optional<Profile> findByEmail(String email);

}
