package oduad.fi.finder.service;

import oduad.fi.finder.entity.User;
import oduad.fi.finder.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
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
        if(userRepository.findByName(user.getName()).isPresent() &&
        userRepository.findByEmail(user.getEmail()).isPresent()){
            throw new IllegalArgumentException(
                    "El nombre de usuario ya está en uso.");
        }
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

    @Override
    public ResponseEntity<List<User>> getAllUsers() {
        List<User>users = userRepository.findAll();
        return ResponseEntity.ok(users);
    }
}
