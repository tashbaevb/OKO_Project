package com.oko.OKO_Project.service.impl;

import com.oko.OKO_Project.entity.Vacancy;
import com.oko.OKO_Project.repository.VacancyRepository;
import com.oko.OKO_Project.service.VacancyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VacancyServiceImpl implements VacancyService {

    private final VacancyRepository vacancyRepository;

    @Override
    public Optional<Vacancy> getVacancyById(Long id) {
        return vacancyRepository.findById(id);
    }

    @Override
    public List<Vacancy> getVacancyAll() {
        return vacancyRepository.findAll();
    }

    @Override
    public Vacancy createVacancy(Vacancy vacancy) {
        return vacancyRepository.save(vacancy);
    }
}
