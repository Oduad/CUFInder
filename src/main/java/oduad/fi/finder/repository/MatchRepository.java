package oduad.fi.finder.repository;

import oduad.fi.finder.entity.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MatchRepository extends JpaRepository<Match, Long> {

    List<Match> findByUser1Id(Long userId);

    boolean existsByUser1IdAndUser2Id(Long user1Id, Long user2Id);



}
