package oduad.fi.finder.controller;

import oduad.fi.finder.entity.Match;
import oduad.fi.finder.repository.MatchRepository;
import oduad.fi.finder.service.MatchServiceImp;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/fisfinder")
public class MatchControllerImp implements MatchController{

    private final MatchServiceImp matchService;
    private final MatchRepository matchRepository;

    public MatchControllerImp(MatchServiceImp matchServiceImp, MatchRepository matchRepository){
        this.matchRepository = matchRepository;
        this.matchService = matchServiceImp;
    }

    @Override
    @PostMapping
    public void createMatch(@RequestParam Long userId1, @RequestParam Long userId2) {
        matchService.createMatch(userId1, userId2);
    }

    @Override
    @GetMapping("/{userId}")
    public List<Match> getMatchesByUser(@PathVariable Long userId) {
        return matchService.getMatchesByUserId(userId);
    }

    @Override
    @DeleteMapping("/{matchId}")
    public ResponseEntity<Void> deleteMatch(@PathVariable Long matchId) {
        matchService.deleteMatch(matchId);
        return ResponseEntity.noContent().build();
    }

    @Override
    @GetMapping("/exists")
    public boolean existsMatch(@PathVariable Long userId1, @PathVariable Long userId2) {
        return matchService.existMatch(userId1, userId2);
    }

    @Override
    @PutMapping("/notify")
    public void notifyMatch(@RequestParam Long userId, @RequestParam Long matchedUserId) {
        matchService.notifyMatch(userId, matchedUserId);
    }
}
