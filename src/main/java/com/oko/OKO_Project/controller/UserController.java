package com.oko.OKO_Project.controller;

import com.oko.OKO_Project.dto.CommentDto;
import com.oko.OKO_Project.entity.*;
import com.oko.OKO_Project.enums.GovOrgansType;
import com.oko.OKO_Project.enums.NpaType;
import com.oko.OKO_Project.enums.UnionistsType;
import com.oko.OKO_Project.mappers.CommentMapper;
import com.oko.OKO_Project.repository.UserRepository;
import com.oko.OKO_Project.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
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
    private final NpaService npaService;
    private final GovOrgansService govOrgansService;
    private final UnionistsService unionistsService;
    private final CoursesService coursesService;
    private final AboutUsService aboutUsService;
    private final RegistryService registryService;
    private final NewsService newsService;
    private final VacancyService vacancyService;


    // Comments
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
    public List<Comment> getAllComment() {
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


    // NPA
    @GetMapping("/npa/getByType/{type}")
    public List<Npa> getNpaByType(@PathVariable NpaType type) {
        return npaService.getNpaByType(type);
    }


    // Органы Управления
    @GetMapping("/govOrgan/getByType/{type}")
    public List<GovOrgan> getByGovOrganType(@PathVariable GovOrgansType type) {
        return govOrgansService.getGovOrganByType(type);
    }


    // Члены Объединения
    @GetMapping("/unionists/getByType/{type}")
    public List<Unionists> getByUnionistsType(@PathVariable UnionistsType type) {
        return unionistsService.getUnionistsByType(type);
    }


    // Курсы
    @GetMapping("/courses/getAll")
    public List<Courses> getAllCourses() {
        return coursesService.getAllCourses();
    }

    @GetMapping("/courses/getById/{id}")
    public ResponseEntity<Courses> getByCoursesId(@PathVariable Long id) {
        Optional<Courses> courses = coursesService.getCoursesById(id);

        return courses.map(ResponseEntity::ok).orElse(ResponseEntity.noContent().build());
    }


    //About Us
    @GetMapping("/aboutUs/getById/{id}")
    public ResponseEntity<AboutUs> getByAboutUsId(@PathVariable Long id) {
        Optional<AboutUs> aboutUs = aboutUsService.getAboutUsById(id);
        return aboutUs.map(ResponseEntity::ok).orElse(ResponseEntity.noContent().build());
    }

    @GetMapping("aboutUs/getAll")
    public List<AboutUs> getAllAboutUs() {
        return aboutUsService.getAllAboutUs();
    }


    // Registry
    @GetMapping("registry/getById/{id}")
    public ResponseEntity<Registry> getRegistryById(@PathVariable Long id) {
        Optional<Registry> registry = registryService.getRegistryById(id);
        return registry.map(ResponseEntity::ok).orElse(ResponseEntity.noContent().build());
    }

    @GetMapping("registry/getAll")
    public List<Registry> getRegistryAll() {
        return registryService.getRegistryAll();
    }


    //News
    @GetMapping("news/getAll")
    public List<News> getNewsAll() {
        return newsService.getNewsAll();
    }

    @GetMapping("news/getById/{id}")
    public ResponseEntity<News> getNewsById(@PathVariable Long id) {
        Optional<News> news = newsService.getNewsById(id);
        return news.map(ResponseEntity::ok).orElse(ResponseEntity.noContent().build());
    }


    //Vacancies
    @GetMapping("vacancy/getById/{id}")
    public ResponseEntity<Vacancy> getVacancyById(@PathVariable Long id) {
        Optional<Vacancy> vacancy = vacancyService.getVacancyById(id);
        return vacancy.map(ResponseEntity::ok).orElse(ResponseEntity.noContent().build());
    }

    @GetMapping("vacancy/getAll")
    public List<Vacancy> getVacancyAll() {
        return vacancyService.getVacancyAll();
    }
}
