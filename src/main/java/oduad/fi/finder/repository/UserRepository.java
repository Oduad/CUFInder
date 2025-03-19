package oduad.fi.finder.repository;
import jakarta.transaction.Transactional;
import oduad.fi.finder.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Modifying
    @Transactional
    @Query("DELETE FROM User c WHERE c.name = :name")
    public void deleteByName(@Param("name") String name);
    @Query("SELECT u FROM User u WHERE u.id IN (:userId1, :userId2)")
    List<User> findUsersByIds(@Param("userId1") Long userId1, @Param("userId2") Long userId2);

    Optional<User> findByName(String name);
    Optional<User> findByEmail(String email);

}
