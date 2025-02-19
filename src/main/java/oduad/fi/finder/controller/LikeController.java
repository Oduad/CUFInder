package oduad.fi.finder.controller;

import oduad.fi.finder.entity.Like;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface LikeController {

    public ResponseEntity<Like> createLike(Long userId, Long targetUserId);

    public ResponseEntity<List<Like>> getAllLikes(Long userId);

    public ResponseEntity<List<Like>> getReceivedLikes(Long userId);

}
