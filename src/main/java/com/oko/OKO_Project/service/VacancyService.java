package com.oko.OKO_Project.service;

import com.oko.OKO_Project.entity.Vacancy;

import java.util.List;
import java.util.Optional;

public interface VacancyService {

    Optional<Vacancy> getVacancyById(Long id);

    List<Vacancy> getVacancyAll();

    Vacancy createVacancy(Vacancy vacancy);
}
