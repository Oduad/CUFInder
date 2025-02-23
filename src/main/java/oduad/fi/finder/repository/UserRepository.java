package oduad.fi.finder.repository;
import jakarta.transaction.Transactional;
import oduad.fi.finder.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Modifying
    @Transactional
    @Query("DELETE FROM User c WHERE c.username = :username")
    public void deleteByName(@Param("username") String username);

    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);

}
