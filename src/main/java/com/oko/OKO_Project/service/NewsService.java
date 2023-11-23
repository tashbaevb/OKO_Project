package com.oko.OKO_Project.service;

import com.oko.OKO_Project.entity.News;

import java.util.List;
import java.util.Optional;

public interface NewsService {

    Optional<News> getNewsById(Long id);

    List<News> getNewsAll();

    News createNews(News news);
}
