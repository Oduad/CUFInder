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

    public MatchServiceImp(MatchRepository matchRepository){
        this.matchRepository = matchRepository;
    }

    @Override
    public void createMatch(Long userId1, Long userId2) {
        if (!checkMatch(userId1, userId2)) {
            Match match = new Match();
            match.setUser1(userRepository.findById(userId1).orElseThrow());
            match.setUser2(userRepository.findById(userId2).orElseThrow());
            matchRepository.save(match);
        }
    }

    @Override
    public boolean checkMatch(Long userId1, Long userId2) {
        return matchRepository.existsByUser1IdAndUser2Id(userId1, userId2) ||
                matchRepository.existsByUser1IdAndUser2Id(userId2, userId1);
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
    public void notifyMatch(Long userId, Long matchedUserId) {
        User user = userRepository.findById(userId).orElseThrow();
        User matchedUser = userRepository.findById(matchedUserId).orElseThrow();

        String message = "🎉 ¡Has hecho match con " + matchedUser.getProfile().getUsername() + "!";

        // Opción 1: Enviar un correo
        //emailService.sendEmail(user.getEmail(), "¡Nuevo Match!", message);

        // Opción 2: Notificación Push
        //pushNotificationService.sendNotification(user, message);

        // Opción 3: Notificación en la app (si usas WebSockets)
        //webSocketService.sendNotification(userId, message);
    }

}
