package com.github.tarcalia.mirango.service;

import com.github.tarcalia.mirango.entity.Employee;
import com.github.tarcalia.mirango.entity.dto.EmployeeDto;
import com.github.tarcalia.mirango.repository.EmployeeRepository;
import com.github.tarcalia.mirango.util.Converter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

/**
 * Service class for {@link Employee} entities.
 */
@Service
@Slf4j
public class EmployeeService implements GenericService<Employee, EmployeeDto> {
    @Autowired
    private Converter<Employee, EmployeeDto> converter;
    @Autowired
    private EmployeeRepository repository;

    public EmployeeDto save(Employee entity) {
        log.info("Create/Update employee: {}", entity);
        return converter.toDto(repository.save(entity));
    }

    public Optional<EmployeeDto> findById(UUID id) {
        log.info("Searching for employee: {}", id);
        var entity = repository.findById(id);

        return entity.map(employee -> converter.toDto(employee));
    }

    public void deleteById(UUID id) {
        log.info("Deleting employee: {}", id);
        repository.deleteById(id);
    }
}
