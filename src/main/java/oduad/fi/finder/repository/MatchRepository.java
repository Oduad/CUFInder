package oduad.fi.finder.repository;

import oduad.fi.finder.entity.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatchRepository extends JpaRepository<Match, Long> {



}
