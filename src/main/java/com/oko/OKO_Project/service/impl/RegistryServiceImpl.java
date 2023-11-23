package com.oko.OKO_Project.service.impl;

import com.oko.OKO_Project.entity.Registry;
import com.oko.OKO_Project.repository.RegistryRepository;
import com.oko.OKO_Project.service.RegistryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RegistryServiceImpl implements RegistryService {

    private final RegistryRepository registryRepository;

    @Override
    public Optional<Registry> getRegistryById(Long id) {
        return registryRepository.findById(id);
    }

    @Override
    public List<Registry> getRegistryAll() {
        return registryRepository.findAll();
    }

    @Override
    public Registry createRegistry(Registry registry) {
        return registryRepository.save(registry);
    }
}
