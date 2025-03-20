package oduad.fi.finder.service;

import oduad.fi.finder.entity.Like;
import oduad.fi.finder.entity.Match;
import oduad.fi.finder.repository.LikeRepository;
import oduad.fi.finder.repository.MatchRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LikeServiceImp implements LikeService {

    private LikeRepository likeRepository;
    private MatchRepository matchRepository;
    private final MatchService matchService;

    public LikeServiceImp(LikeRepository likeRepository, MatchRepository matchRepository, MatchService matchService) {
        this.likeRepository = likeRepository;
        this.matchRepository = matchRepository;
        this.matchService = matchService;
    }

    public Like createLike(Long userId, Long targetUserId) {
        if (likeRepository.existsByUserIdAndTargetUserId(userId, targetUserId)) {
            throw new IllegalStateException("Like already exists");
        }
        Like like = new Like();
        like.setUserId(userId);
        like.setTargetUserId(targetUserId);
        likeRepository.save(like);

        // Checks if the 'like' is mutual and delegates the creation of the 'match' to MatchService
        if (likeRepository.existsByUserIdAndTargetUserId(targetUserId, userId)) {
            matchService.createMatch(userId, targetUserId);
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
