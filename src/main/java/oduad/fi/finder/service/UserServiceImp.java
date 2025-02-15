package oduad.fi.finder.service;

import oduad.fi.finder.entity.User;
import oduad.fi.finder.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService{

    private final UserRepository userRepository;
    @Autowired
    public UserServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void updateUser(Long id, User updateUser) {
        updateUser.setId(id);
        userRepository.save(updateUser);
    }

    @Override
    public void removeUser() {

    }
}
