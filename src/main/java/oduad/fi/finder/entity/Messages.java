package oduad.fi.finder.entity;

import jakarta.persistence.*;
import lombok.Data;
import oduad.fi.finder.dto.UserDTO;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "message")
public class Messages {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private UserDTO sender;

    private UserDTO receiver;

    private String content;

    private LocalDateTime sentAt;

}
