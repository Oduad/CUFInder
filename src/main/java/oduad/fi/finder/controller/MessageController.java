package oduad.fi.finder.controller;

import oduad.fi.finder.entity.Message;
import org.springframework.http.ResponseEntity;
import java.util.List;

public interface MessageController {

    ResponseEntity<Message> sendMessage(Long senderId, Long receiverId, String content);
    ResponseEntity<List<Message>> getConversation(Long userId1, Long userId2);
    ResponseEntity<Void> deleteMessage(Long messageId, Long userId);

}
