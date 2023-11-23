package com.oko.OKO_Project.service;

import com.oko.OKO_Project.entity.Registry;

import java.util.List;
import java.util.Optional;

public interface RegistryService {

    Optional<Registry> getRegistryById(Long id);

    List<Registry> getRegistryAll();

    Registry createRegistry(Registry registry);
}
