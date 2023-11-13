package com.oko.OKO_Project.repository;

import com.oko.OKO_Project.entity.Unionists;
import com.oko.OKO_Project.enums.UnionistsType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UnionistsRepository extends JpaRepository<Unionists, Long> {

    List<Unionists> findByUnionistsType(UnionistsType unionistsType);
}
