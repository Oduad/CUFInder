package oduad.fi.finder.service;

import jakarta.persistence.EntityNotFoundException;
import oduad.fi.finder.entity.User;
import oduad.fi.finder.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImp implements UserService{

    //@Autowired
    private final UserRepository userRepository;
    public UserServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(User user) {
        if(userRepository.findByEmail(user.getEmail()).isPresent()){
            throw new IllegalArgumentException(
                    "This username already exists");
        }
        if(userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new IllegalArgumentException(
                    "This email already exists");
        }
        return userRepository.save(user);
    }

    @Override
    //@PreAuthorize("#id == principal.id")
    public User updateUser(Long id, User updateUser) {
        Optional<User> existingUserOpt = userRepository.findById(id);
        if (existingUserOpt.isPresent()) {
            User existingUser = existingUserOpt.get();
            // Update the mandatory atribbutes
            existingUser.setName(updateUser.getName());
            existingUser.setEmail(updateUser.getEmail());
            existingUser.setBirthDate(updateUser.getBirthDate());
            //existingUser.setProfile(updateUser.getProfile());
            return userRepository.save(existingUser);
        } else {
            throw new EntityNotFoundException("User not found with the ID: " + id);
        }
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
