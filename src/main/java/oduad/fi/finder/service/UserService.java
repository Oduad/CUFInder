package oduad.fi.finder.service;
import oduad.fi.finder.dto.UserDto;
import oduad.fi.finder.entity.User;

public interface UserService {

    User createUser(User user);
    User updateUser(Long id, User user);
    void removeUser(String name);
    User getUser(Long id);

}
