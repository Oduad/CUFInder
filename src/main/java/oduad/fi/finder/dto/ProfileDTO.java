package oduad.fi.finder.dto;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import oduad.fi.finder.entity.Preference;
import oduad.fi.finder.entity.User;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class ProfileDTO {

    private Long id;
    private String username;
    private String gender;
    private String career;
    private String school;
    private float height;
    private String bio;
    private String profilePictureUrl;
    private LocalDate birthDate;
    private LocalDateTime createdAt;
    private String nationallity;
    private Preference preference;
    private User user;

}
