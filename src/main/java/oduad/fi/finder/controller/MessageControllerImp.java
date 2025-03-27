package oduad.fi.finder.controller;

import oduad.fi.finder.entity.Message;
import oduad.fi.finder.service.MessageService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/fisfinder")
public class MessageControllerImp implements MessageController{

    private final MessageService messageService;

    MessageControllerImp(MessageService messageService){
        this.messageService = messageService;
    }

    @PostMapping("/message/{id1}/{id2}")
    @Override
    public Message sendMessage(Long senderId, Long receiverId, String content) {
        return messageService.sendMessage(senderId, receiverId, content);
    }

    @Override
    public List<Message> getConversation(Long userId1, Long userId2) {
        return null;
    }

    @Override
    public void deleteMessage(Long messageId, Long userId) {

    }
}
