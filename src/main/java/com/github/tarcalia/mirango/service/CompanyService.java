package com.github.tarcalia.mirango.service;

import com.github.tarcalia.mirango.entity.Company;
import com.github.tarcalia.mirango.entity.dto.CompanyDto;
import com.github.tarcalia.mirango.repository.CompanyRepository;
import com.github.tarcalia.mirango.util.Converter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

/**
 * Service class for {@link Company} entities.
 */
@Service
@Slf4j
public class CompanyService implements GenericService<Company, CompanyDto> {
    @Autowired
    private Converter<Company, CompanyDto> converter;
    @Autowired
    private CompanyRepository repository;

    public CompanyDto save(Company entity) {
        log.info("Create/Update company: {}", entity);
        return converter.toDto(repository.save(entity));
    }

    public Optional<CompanyDto> findById(UUID id) {
        log.info("Searching for company: {}", id);
        var entity = repository.findById(id);

        return entity.map(company -> converter.toDto(company));
    }

    public void deleteById(UUID id) {
        log.info("Deleting company: {}", id);
        repository.deleteById(id);
    }
}
