package oduad.fi.finder.controller;

import oduad.fi.finder.entity.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/fisfinder")
public class PreferenceControllerImp implements PreferenceController{

    @Override
    public List<User> findUsersByPreferences(Long userId,
                                             int minAge,
                                             int maxAge,
                                             double maxDistance,
                                             String preferredGender,
                                             int minHeight, int maxHeight) {
        return null;
    }
}
