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
    private LocalDate birthDate;
    private LocalDateTime createdAt;
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Profile profile;


}
