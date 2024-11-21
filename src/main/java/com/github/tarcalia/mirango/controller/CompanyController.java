package com.github.tarcalia.mirango.controller;

import com.github.tarcalia.mirango.entity.Company;
import com.github.tarcalia.mirango.entity.dto.CompanyDto;
import com.github.tarcalia.mirango.service.CompanyService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller for {@link Company} entities.
 */
@RestController
@RequestMapping("/api/company")
public class CompanyController extends GenericController<Company, CompanyDto, CompanyService> {
}
