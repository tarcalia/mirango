package com.github.tarcalia.mirango.controller;

import com.github.tarcalia.mirango.entity.Company;
import com.github.tarcalia.mirango.entity.Employee;
import com.github.tarcalia.mirango.entity.dto.CompanyDto;
import com.github.tarcalia.mirango.entity.dto.EmployeeDto;
import com.github.tarcalia.mirango.service.EmployeeService;
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
 * Controller for {@link Employee} entities.
 */
@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService service;

    @PostMapping
    public EmployeeDto create(@RequestBody Employee employee) {
        return service.save(employee);
    }

    @PutMapping
    public EmployeeDto update(@RequestBody Employee employee) {
        return service.save(employee);
    }

    @GetMapping("/{id}")
    public Optional<EmployeeDto> getById(@PathVariable UUID id) {
        return service.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        service.deleteById(id);
    }
}
