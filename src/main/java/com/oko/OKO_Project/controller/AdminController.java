package com.oko.OKO_Project.controller;

import com.oko.OKO_Project.entity.Courses;
import com.oko.OKO_Project.entity.GovOrgan;
import com.oko.OKO_Project.entity.Npa;
import com.oko.OKO_Project.entity.Unionists;
import com.oko.OKO_Project.enums.GovOrgansType;
import com.oko.OKO_Project.enums.NpaType;
import com.oko.OKO_Project.enums.UnionistsType;
import com.oko.OKO_Project.service.*;
import io.github.classgraph.Resource;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {

    private final NpaService npaService;
    private final GovOrgansService govOrgansService;
    private final UnionistsService unionistsService;
    private final CoursesService coursesService;


    // НПА
    @PostMapping("/npa/create")
    public Npa createNpa(@RequestBody Npa npa, @RequestParam NpaType type) {
        npa.setNpaType(type);
        return npaService.createNpa(npa);
    }

    @GetMapping("/npa/getAll")
    public List<Npa> getAllNpa() {
        return npaService.getAllNpa();
    }

    @GetMapping("/npa/getByType/{type}")
    public List<Npa> getNpaByType(@PathVariable NpaType type) {
        return npaService.getNpaByType(type);
    }


    // Органы Управления
    @PostMapping("/govOrgan/create")
    public GovOrgan createGovOrgan(@RequestBody GovOrgan govOrgans, @RequestParam GovOrgansType govOrgansType) {
        govOrgans.setGovOrgansType(govOrgansType);
        return govOrgansService.createGovOrgans(govOrgans);
    }

    @GetMapping("/govOrgan/getAll")
    public List<GovOrgan> getAllGovOrgan() {
        return govOrgansService.getAllGovOrgan();
    }

    @GetMapping("/govOrgan/getByType/{type}")
    public List<GovOrgan> getByGovOrganType(@PathVariable GovOrgansType type) {
        return govOrgansService.getGovOrganByType(type);
    }


    // Члены Объединения
    @PostMapping("/unionists/create")
    public Unionists createUnionists(@RequestBody Unionists unionists, @RequestParam UnionistsType unionistsType) {
        unionists.setUnionistsType(unionistsType);
        return unionistsService.createUnionists(unionists);
    }


    @GetMapping("/unionists/getAll")
    public List<Unionists> getAllUnionists() {
        return unionistsService.getAllUnionists();
    }

    @GetMapping("/unionists/getByType/{type}")
    public List<Unionists> getByUnionistsType(@PathVariable UnionistsType type) {
        return unionistsService.getUnionistsByType(type);
    }


    // Курсы
    @PostMapping("/courses/create")
    public Courses createCourses(@RequestBody Courses courses) {
        return coursesService.createCourses(courses);
    }

    @GetMapping("/courses/getAll")
    public List<Courses> getAllCourses() {
        return coursesService.getAllCourses();
    }

    @GetMapping("/courses/getById/{id}")
    public ResponseEntity<Courses> getByCoursesId(@PathVariable Long id) {
        Optional<Courses> courses = coursesService.getCoursesById(id);

        return courses.map(ResponseEntity::ok).orElse(ResponseEntity.noContent().build());
    }
}
