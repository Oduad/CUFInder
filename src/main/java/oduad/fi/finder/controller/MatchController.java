package oduad.fi.finder.controller;

import oduad.fi.finder.entity.Match;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface MatchController {

    public Match createMatch(Long userId1, Long userId2);

    public List<Match> getMatchesByUser(Long userId);

    public ResponseEntity<Void> deleteMatch(Long matchId);

    public boolean existsMatch(Long userId1, Long userId2);

    public void notifyMatch(Match match);

}
