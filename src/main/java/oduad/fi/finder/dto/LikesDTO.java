package oduad.fi.finder.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LikesDTO {

    private Long id;
    private Long userId;
    private Long targetUserId;

}
