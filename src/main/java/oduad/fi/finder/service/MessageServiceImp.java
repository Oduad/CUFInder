package oduad.fi.finder.service;

import oduad.fi.finder.entity.Message;
import oduad.fi.finder.entity.User;
import oduad.fi.finder.repository.MessageRepository;
import oduad.fi.finder.repository.UserRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class MessageServiceImp implements MessageService{

    private final MessageRepository messageRepository;
    private final MatchService matchService;
    private final UserRepository userRepository;

    MessageServiceImp(MessageRepository messageRepository,
                       MatchService matchService,
                       UserRepository userRepository){
        this.messageRepository = messageRepository;
        this.matchService = matchService;
        this.userRepository = userRepository;
    }

    @Override
    public Message sendMessage(Long senderId, Long receiverId, String content) {
        if (!matchService.existMatch(senderId, receiverId)) {
            throw new IllegalArgumentException("You cannot send a message without a match.");
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
        return messageRepository.save(message);
    }

    @Override
    public List<Message> getConversation(Long userId1, Long userId2) {
        return messageRepository.findMessagesBetweenUsers(userId1, userId2);
    }

    @Override
    public void deleteMessage(Long messageId, Long userId) {
        Optional<Message> messageOpt = messageRepository.findById(messageId);
        if (messageOpt.isPresent()) {
            Message message = messageOpt.get();
            if (!message.getSender().getId().equals(userId)) {
                throw new SecurityException("You cannot send a message you did not send.");
            }
            messageRepository.deleteById(messageId);
        } else {
            throw new NoSuchElementException("Message not found");
        }
    }

}
