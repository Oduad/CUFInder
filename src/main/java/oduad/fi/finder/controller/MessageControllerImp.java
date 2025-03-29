package oduad.fi.finder.controller;

import oduad.fi.finder.entity.Message;
import oduad.fi.finder.service.MessageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
    public ResponseEntity<Message> sendMessage(
            @PathVariable Long senderId,
            @PathVariable Long receiverId,
            @RequestParam String content) {
        Message message = messageService.sendMessage(senderId, receiverId, content);
        return ResponseEntity.ok(message);
    }

    @Override
    @GetMapping("/message/{id1}/{id2}")
    public  ResponseEntity<List<Message>> getConversation(@PathVariable Long userId1,
                                         @PathVariable Long userId2) {
        List<Message> conversation = messageService.getConversation(userId1, userId2);
        return ResponseEntity.ok(conversation);
    }

    @Override
    @DeleteMapping("/message/{messageId}/{userId}")
    public ResponseEntity<Void> deleteMessage(@PathVariable Long messageId,
                              @PathVariable Long userId) {
        messageService.deleteMessage(messageId, userId);
        return ResponseEntity.noContent().build();
    }
}
