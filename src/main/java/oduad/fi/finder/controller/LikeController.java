package oduad.fi.finder.controller;

import oduad.fi.finder.entity.Like;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface LikeController {

    ResponseEntity<Like> createLike(Long userId, Long targetUserId);

    ResponseEntity<List<Like>> getSentLikes(Long userId);

    ResponseEntity<List<Like>> getReceivedLikes(Long userId);

}
