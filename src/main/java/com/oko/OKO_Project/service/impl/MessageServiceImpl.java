package com.oko.OKO_Project.service.impl;

import com.oko.OKO_Project.entity.Message;
import com.oko.OKO_Project.entity.User;
import com.oko.OKO_Project.repository.MessageRepository;
import com.oko.OKO_Project.repository.UserRepository;
import com.oko.OKO_Project.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MessageServiceImpl implements MessageService {

    private final MessageRepository messageRepository;
    private final UserRepository userRepository;

    @Override
    public List<Message> getAllMessage(Message message) {
        return messageRepository.findAll();
    }

    @Override
    public List<Message> getRepliesMessage(Long messageId) {
        Message parentMessage = getById(messageId);
        return messageRepository.findByParentMessage(parentMessage);
    }

    @Override
    public Message createMessage(Message message, Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        message.setUser(user);

        Message createdMessage = messageRepository.save(message);

        return createdMessage;
    }

    @Override
    public Message createReplyMessage(Message message, Long parentMessageId, Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        message.setUser(user);

        if (parentMessageId != null) {
            Message parentMessage = getById(parentMessageId);
            message.setParentMessage(parentMessage);
        }

        Message createdReply = messageRepository.save(message);

        return createdReply;
    }

    @Override
    public Message getById(Long id) {
        return messageRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Message not found"));
    }

    @Override
    public Message updateMessage(Message message) {
        return messageRepository.save(message);
    }

    @Override
    public void delete(Long id) {
        Message message = getById(id);
        messageRepository.delete(message);
    }
}
