package com.oko.OKO_Project.service;

import com.oko.OKO_Project.entity.Comment;

import java.util.List;

public interface CommentService {

    Comment createComment(Comment comment, Long userId);

    Comment createReplyComment(Comment comment, Long parentCommentId, Long userId);

    List<Comment> getRepliesComment(Long commentId);

    Comment getById(Long id);

    List<Comment> getAllComment();

    Comment updateComment(Comment comment);

    void delete(Long id);
}
