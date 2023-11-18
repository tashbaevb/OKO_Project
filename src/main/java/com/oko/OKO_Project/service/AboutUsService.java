package com.oko.OKO_Project.service;

import com.oko.OKO_Project.entity.AboutUs;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

public interface AboutUsService {

    Optional<AboutUs> getAboutUsById(Long id);

    List<AboutUs> getAllAboutUs();

    AboutUs createAboutUs(AboutUs aboutUs);
}
