package com.oko.OKO_Project.repository;

import com.oko.OKO_Project.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {

    List<Message> findByParentMessage(Message parentMessage);
}
