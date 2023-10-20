package com.oko.OKO_Project.controller;

import com.oko.OKO_Project.entity.First;
import com.oko.OKO_Project.service.FirstService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Tag(name = "First API", description = "API for managing First entities")
public class HelloController {
    private final FirstService firstService;

    @PostMapping("/first")
    @Operation(summary = "Create First Entity", description = "Create a new First entity")
    public First create(@RequestBody First first) {
        return firstService.create(first);
    }

    @GetMapping("/first")
    @Operation(summary = "Get All First Entities", description = "Retrieve all First entities")
    public List<First> getAll() {
        return firstService.getAll();
    }
}
