package com.oko.OKO_Project.repository;

import com.oko.OKO_Project.entity.First;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FirstRepository extends JpaRepository<First, Long> {
}
