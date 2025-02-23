package oduad.fi.finder.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PreferenceDTO {
    //Every User can set search criteria
    private Long id;
    private UserDto user;
    private int minAge;
    private int maxAge;
    private int maxDistance;
    private float minHeight;
    private String preferredGender;
    private boolean profilePicture;

}
