package oduad.fi.finder.dto;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class MessagesDTO {
    //Each conversation between users will save here

    private Long id;

    private UserDTO sender;

    private UserDTO receiver;

    private String content;

    private LocalDateTime sentAt;


}
