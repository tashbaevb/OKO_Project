package com.oko.OKO_Project.controller;

import com.oko.OKO_Project.dto.CommentDto;
import com.oko.OKO_Project.entity.Comment;
import com.oko.OKO_Project.entity.User;
import com.oko.OKO_Project.mappers.CommentMapper;
import com.oko.OKO_Project.repository.UserRepository;
import com.oko.OKO_Project.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final CommentService commentService;
    private final UserRepository userRepository;
    private final CommentMapper commentMapper;


    // Messages
    @PostMapping("/comment/create")
    public CommentDto createComment(@RequestBody CommentDto commentDto, Authentication authentication) {
        String email = authentication.getName();
        Optional<User> optionalUser = userRepository.findByEmail(email);
        User currentUser = optionalUser.orElseThrow(() -> new IllegalArgumentException("Пользователь не найден: " + email));

        Comment comment = commentMapper.convertToEntity(commentDto);
        comment.setUser(currentUser);

        return commentMapper.convertToDTO(commentService.createComment(comment, currentUser.getId()));
    }


    @PostMapping("/comment/reply/{parentCommentId}")
    public CommentDto createReplyComment(@RequestBody CommentDto commentDto, @PathVariable Long parentCommentId, Authentication authentication) {
        String email = authentication.getName();
        Optional<User> optionalUser = userRepository.findByEmail(email);
        User currentUser = optionalUser.orElseThrow(() -> new IllegalArgumentException("Пользователь не найден: " + email));

        Comment comment = commentMapper.convertToEntity(commentDto);

        return commentMapper.convertToDTO(commentService.createReplyComment(comment, currentUser.getId(), parentCommentId));
    }


    @GetMapping("/comment/get/replies/{commentId}")
    public List<CommentDto> getRepliesComment(@PathVariable Long commentId) {
        List<Comment> replies = commentService.getRepliesComment(commentId);

        return commentMapper.convertToDTOList(replies);
    }


    @GetMapping("/comment/get/{commentId}")
    public CommentDto getCommentById(@PathVariable Long commentId) {
        return commentMapper.convertToDTO(commentService.getById(commentId));
    }

    @GetMapping("/comment/getAll")
    public List<Comment> getAllNpa() {
        return commentService.getAllComment();
    }


    @PutMapping("/comment/update/{commentId}")
    public CommentDto updateComment(@RequestBody CommentDto commentDto, @PathVariable Long commentId, Authentication authentication) {

        Comment comment = commentService.getById(commentId);
        Optional<User> optionalUser = userRepository.findByEmail(authentication.getName());
        User currentUser = optionalUser.orElseThrow(() -> new IllegalArgumentException("Пользователь не найден: " + authentication.getName()));

        if (!comment.getUser().getId().equals(currentUser.getId())) {
            throw new AccessDeniedException("You are not a vladelec");
        }

        comment.setText(commentDto.getText());

        return commentMapper.convertToDTO(commentService.updateComment(comment));
    }


    @DeleteMapping("/comment/delete/{commentId}")
    public void deleteComment(@PathVariable Long commentId, Authentication authentication) {
        Comment existingComment = commentService.getById(commentId);
        Optional<User> optionalUser = userRepository.findByEmail(authentication.getName());
        User currentUser = optionalUser.orElseThrow(() -> new IllegalArgumentException("Пользователь не найден: " + authentication.getName()));
        if (!existingComment.getUser().getId().equals(currentUser.getId())) {
            throw new AccessDeniedException("Its not your comment");
        }

        commentService.delete(commentId);
    }
}
