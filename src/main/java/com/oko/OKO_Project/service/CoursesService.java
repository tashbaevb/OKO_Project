package com.oko.OKO_Project.service;

import com.oko.OKO_Project.entity.Courses;

import java.util.List;
import java.util.Optional;

public interface CoursesService {

    Courses createCourses(Courses courses);

    List<Courses> getAllCourses();

    Optional<Courses> getCoursesById(Long id);
}
