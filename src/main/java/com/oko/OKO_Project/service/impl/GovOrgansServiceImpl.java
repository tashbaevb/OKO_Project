package com.oko.OKO_Project.service.impl;

import com.oko.OKO_Project.entity.GovOrgan;
import com.oko.OKO_Project.enums.GovOrgansType;
import com.oko.OKO_Project.repository.GovOrgansRepository;
import com.oko.OKO_Project.service.GovOrgansService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GovOrgansServiceImpl implements GovOrgansService {

    private final GovOrgansRepository govOrgansRepository;

    @Override
    public GovOrgan createGovOrgans(GovOrgan govOrgans) {
        return govOrgansRepository.save(govOrgans);
    }

    @Override
    public List<GovOrgan> getAllGovOrgan() {
        return govOrgansRepository.findAll();
    }

    @Override
    public List<GovOrgan> getGovOrganByType(GovOrgansType govOrgansType) {
        return govOrgansRepository.findByGovOrgansType(govOrgansType);
    }
}
