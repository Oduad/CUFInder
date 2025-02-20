package oduad.fi.finder.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GenerationType;
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
    private String name;
    private String email;
    private String password;
    private String gender;
    private String career;
    private String school;
    private Integer height;
    private String interestedIn;
    //It's about the student's biography
    private String bio;
    private String profilePictureUrl;
    private LocalDate birthDate;
    private LocalDateTime createdAt;

}
