package oduad.fi.finder.controller;

import oduad.fi.finder.entity.User;
import oduad.fi.finder.repository.UserRepository;
import oduad.fi.finder.service.UserService;
import oduad.fi.finder.service.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/fisfinder")
public class UserControllerImp implements UserController{

    @Autowired
    UserServiceImp userService;
    @Autowired
    UserRepository repository;


    @Override
    @PostMapping("/user")
    public void createUser(@RequestBody User user) {
        userService.createUser(user);
    }

    @Override
    @PutMapping("/user/{id}")
    public void updateUser(@PathVariable Long id,
                           @RequestBody User updateUser) {
        updateUser.setId(id);
        repository.save(updateUser);
    }

    @Override
    public void removeUser() {

    }
}
