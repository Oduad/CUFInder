package oduad.fi.finder.service;

import oduad.fi.finder.dto.MatchDTO;
import oduad.fi.finder.entity.Match;

import java.util.List;

public interface MatchService {

    public void createMatch(Long userId1, Long userId2);

    public List<Match> getMatchesByUserId(Long userId);

    public void deleteMatch(Long matchId);

    public boolean existMatch(Long userId1, Long userId2);

    public void notifyMatch(Long userId, Long matchedUserId);

}
