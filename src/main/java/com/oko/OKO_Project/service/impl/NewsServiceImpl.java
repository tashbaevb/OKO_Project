package com.oko.OKO_Project.service.impl;

import com.oko.OKO_Project.entity.News;
import com.oko.OKO_Project.repository.NewsRepository;
import com.oko.OKO_Project.service.NewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class NewsServiceImpl implements NewsService {

    private final NewsRepository newsRepository;

    @Override
    public Optional<News> getNewsById(Long id) {
        return newsRepository.findById(id);
    }

    @Override
    public List<News> getNewsAll() {
        return newsRepository.findAll();
    }

    @Override
    public News createNews(News news) {
        return newsRepository.save(news);
    }
}
