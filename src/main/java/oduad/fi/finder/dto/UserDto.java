package oduad.fi.finder.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import oduad.fi.finder.entity.Profile;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class UserDto {

    private Long id;
    private String username;
    private String email;
    private String password;
    private LocalDate birthDate;
    private LocalDateTime createdAt;
    private Profile profile;

}
