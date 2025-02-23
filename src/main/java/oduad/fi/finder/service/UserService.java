package oduad.fi.finder.service;
import oduad.fi.finder.dto.UserDto;
import oduad.fi.finder.entity.Like;
import oduad.fi.finder.entity.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {

    User createUser(User user);
    User updateUser(Long id, User user);
    void removeUser(String name);
    User getUser(Long id);
    ResponseEntity<List<User>> getAllUsers();

}
