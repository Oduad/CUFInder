package oduad.fi.finder.controller;

import oduad.fi.finder.entity.Match;
import oduad.fi.finder.repository.MatchRepository;
import oduad.fi.finder.repository.UserRepository;
import oduad.fi.finder.service.MatchServiceImp;
import oduad.fi.finder.service.UserServiceImp;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/fisfinder")
public class MatchControllerImp implements MatchController{

    private final MatchServiceImp matchServiceImp;
    //@Autowired
    private final MatchRepository matchRepository;

    public MatchControllerImp(MatchServiceImp matchServiceImp, MatchRepository matchRepository){
        this.matchRepository = matchRepository;
        this.matchServiceImp = matchServiceImp;
    };

    @Override
    public Match createMatch(Long userId1, Long userId2) {
        return null;
    }

    @Override
    public List<Match> getMatchesByUser(Long userId) {
        return matchServiceImp.getMatchesByUser(userId);
    }

    @Override
    @DeleteMapping("/{matchId}")
    public ResponseEntity<Void> deleteMatch(@PathVariable Long matchId) {
        matchServiceImp.deleteMatch(matchId);
        return ResponseEntity.noContent().build();
    }

    @Override
    public boolean existsMatch(Long userId1, Long userId2) {
        return false;
    }

    @Override
    public void notifyMatch(Match match) {

    }
}
