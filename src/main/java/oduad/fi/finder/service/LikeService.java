package oduad.fi.finder.service;

import oduad.fi.finder.entity.Like;

public interface LikeService {

    public Like createLike(Long userId, Long targetUserId);

    //public

}
