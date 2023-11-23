package com.oko.OKO_Project.service.impl;

import com.oko.OKO_Project.entity.Comment;
import com.oko.OKO_Project.entity.User;
import com.oko.OKO_Project.repository.CommentRepository;
import com.oko.OKO_Project.repository.UserRepository;
import com.oko.OKO_Project.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final UserRepository userRepository;

    @Override
    public List<Comment> getAllComment() {
        return commentRepository.findAll();
    }


    @Override
    public List<Comment> getRepliesComment(Long messageId) {
        Comment parentComment = getById(messageId);
        return commentRepository.findByParentComment(parentComment);
    }


    @Override
    public Comment createComment(Comment comment, Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("Пользователь не найден: " + userId));
        comment.setUser(user);

        Comment createdComment = commentRepository.save(comment);

        return createdComment;
    }


    @Override
    public Comment createReplyComment(Comment comment, Long userId, Long parentCommentId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("Пользователь не найден: " + userId));
        comment.setUser(user);

        if (parentCommentId != null) {
            Comment parentComment = getById(parentCommentId);
            comment.setParentComment(parentComment);
        }

        Comment createdComment = commentRepository.save(comment);

        return createdComment;
    }


    @Override
    public Comment getById(Long id) {
        return commentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Message not found"));
    }


    @Override
    public Comment updateComment(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public void delete(Long id) {
        Comment comment = getById(id);
        commentRepository.delete(comment);
    }
}
