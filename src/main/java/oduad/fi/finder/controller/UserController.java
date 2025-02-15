package oduad.fi.finder.controller;

import oduad.fi.finder.entity.User;
import org.springframework.web.bind.annotation.RestController;


public interface UserController {
    void createUser(User user);
    void updateUser(Long id, User user);
    void removeUser();

}
