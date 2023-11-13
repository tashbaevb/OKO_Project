package com.oko.OKO_Project.service.impl;

import com.oko.OKO_Project.entity.Npa;
import com.oko.OKO_Project.enums.NpaType;
import com.oko.OKO_Project.repository.NpaRepository;
import com.oko.OKO_Project.service.NpaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NpaServiceImpl implements NpaService {

    private final NpaRepository npaRepository;

    @Override
    public Npa createNpa(Npa npa) {
        return npaRepository.save(npa);
    }

    @Override
    public List<Npa> getAllNpa() {
        return npaRepository.findAll();
    }

    @Override
    public List<Npa> getNpaByType(NpaType npaType) {
        return npaRepository.findByNpaType(npaType);
    }
}
