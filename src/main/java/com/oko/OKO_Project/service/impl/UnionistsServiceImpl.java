package com.oko.OKO_Project.service.impl;

import com.oko.OKO_Project.entity.Unionists;
import com.oko.OKO_Project.enums.UnionistsType;
import com.oko.OKO_Project.repository.UnionistsRepository;
import com.oko.OKO_Project.service.UnionistsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UnionistsServiceImpl implements UnionistsService {

    private final UnionistsRepository unionistsRepository;

    @Override
    public List<Unionists> getAllUnionists() {
        return unionistsRepository.findAll();
    }

    @Override
    public List<Unionists> getUnionistsByType(UnionistsType unionistsType) {
        return unionistsRepository.findByUnionistsType(unionistsType);
    }

    @Override
    public Unionists createUnionists(Unionists unionists) {
        return unionistsRepository.save(unionists);
    }
}
