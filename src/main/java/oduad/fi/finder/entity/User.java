package oduad.fi.finder.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String email;
    private String password;
    private String gender;
    private String career;
    private String school;
    private Integer height;
    @ManyToOne
    @JoinColumn(name = "preference_id")
    private Preference preference;
    //It's about the student's biography
    private String bio;
    private String profilePictureUrl;
    private LocalDate birthDate;
    private LocalDateTime createdAt;


}
