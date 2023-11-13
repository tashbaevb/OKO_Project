package com.oko.OKO_Project.repository;

import com.oko.OKO_Project.entity.GovOrgan;
import com.oko.OKO_Project.enums.GovOrgansType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GovOrgansRepository extends JpaRepository<GovOrgan, Long> {

    List<GovOrgan> findByGovOrgansType(GovOrgansType govOrgansType);
}
