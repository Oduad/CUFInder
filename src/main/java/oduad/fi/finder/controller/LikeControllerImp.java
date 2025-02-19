package oduad.fi.finder.controller;

import oduad.fi.finder.entity.Like;
import oduad.fi.finder.service.LikeServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fisfinder")
public class LikeControllerImp implements LikeController{

    @Autowired
    private LikeServiceImp likeService;

    @PostMapping("/like")
    @Override
    public ResponseEntity<Like> createLike(@RequestParam Long userId, @RequestParam Long targetUserId) {
        Like like = likeService.createLike(userId, targetUserId);
        return ResponseEntity.ok(like);
    }

    @GetMapping("/likesgiven")
    @Override
    public ResponseEntity<List<Like>> getAllLikes(@RequestParam Long userId) {
        return null;
        //return ResponseEntity.ok(likeService.getAllLikes(userId));
    }

    @GetMapping("/likesreceived")
    @Override
    public ResponseEntity<List<Like>> getReceivedLikes(@RequestParam Long userId) {
        return null;
        //return ResponseEntity.ok(likeService.getReceivedLikes(userId));
    }

}
