package com.oko.OKO_Project.service.impl;

import com.oko.OKO_Project.entity.First;
import com.oko.OKO_Project.repository.FirstRepository;
import com.oko.OKO_Project.service.FirstService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FirstServiceImpl implements FirstService {

    private final FirstRepository firstRepository;

    @Override
    public First create(First first) {
        return firstRepository.save(first);
    }

    @Override
    public List<First> getAll() {
        return firstRepository.findAll();
    }
}
