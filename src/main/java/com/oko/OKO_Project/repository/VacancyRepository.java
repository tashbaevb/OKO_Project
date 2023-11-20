package com.oko.OKO_Project.repository;

import com.oko.OKO_Project.entity.Vacancy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VacancyRepository extends JpaRepository<Vacancy, Long> {
}
