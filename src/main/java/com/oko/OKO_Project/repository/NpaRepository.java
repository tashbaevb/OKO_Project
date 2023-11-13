package com.oko.OKO_Project.repository;

import com.oko.OKO_Project.entity.Npa;
import com.oko.OKO_Project.enums.NpaType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NpaRepository extends JpaRepository<Npa, Long> {

    List<Npa> findByNpaType(NpaType npaType);
}
