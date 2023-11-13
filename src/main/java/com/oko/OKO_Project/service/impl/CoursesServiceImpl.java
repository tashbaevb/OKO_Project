package com.oko.OKO_Project.service.impl;

import com.oko.OKO_Project.entity.Courses;
import com.oko.OKO_Project.repository.CoursesRepository;
import com.oko.OKO_Project.service.CoursesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CoursesServiceImpl implements CoursesService {

    private final CoursesRepository coursesRepository;

    @Override
    public List<Courses> getAllCourses() {
        return coursesRepository.findAll();
    }

    @Override
    public Courses createCourses(Courses courses) {
        return coursesRepository.save(courses);
    }

    @Override
    public Optional<Courses> getCoursesById(Long id) {
        return coursesRepository.findById(id);
    }
}
