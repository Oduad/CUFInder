package oduad.fi.finder.controller;

import oduad.fi.finder.entity.Message;
import java.util.List;

public interface MessageController {

    Message sendMessage(Long senderId, Long receiverId, String content);
    List<Message> getConversation(Long userId1, Long userId2);
    void deleteMessage(Long messageId, Long userId);

}
