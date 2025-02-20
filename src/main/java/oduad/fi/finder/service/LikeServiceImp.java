package oduad.fi.finder.service;

import oduad.fi.finder.entity.Like;
import oduad.fi.finder.entity.Match;
import oduad.fi.finder.repository.LikeRepositoy;
import oduad.fi.finder.repository.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LikeServiceImp implements LikeService {

    @Autowired
    private LikeRepositoy likeRepository;

    @Autowired
    private MatchRepository matchRepository;

    public Like createLike(Long userId, Long targetUserId) {
        if (likeRepository.existsByUserIdAndTargetUserId(userId, targetUserId)) {
            throw new IllegalStateException("Like already exists");
        }

        Like like = new Like();
        like.setUserId(userId);
        like.setTargetUserId(targetUserId);
        likeRepository.save(like);

        // Verifica si el like es mutuo y crea un match
        if (likeRepository.existsByUserIdAndTargetUserId(targetUserId, userId)) {
            Match match = new Match();
            match.setSenderId(userId);
            match.setReceiverId(targetUserId);
            matchRepository.save(match);
        }
        return like;
    }
    @Override
    public ResponseEntity<List<Like>> getSentLikes(Long userId) {
        List<Like> likesSent = likeRepository.findByUserId(userId);
        if (likesSent.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(likesSent);
    }
    @Override
    public ResponseEntity<List<Like>> getReceivedLikes(Long userId) {
        List<Like> likesReceived = likeRepository.findByTargetUserId(userId);
        if (likesReceived.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(likesReceived);
    }
}
