package oduad.fi.finder.service;

import oduad.fi.finder.entity.User;
import oduad.fi.finder.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Service
public class UserServiceImp implements UserService{

    private final UserRepository userRepository;
    //@Autowired
    public UserServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(Long id, User updateUser) {
        updateUser.setId(id);
        return userRepository.save(updateUser);
    }

    @Override
    public void removeUser(String name) {
        userRepository.deleteByName(name);
    }

    @Override
    public User getUser(Long id) {
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()){
            return user.get();
        }else{
            return null;
        }
    }
}
