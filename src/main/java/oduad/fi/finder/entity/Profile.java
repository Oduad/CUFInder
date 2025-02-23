package oduad.fi.finder.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "profile")
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String gender;
    private String career;
    private String school;
    private float height;
    @ManyToOne
    @JoinColumn(name = "preference_id")
    private Preference preference;
    private String bio;
    private String profilePictureUrl;
    private LocalDate birthDate;
    private LocalDateTime createdAt;
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
    private String nationallity;

}
