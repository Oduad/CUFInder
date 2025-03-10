package oduad.fi.finder.service;

import oduad.fi.finder.entity.Match;
import oduad.fi.finder.repository.MatchRepository;
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
        return matchRepository.findByUser1Id(userId);
    }

    @Override
    public void deleteMatch(Long matchId) {
        matchRepository.deleteById(matchId);
    }

    @Override
    public boolean existsMatch(Long userId1, Long userId2) {
        return matchRepository.existsByUser1IdAndUser2Id(userId1, userId2) ||
                matchRepository.existsByUser1IdAndUser2Id(userId2, userId1);
    }

    @Override
    public void notifyMatch(Match match) {
        matchRepository.notify();
    }

}
