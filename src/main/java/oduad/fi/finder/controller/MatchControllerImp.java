package oduad.fi.finder.controller;

import oduad.fi.finder.entity.Match;

import java.util.List;

public class MatchControllerImp implements MatchController{

    

    @Override
    public Match createMatch(Long userId1, Long userId2) {
        return null;
    }

    @Override
    public List<Match> getMatchesByUser(Long userId) {
        return null;
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
