package com.github.tarcalia.mirango.controller;

import com.github.tarcalia.mirango.entity.Company;
import com.github.tarcalia.mirango.entity.dto.CompanyDto;
import com.github.tarcalia.mirango.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.UUID;

/**
 * Controller for {@link Company} entities.
 */
@RestController
@RequestMapping("/api/company")
public class CompanyController {
    @Autowired
    private CompanyService service;

    @PostMapping
    public CompanyDto create(@RequestBody Company company) {
        return service.save(company);
    }

    @PutMapping
    public CompanyDto update(@RequestBody Company company) {
        return service.save(company);
    }

    @GetMapping("/{id}")
    public Optional<CompanyDto> getById(@PathVariable UUID id) {
        return service.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        service.deleteById(id);
    }
}
