package oduad.fi.finder.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import oduad.fi.finder.entity.User;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class MatchDTO {

//This claass saves coincidences when 2 users like each other.
    private Long id;
    private User user1;
    private User user2;
    private Long senderId;
    private Long receiverId;
    private String content;
    private LocalDateTime sentAt;

}