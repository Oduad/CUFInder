package oduad.fi.finder.dto;

import java.time.LocalDateTime;

public class Match {

    //This claass saves coincidences when 2 users like each other.
    private Long id;
    private UserDto sender;
    private UserDto receiver;
    private String content;
    private LocalDateTime sentAt;

}
