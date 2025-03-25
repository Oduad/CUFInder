package oduad.fi.finder.service;

import oduad.fi.finder.entity.Message;
import oduad.fi.finder.entity.User;
import oduad.fi.finder.repository.MessagesRepository;
import oduad.fi.finder.repository.UserRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class MessagesServiceImp implements MessagesService{

    private final MessagesRepository messagesRepository;
    private final MatchService matchService;
    private final UserRepository userRepository;

    MessagesServiceImp(MessagesRepository messagesRepository,
                       MatchService matchService,
                       UserRepository userRepository){
        this.messagesRepository = messagesRepository;
        this.userRepository = userRepository;
        this.matchService = matchService;
    }

    @Override
    public Message sendMessage(Long senderId, Long receiverId, String content) {
        if (!matchService.existMatch(senderId, receiverId)) {
            throw new IllegalArgumentException("You can't send a message without a match.");
        }

        User sender = userRepository.findById(senderId)
                .orElseThrow(() -> new NoSuchElementException("Sender not found"));
        User receiver = userRepository.findById(receiverId)
                .orElseThrow(() -> new NoSuchElementException("Receiver not found"));

        Message message = new Message();

        message.setSender(sender);
        message.setReceiver(receiver);
        message.setContent(content);
        message.setSentAt(LocalDateTime.now());

        return messagesRepository.save(message);
    }

    @Override
    public List<Message> getConversation(Long userId1, Long userId2) {
        return null;
    }

    @Override
    public void deleteMessage(Long messageId, Long userId) {

    }
}
