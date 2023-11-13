package com.oko.OKO_Project.controller;

import com.oko.OKO_Project.entity.GovOrgan;
import com.oko.OKO_Project.entity.Npa;
import com.oko.OKO_Project.enums.GovOrgansType;
import com.oko.OKO_Project.enums.NpaType;
import com.oko.OKO_Project.service.GovOrgansService;
import com.oko.OKO_Project.service.NpaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin")
public class HelloController {

    private final NpaService npaService;
    private final GovOrgansService govOrgansService;

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
}
