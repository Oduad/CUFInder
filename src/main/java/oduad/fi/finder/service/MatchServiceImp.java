package oduad.fi.finder.service;

import oduad.fi.finder.entity.Match;
import oduad.fi.finder.entity.User;
import oduad.fi.finder.repository.MatchRepository;
import oduad.fi.finder.repository.UserRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MatchServiceImp implements MatchService{

    MatchRepository matchRepository;
    UserRepository userRepository;
    // Servicios de notificación (correo, push, etc.) pueden inyectarse aquí

    public MatchServiceImp(MatchRepository matchRepository, UserRepository userRepository){
        this.matchRepository = matchRepository;
        this.userRepository = userRepository;
        // Inicialización de servicios de notificación
    }

    @Override
    public void createMatch(Long userId1, Long userId2) {
        if (!checkMatch(userId1, userId2)) {
            //if (!existsMatch(userId1, userId2)) {
            Match match = new Match();
            match.setUser1(userRepository.findById(userId1).orElseThrow());
            match.setUser2(userRepository.findById(userId2).orElseThrow());
            matchRepository.save(match);
            //notifyMatch(userId1, userId2);
            //notifyMatch(userId2, userId1);
        }
    }

    //This method checks if there is a match
    public boolean checkMatch(Long userId1, Long userId2) {
        return matchRepository.existsByUser1IdAndUser2Id(userId1, userId2) ||
                matchRepository.existsByUser1IdAndUser2Id(userId2, userId1);
    }

    @Override
    public List<Match> getMatchesByUserId(Long userId) {
        return matchRepository.findByUser1IdOrUser2Id(userId, userId);
    }

    @Override
    public void deleteMatch(Long matchId) {
        if (!matchRepository.existsById(matchId)) {
            throw new RuntimeException("No se encontró el match con ID: " + matchId);
        }
        matchRepository.deleteById(matchId);
    }

    @Override
    public void notifyMatch(Long userId, Long matchedUserId) {
        List<User> users = userRepository.findUsersByIds(userId, matchedUserId);
        if (users.size() < 2) {
            throw new RuntimeException("Uno o ambos usuarios no existen");
        }
        // Identificar cuál es cuál basándonos en sus IDs
        User user = users.get(0).getId().equals(userId) ? users.get(0) : users.get(1);
        User matchedUser = users.get(0).getId().equals(matchedUserId) ? users.get(1) : users.get(0);
        String message = "🎉 ¡Has hecho match con " + matchedUser.getProfile().getUsername() + "!";
    }
}
