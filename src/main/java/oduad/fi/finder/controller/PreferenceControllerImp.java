package oduad.fi.finder.controller;

import oduad.fi.finder.entity.User;
import oduad.fi.finder.service.PreferenceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/fisfinder")
public class PreferenceControllerImp implements PreferenceController{

    private final PreferenceService preferenceService;

    public PreferenceControllerImp(PreferenceService preferenceService){
        this.preferenceService = preferenceService;
    }

    @Override
    @GetMapping("/preference")
    //public List<User> findUsersByPreferences(
    public ResponseEntity<List<User>> findUsersByPreferences(
            @RequestParam Long userId,
            @RequestParam int minAge,
            @RequestParam int maxAge,
            @RequestParam double maxDistance,
            @RequestParam String preferredGender,
            @RequestParam int minHeight, @RequestParam int maxHeight) {

        List<User> users = preferenceService.findUsersByPreferences(userId, minAge,
                maxAge, maxDistance, preferredGender, minHeight, maxHeight);
        return ResponseEntity.ok(users);
    }

}
