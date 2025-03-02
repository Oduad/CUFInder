package oduad.fi.finder.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import oduad.fi.finder.entity.Profile;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class UserDTO {

    private Long id;
    private String name;
    private String email;
    private String password;
    private LocalDate birthDate;
    private LocalDateTime createdAt;
    private Profile profile;
    private String role;

}
