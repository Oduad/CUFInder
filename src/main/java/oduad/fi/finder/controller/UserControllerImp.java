package oduad.fi.finder.controller;

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
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User createdUser = userService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }

    @Override
    @PutMapping("/user/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id,
                           @RequestBody User updatedUser) {
        updatedUser.setId(id);
        repository.save(updatedUser);
        return ResponseEntity.ok(updatedUser);
    }

    @Override
    public User getUser(Long id) {
        return null;
    }

    @Override
    public void removeUser() {

    }
}
