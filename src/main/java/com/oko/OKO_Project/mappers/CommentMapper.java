package com.oko.OKO_Project.mappers;

import com.oko.OKO_Project.dto.CommentDto;
import com.oko.OKO_Project.entity.Comment;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CommentMapper {

    private final ModelMapper mapper;

    public List<CommentDto> convertToDTOList(List<Comment> comments) {
        return comments.stream().map(this::convertToDTO).collect(Collectors.toList());
    }


    public CommentDto convertToDTO(Comment comment) {
        CommentDto dto = mapper.map(comment, CommentDto.class);
        dto.setUserEmail(comment.getUser().getEmail());
        return dto;
    }

    public Comment convertToEntity(CommentDto commentDto){
        Comment comment = new Comment();
        comment.setId(commentDto.getId());
        comment.setText(commentDto.getText());
        return comment;
    }
}
