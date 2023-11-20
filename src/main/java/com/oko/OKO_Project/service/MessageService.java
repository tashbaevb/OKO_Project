package com.oko.OKO_Project.service;

import com.oko.OKO_Project.entity.Message;

import java.util.List;

public interface MessageService {

    Message createMessage(Message message, Long userId);

    Message createReplyMessage(Message message, Long parentMessageId, Long userId);

    List<Message> getRepliesMessage(Long messageId);

    Message getById(Long id);

    List<Message> getAllMessage(Message message);

    Message updateMessage(Message message);

    void delete(Long id);
}
