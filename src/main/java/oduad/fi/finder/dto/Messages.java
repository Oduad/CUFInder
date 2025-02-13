package oduad.fi.finder.dto;
import java.time.LocalDateTime;

public class Messages {
    //Each conversation between users will save here

    private Long id;

    private User sender;

    private User receiver;

    private String content;

    private LocalDateTime sentAt;


}
