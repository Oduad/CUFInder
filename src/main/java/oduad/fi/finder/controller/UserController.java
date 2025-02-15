package oduad.fi.finder.controller;

import oduad.fi.finder.entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;


public interface UserController {
    ResponseEntity<User> createUser(User user);
    ResponseEntity<User> updateUser(Long id, User user);
    User getUser(Long id);
    void removeUser();
}
