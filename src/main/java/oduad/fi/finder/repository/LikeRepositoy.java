package oduad.fi.finder.repository;

import oduad.fi.finder.entity.Like;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LikeRepositoy extends JpaRepository<Like, Long> {

    boolean existsByUserIdAndTargetUserId(Long userId, Long targetUserId);
    List<Like> findByUserId(Long userId);
    List<Like> findByTargetUserId(Long userId);

}
