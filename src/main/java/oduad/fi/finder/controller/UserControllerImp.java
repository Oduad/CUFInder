package oduad.fi.finder.controller;

import oduad.fi.finder.entity.Like;
import oduad.fi.finder.entity.User;
import oduad.fi.finder.repository.UserRepository;
import oduad.fi.finder.service.UserService;
import oduad.fi.finder.service.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fisfinder")
public class UserControllerImp implements UserController{

    //@Autowired
    private final UserServiceImp userService;
    //@Autowired
    private final UserRepository repository;

    public UserControllerImp(UserServiceImp userService, UserRepository repository){
        this.userService = userService;
        this.repository = repository;
    }

    @Override
    @PostMapping("/user")
    public ResponseEntity<?> createUser(@RequestBody User user) {
        try {
            User createdUser = userService.createUser(user);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }

    @Override
    @PutMapping("/user/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id,
                           @RequestBody User updatedUser) {
        updatedUser.setId(id);
        userService.updateUser(id, updatedUser);
        return ResponseEntity.ok(updatedUser);
    }

    @Override
    @GetMapping("/user/{id}")
    public User getUser(@PathVariable Long id) {
        return userService.getUser(id);
    }

    @Override
    @DeleteMapping("/user/{name}")
    public void removeUser(@PathVariable String name) {
        userService.removeUser(name);
    }

    @Override
    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        ResponseEntity<List<User>>users = userService.getAllUsers();
        return users;
    }
}
