package oduad.fi.finder.controller;

import oduad.fi.finder.entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


public interface UserController {
    ResponseEntity<?> createUser(User user);
    ResponseEntity<User> updateUser(Long id, User user);
    User getUser(Long id);
    void removeUser(String name);
    ResponseEntity<List<User>> getAllUsers();
}
