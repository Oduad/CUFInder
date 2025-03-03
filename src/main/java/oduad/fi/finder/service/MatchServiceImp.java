package oduad.fi.finder.service;

import oduad.fi.finder.entity.Match;
import oduad.fi.finder.repository.MatchRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchServiceImp implements MatchService{

    MatchRepository matchRepository;

    public MatchServiceImp(MatchRepository matchRepository){
        this.matchRepository = matchRepository;
    }

    @Override
    public Match createMatch(Long userId1, Long userId2) {
        return null;
    }

    @Override
    public List<Match> getMatchesByUser(Long userId) {
        return matchRepository.findByUser1IdOrUser2Id(userId, userId);
    }

    @Override
    public void deleteMatch(Long matchId) {

    }

    @Override
    public boolean existsMatch(Long userId1, Long userId2) {
        return false;
    }

    @Override
    public void notifyMatch(Match match) {

    }

}
