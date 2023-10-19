package com.oko.OKO_Project.controller;

import com.oko.OKO_Project.entity.First;
import com.oko.OKO_Project.service.FirstService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class HelloController {
    private final FirstService firstService;

    @PostMapping("/first")
    public First create(@RequestBody First first) {
        return firstService.create(first);
    }

    @GetMapping("/first")
    public List<First> getAll() {
        return firstService.getAll();
    }
}
