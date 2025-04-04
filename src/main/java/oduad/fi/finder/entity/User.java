package oduad.fi.finder.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
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
    private String name;
    private String email;

    @JsonProperty(access=JsonProperty.Access.WRITE_ONLY)
    private String password;
    private LocalDate birthDate;
    private LocalDateTime createdAt;
    //@OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    //@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Profile profile;
    private String role;

}
