package com.oko.OKO_Project.service.impl;

import com.oko.OKO_Project.entity.AboutUs;
import com.oko.OKO_Project.repository.AboutUsRepository;
import com.oko.OKO_Project.service.AboutUsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AboutUsServiceImpl implements AboutUsService {

    private final AboutUsRepository aboutUsRepository;

    @Override
    public Optional<AboutUs> getAboutUsById(Long id) {
        return aboutUsRepository.findById(id);
    }

    @Override
    public List<AboutUs> getAllAboutUs() {
        return aboutUsRepository.findAll();
    }

    @Override
    public AboutUs createAboutUs(AboutUs aboutUs) {
        return aboutUsRepository.save(aboutUs);
    }
}
