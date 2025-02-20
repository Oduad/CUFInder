package oduad.fi.finder.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Preferences {
    //Every User can set search criteria
    private Long id;
    private UserDto user;
    private int minAge;
    private int maxAge;
    private int maxDistance;
    private int minHeight;

}
