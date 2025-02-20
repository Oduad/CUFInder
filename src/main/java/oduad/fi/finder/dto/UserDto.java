package oduad.fi.finder.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class UserDto {
    //This is for

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
